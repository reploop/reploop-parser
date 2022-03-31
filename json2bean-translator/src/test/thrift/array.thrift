include "array/data.thrift"
struct Array {
    1: optional string code;
    2: optional list<data.Data> data;
    3: optional list<string> empty;
    
}