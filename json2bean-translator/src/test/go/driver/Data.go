package driver

import "driver/data"
type Data struct {
    CarData data.CarData `json:"car_data"`
    DriverData data.DriverData `json:"driver_data"`
    
}
