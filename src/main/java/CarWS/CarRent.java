package CarWS;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.IOException;

@WebService
public interface CarRent {
    @WebMethod
    public void showAllCars();
    @WebMethod()
    public void addNewCar(String carModel, int carMileage, String carCondition, int rentCost) throws IOException;
    @WebMethod()
    public void showCertainCars(String carModel);
    @WebMethod()
    public void changeCarSpecifications(int ID, String carCondition, int carMileage) throws IOException;
    @WebMethod()
    public void rentCar(int ID, int DaysCount) throws IOException;
    @WebMethod()
    public void backCar(int ID) throws IOException;
}
