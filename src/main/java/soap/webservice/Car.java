
package soap.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for car complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="car">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CarID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CarRentCost" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CarCondition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CarModel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CarMileage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isRent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "car", propOrder = {
    "carID",
    "carRentCost",
    "carCondition",
    "carModel",
    "carMileage",
    "isRent"
})
public class Car {

    @XmlElement(name = "CarID")
    protected int carID;
    @XmlElement(name = "CarRentCost")
    protected int carRentCost;
    @XmlElement(name = "CarCondition")
    protected String carCondition;
    @XmlElement(name = "CarModel")
    protected String carModel;
    @XmlElement(name = "CarMileage")
    protected int carMileage;
    protected String isRent;

    /**
     * Gets the value of the carID property.
     * 
     */
    public int getCarID() {
        return carID;
    }

    /**
     * Sets the value of the carID property.
     * 
     */
    public void setCarID(int value) {
        this.carID = value;
    }

    /**
     * Gets the value of the carRentCost property.
     * 
     */
    public int getCarRentCost() {
        return carRentCost;
    }

    /**
     * Sets the value of the carRentCost property.
     * 
     */
    public void setCarRentCost(int value) {
        this.carRentCost = value;
    }

    /**
     * Gets the value of the carCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarCondition() {
        return carCondition;
    }

    /**
     * Sets the value of the carCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarCondition(String value) {
        this.carCondition = value;
    }

    /**
     * Gets the value of the carModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarModel() {
        return carModel;
    }

    /**
     * Sets the value of the carModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarModel(String value) {
        this.carModel = value;
    }

    /**
     * Gets the value of the carMileage property.
     * 
     */
    public int getCarMileage() {
        return carMileage;
    }

    /**
     * Sets the value of the carMileage property.
     * 
     */
    public void setCarMileage(int value) {
        this.carMileage = value;
    }

    /**
     * Gets the value of the isRent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsRent() {
        return isRent;
    }

    /**
     * Sets the value of the isRent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsRent(String value) {
        this.isRent = value;
    }

}
