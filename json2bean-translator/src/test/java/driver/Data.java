package driver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import driver.data.DriverData; 
import com.fasterxml.jackson.annotation.JsonProperty; 
import driver.data.CarData; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("car_data")
    private CarData carData;
    @JsonProperty("driver_data")
    private DriverData driverData;
    
    public CarData getCarData() {
        return carData;
    }
    
    public void setCarData(CarData carData) {
        this.carData = carData;
    }
    
    public DriverData getDriverData() {
        return driverData;
    }
    
    public void setDriverData(DriverData driverData) {
        this.driverData = driverData;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("carData", carData)
                .add("driverData", driverData)
                .toString();
    }
    
}
