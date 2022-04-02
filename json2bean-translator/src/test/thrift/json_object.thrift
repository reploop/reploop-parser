include "jsonObject/array.thrift"
include "jsonObject/data.thrift"
struct JsonObject {
    1: optional list<array.Array> array;
    2: optional data.Data data;
    
}