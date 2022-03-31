include "driver/data.thrift"
struct Driver {
    1: optional data.Data data;
    2: optional string errmsg;
    3: optional i32 errno;
    4: optional string trace_id;
    
}