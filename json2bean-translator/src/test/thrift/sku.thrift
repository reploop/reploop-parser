include "sku/result.thrift"
struct Sku {
    1: optional string reason;
    2: optional list<result.Result> result;
    3: optional string resultCode;
    4: optional bool success;
    
}