include "../java/time/local_date_time.thrift"
namespace * marketing
struct Result {
    1: optional string beginTime;
    2: optional local_date_time.LocalDateTime createTime;
    3: optional string endTime;
    4: optional i32 marketingId;
    5: optional string marketingName;
    6: optional i32 marketingType;
    7: optional bool pause;
    
}