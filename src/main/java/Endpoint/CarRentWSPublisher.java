package Endpoint;

import javax.xml.ws.Endpoint;
import CarWS.CarRentImpl;

public class CarRentWSPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/wss/car-rent", new CarRentImpl());
    }
}
