include "records_user_order_additional.thrift"
namespace * order.data.records
struct UserOrderAdditional {
    1: optional string actionSource;
    2: optional string adultNum;
    3: optional string beginSiteName;
    4: optional string createTime;
    5: optional string createUser;
    6: optional string delFlag;
    7: optional string delay;
    8: optional string driverId;
    9: optional string driverIdNo;
    10: optional string driverName;
    11: optional string driverOrderId;
    12: optional string driverPhone;
    13: optional string endSiteName;
    14: optional string flightNumber;
    15: optional string id;
    16: optional string newDriverOrderId;
    17: optional bool night;
    18: optional string operator;
    19: optional string orderId;
    20: optional string orderRemark;
    21: optional string preDriverId;
    22: optional string remarks;
    23: optional string scheduleDate;
    24: optional string settlementPrice;
    25: optional string status;
    26: optional string updateTime;
    27: optional string updateUser;
    28: optional string vehicleBrand;
    29: optional string vehicleColour;
    30: optional i32 vehicleId;
    31: optional string vehiclePlate;
    32: optional string vehicleType;
    
}