include "order/data.thrift"
struct Order {
    1: optional i32 code;
    2: optional data.Data data;
    3: optional string msg;
    
}