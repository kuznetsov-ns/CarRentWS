package CarWS;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Enumeration;
import java.util.Hashtable;
import java.io.IOException;

@WebService()
public class CarRentImpl implements CarRent {
    private Hashtable hash;
    private int totalCars;

    public CarRentImpl() {
        hash = new Hashtable();
        totalCars = 0;
    }

    @WebMethod()
    public void showAllCars() {
        Enumeration allCars;
        String str;
        allCars = hash.keys();
        while (allCars.hasMoreElements()) {
            str = (String) allCars.nextElement();
            System.out.println(str + ":" + hash.get(str));
        }
    }

    @WebMethod()
    public void addNewCar(String carModel, int carMileage, String carCondition, int rentCost) throws IOException {
        Car newCar = new Car(totalCars, rentCost, carCondition, carModel, carMileage);
        hash.put(newCar.CarID, newCar);
        System.out.println("Car ID = " + totalCars);
        totalCars++;
    }

    @WebMethod()
    public void showCertainCars(String carModel) {
        int totalCarsFound = 0;
        for (int i = 0; i < totalCars - 1; i++) {
            Car c = (Car) hash.get(i);
            if (c.CarModel == carModel) {
                System.out.println(c);
                totalCarsFound++;
            }
        }
        if (totalCarsFound == 0)
            System.out.println("No matches found!");
    }

    @WebMethod()
    public void changeCarSpecifications(int ID, String carCondition, int carMileage) throws IOException {
        Car c = (Car) hash.get(ID);
        if (carCondition != "excellent" || carCondition != "good" || carCondition != "average") {
            throw new IOException("Wrong car condition!");
        } else if (carMileage <= c.CarMileage) {
            throw new IOException("Wrong car mileage");
        }
        c.CarCondition = carCondition;
        c.CarMileage = carMileage;
        hash.put(ID, c);
    }

    @WebMethod()
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
        int totalCost = DaysCount * c.CarRentCost;
        c.isRent = "YES";
        hash.put(ID, c);
        System.out.println("Total rent cost is " + totalCost);
    }

    @WebMethod()
    public void backCar(int ID) throws IOException {
        if (ID < 0 || ID > totalCars) {
            throw new IOException("Wrong car ID");
        }
        Car c = (Car) hash.get(ID);
        c.isRent = "NO";
        hash.put(ID, c);
    }
}