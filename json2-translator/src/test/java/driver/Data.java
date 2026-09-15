package driver;

import driver.data.DriverData;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
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
                .add("carData", getCarData())
                .add("driverData", getDriverData())
                .toString();
    }
    
    public static Builder newDataBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Data data = new Data();
        
        public Builder carData(CarData carData) {
            data.setCarData(carData);
            return this;
        }
        
        public Builder driverData(DriverData driverData) {
            data.setDriverData(driverData);
            return this;
        }
        
        public Data build() {
            return data;
        }
        
    }
    
}
