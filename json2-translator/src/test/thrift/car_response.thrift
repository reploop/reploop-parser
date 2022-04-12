include "carResponse/rows.thrift"
struct CarResponse {
    1: optional i32 code;
    2: optional string msg;
    3: optional list<rows.Rows> rows;
    4: optional i32 total;
    
}