package CarRentClient;

import java.io.IOException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import CarWS.CarRent;

public class CarRentClient {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/wss/car-rent?wsdl");
        QName qname = new QName("http://CarWS/", "CarRentImplService");
        Service service = Service.create(url, qname);
        CarRent car = service.getPort(CarRent.class);
        car.addNewCar("Mazda", 1000, "excellent", 100);
        car.addNewCar("Mazda", 1000, "excellent", 100);
        car.addNewCar("Nissan", 2000, "good", 75);
        car.addNewCar("Nissan", 2000, "good", 75);
        car.addNewCar("Nissan", 2000, "good", 75);
        car.showAllCars();
        //car.changeCarSpecifications(2, "good", 15000);
        //car.rentCar(4, 15);
        //car.backCar(4);
        car.showCertainCars("Mazda");
    }
}
