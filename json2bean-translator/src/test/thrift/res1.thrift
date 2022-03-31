include "res1/error.thrift"
include "res1/data.thrift"
struct Res1 {
    1: optional data.Data data;
    2: optional error.Error error;
    
}