package soap;

import java.io.IOException;

public class Car {
    public int CarID;
    public int CarRentCost;
    public String CarCondition;
    public String CarModel;
    public int CarMileage;
    public String isRent;
    public Car() {};
    public Car(int CarID, int CarRentCost, String CarCondition, String CarModel, int CarMileage) throws IOException {
        if (CarRentCost <= 0) {
            throw new IOException("Wrong rent cost!");
        } else if (CarMileage <= 0) {
            throw new IOException("Wrong car mileage");
        }
        this.CarID = CarID;
        this.CarRentCost = CarRentCost;
        this.CarCondition = CarCondition;
        this.CarModel = CarModel;
        this.CarMileage = CarMileage;
        this.isRent = "NO";
    }
    public Car(Car car) {
        this.CarID = car.CarID;
        this.CarRentCost = car.CarRentCost;
        this.CarCondition = car.CarCondition;
        this.CarModel = car.CarModel;
        this.CarMileage = car.CarMileage;
        this.isRent = car.isRent;
    }

    @Override
    public String toString() {
        return "ID = " + CarID + " | Car model = "
                + CarModel + " | Car condition = "
                + CarCondition + " | Car mileage = "
                + CarMileage + " | Car rent cost = "
                + CarRentCost + "$" + " | is rent? "
                + isRent + "";
    }
}

