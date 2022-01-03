package soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Hashtable;
import java.io.IOException;
import java.util.Vector;
import javax.xml.ws.Endpoint;

@WebService
public class CarRentServer {
    public static final int port = 8080;

    private Hashtable hash;
    private int totalCars;
    private int totalCost;
    private Vector foundCars;

    public CarRentServer() {
        hash = new Hashtable();
        totalCars = 0;
        totalCost = 0;
        foundCars = new Vector();
    }

    @WebMethod
    public int returnTotalCost() {
        return totalCost;
    }

    @WebMethod
    public int returnTotalCars() {
        return totalCars;
    }

    @WebMethod
    public Car returnObjCars(int ID) {
        return (Car) hash.get(ID);
    }

    @WebMethod
    public Vector returnFoundCars() {
        return foundCars;
    }

    @WebMethod
    public void clearFoundCars() {
        foundCars.clear();
    }

    @WebMethod
    public void showAllCars() {
        for (int i = 0; i < totalCars; i++) {
            System.out.println(hash.get(i).toString());
        }
    }

    @WebMethod
    public void addNewCar(String carModel, int carMileage, String carCondition, int rentCost) throws IOException {
        Car newCar = new Car(totalCars, rentCost, carCondition, carModel, carMileage);
        hash.put(newCar.CarID, newCar);
        System.out.println("New car ID = " + totalCars);
        totalCars++;
    }

    @WebMethod
    public void showCertainCars(String carModel) {
        int totalCarsFound = 0;
        System.out.println("\n" + carModel + " cars: \n");
        for (int i = 0; i < totalCars; i++) {
            Car c = (Car) hash.get(i);
            if (c.CarModel.equals(carModel)) {
                System.out.println(hash.get(i).toString());
                foundCars.add(i);
                totalCarsFound++;
            }
        }
        if (totalCarsFound == 0)
            System.out.println("No matches found!");
    }

    @WebMethod
    public void changeCarSpecifications(int ID, String carCondition, int carMileage) throws IOException {
        Car c = (Car) hash.get(ID);
        if (carMileage <= c.CarMileage) {
            throw new IOException("Wrong car mileage");
        }
        c.CarCondition = carCondition;
        c.CarMileage = carMileage;
        hash.put(ID, c);
    }

    @WebMethod
    public void rentCar(int ID, int DaysCount) throws IOException {
        if (DaysCount <= 0) {
            throw new IOException("Wrong number of days!");
        } else if (ID < 0 || ID > totalCars) {
            throw new IOException("Wrong car ID");
        }
        Car c = (Car) hash.get(ID);
        if (c.isRent == "YES") {
            throw new IOException("Car is already rent!");
        }
        totalCost = DaysCount * c.CarRentCost;
        c.isRent = "YES";
        hash.put(ID, c);
        System.out.println("Total rent cost is " + totalCost);
    }

    @WebMethod
    public void backCar(int ID) throws IOException {
        if (ID < 0 || ID > totalCars) {
            throw new IOException("Wrong car ID");
        }
        Car c = (Car) hash.get(ID);
        c.isRent = "NO";
        hash.put(ID, c);
    }

    public static void main(String[] args) {
        CarRentServer service = new CarRentServer();
        String url = String.format("http://localhost:%d/CarRent", port);
        Endpoint.publish(url, service);
    }
}