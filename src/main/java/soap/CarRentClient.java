package soap;

import soap.webservice.CarRentServer;
import soap.webservice.CarRentServerService;
import soap.webservice.IOException_Exception;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class CarRentClient {
    public static final int port = 8080;
    public static final String url = "http://localhost:8080/CarRent?wsdl";

    public static void main(String[] args) throws IOException, IOException_Exception {
        CarRentServer service = new CarRentServerService(
                new URL(String.format(url, port))).getCarRentServerPort();
        //service.setClientID();
        service.addNewCar("Nissan Cefiro", 17546, "good", 50);
        service.addNewCar("Mazda MX-5", 9341, "excellent", 100);
        service.addNewCar("Toyota Crown", 82739, "average", 15);
        while (true) {
            System.out.println("CAR RENT SERVICE\n\nEnter 1 - for EMPLOYEE, 2 - for CLIENT, 3 - EXIT\n");
            Scanner scanner = new Scanner(System.in);
            InputStream inputStream = System.in;
            Reader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            int sw = scanner.nextInt();
            switch (sw) {
                case 1: {
                    while (true) {
                        System.out.println("Enter the right number to do anything:");
                        System.out.println("1 - add new car");
                        System.out.println("2 - show all cars");
                        System.out.println("3 - show certain cars");
                        System.out.println("4 - change car specification");
                        System.out.println("5 - exit\n");
                        int input_value = scanner.nextInt();
                        switch (input_value) {
                            case 1: {
                                System.out.println("Enter model: ");
                                String model = bufferedReader.readLine();
                                System.out.println("Enter mileage: ");
                                String mileage = bufferedReader.readLine();
                                int _mileage = Integer.parseInt(mileage);
                                System.out.println("Enter car condition: ");
                                String condition = bufferedReader.readLine();
                                System.out.println("Enter rent cost per day: ");
                                String cost = bufferedReader.readLine();
                                int _cost = Integer.parseInt(cost);
                                service.addNewCar(model, _mileage, condition, _cost);
                                int ID = service.returnTotalCars() - 1;
                                System.out.println("New car ID: " + ID);
                                break;
                            }
                            case 2: {
                                int count = service.returnTotalCars();
                                if (count == 0)
                                    System.out.println("No cars!");
                                soap.webservice.Car fcar;
                                for (int i = 0; i < count; i++) {
                                    fcar = service.returnObjCars(i);
                                    System.out.println("ID = " + fcar.getCarID()+ " | Model: " + fcar.getCarModel() +
                                            " | Mileage: " + fcar.getCarMileage() + " | Car condition: " +
                                            fcar.getCarCondition() + " | Daily rent cost: " + fcar.getCarRentCost() +
                                            " | Is rent? " + fcar.getIsRent());
                                }
                                break;
                            }
                            case 3: {
                                System.out.println("Enter model you want to search: ");
                                String model = bufferedReader.readLine();
                                service.showCertainCars(model);
                                List cars = service.returnFoundCars();
                                if (cars.isEmpty()) {
                                    System.out.println("No cars found!");
                                    break;
                                }
                                soap.webservice.Car fcar;
                                for (int i = 0; i < cars.size(); i++) {
                                    int tmp = (int) cars.get(i);
                                    fcar = service.returnObjCars(tmp);
                                    System.out.println("ID = " + fcar.getCarID()+ " | Model: " + fcar.getCarModel() +
                                            " | Mileage: " + fcar.getCarMileage() + " | Car condition: " +
                                            fcar.getCarCondition() + " | Daily rent cost: " + fcar.getCarRentCost() +
                                            " | Is rent? " + fcar.getIsRent());
                                }
                                service.clearFoundCars();
                                break;
                            }
                            case 4: {
                                System.out.println("Enter ID: ");
                                String ID = bufferedReader.readLine();
                                int _id = Integer.parseInt(ID);
                                System.out.println("Enter mileage: ");
                                String mileage = bufferedReader.readLine();
                                int _mileage = Integer.parseInt(mileage);
                                System.out.println("Enter car condition: ");
                                String condition = bufferedReader.readLine();
                                service.changeCarSpecifications(_id, condition, _mileage);
                                break;
                            }
                            default: {
                                System.out.println("Wrong value\n");
                            }
                        }
                        if (input_value == 5)
                            break;
                    }
                }
                case 2: {
                    while (true) {
                        System.out.println("Enter the right number to do anything:");
                        System.out.println("1 - show all cars");
                        System.out.println("2 - show certain cars");
                        System.out.println("3 - rent car");
                        System.out.println("4 - back car");
                        System.out.println("5 - exit\n");
                        int input_value = scanner.nextInt();
                        switch (input_value) {
                            case 1: {
                                int count = service.returnTotalCars();
                                if (count == 0)
                                    System.out.println("No cars!");
                                soap.webservice.Car fcar;
                                for (int i = 0; i < count; i++) {
                                    fcar = service.returnObjCars(i);
                                    System.out.println("ID = " + fcar.getCarID()+ " | Model: " +
                                            fcar.getCarModel() + " | Mileage: " + fcar.getCarMileage() +
                                            " | Car condition: " + fcar.getCarCondition() + " | Daily rent cost: " +
                                            fcar.getCarRentCost() + " | Is rent? " + fcar.getIsRent());
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("Enter model you want to search: ");
                                String model = bufferedReader.readLine();
                                service.showCertainCars(model);
                                List cars = service.returnFoundCars();
                                if (cars.isEmpty()) {
                                    System.out.println("No cars found!");
                                    break;
                                }
                                soap.webservice.Car fcar;
                                for (int i = 0; i < cars.size(); i++) {
                                    int tmp = (int) cars.get(i);
                                    fcar = service.returnObjCars(tmp);
                                    System.out.println("ID = " + fcar.getCarID()+ " | Model: " + fcar.getCarModel() +
                                            " | Mileage: " + fcar.getCarMileage() + " | Car condition: " +
                                            fcar.getCarCondition() + " | Daily rent cost: " + fcar.getCarRentCost() +
                                            " | Is rent? " + fcar.getIsRent());
                                }
                                service.clearFoundCars();
                                break;
                            }
                            case 3: {
                                System.out.println("Enter ID: ");
                                String id = bufferedReader.readLine();
                                int _id = Integer.parseInt(id);
                                System.out.println("Enter number of days: ");
                                String count = bufferedReader.readLine();
                                int _count = Integer.parseInt(count);
                                service.rentCar(_id, _count);
                                int i = service.returnTotalCost();
                                System.out.println("Total cost for " + _count + " days is " + i);
                                break;
                            }
                            case 4: {
                                System.out.println("Enter ID: ");
                                String ID = bufferedReader.readLine();
                                int _id = Integer.parseInt(ID);
                                service.backCar(_id);
                                break;
                            }
                            default: {
                                System.out.println("Wrong value\n");
                            }
                        }
                        if (input_value == 5)
                            break;
                    }
                }
            }
            if (sw == 3)
                break;
        }
    }
}
