include "user/result.thrift"
struct User {
    1: optional i32 code;
    2: optional i32 count;
    3: optional string date;
    4: optional string error;
    5: optional list<result.Result> result;
    
}