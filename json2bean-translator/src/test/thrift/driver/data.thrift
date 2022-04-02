include "data/driver_data.thrift"
include "data/car_data.thrift"
namespace * driver
struct Data {
    1: optional car_data.CarData car_data;
    2: optional driver_data.DriverData driver_data;
    
}