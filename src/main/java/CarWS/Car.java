package CarWS;

import java.io.IOException;

public class Car {
    public int CarID;
    public int CarRentCost;
    public String CarCondition;
    public String CarModel;
    public int CarMileage;
    public String isRent;
    public Car() {}
    public Car(int CarID, int CarRentCost, String CarCondition, String CarModel, int CarMileage) throws IOException {
        if (CarRentCost <= 0) {
            throw new IOException("Wrong rent cost!");
        } else if (CarCondition != "excellent" || CarCondition != "good" || CarCondition != "average") {
            throw new IOException("Wrong car condition!");
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

    @Override
    public String toString() {
        return "ID = " + CarID +
                "\tCar model = '" + CarModel +
                "\tCar condition = " + CarCondition +
                "\tCar mileage = " + CarMileage +
                "\tCar rent cost = " + CarRentCost + "$" +
                "\tis rent? '" + isRent + "";
    }
}
