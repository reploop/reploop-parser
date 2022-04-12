include "name_value.thrift"
namespace * har.log.entries
struct RequestResponse {
    1: optional i32 bodySize;
    2: optional list<name_value.NameValue> cookies;
    3: optional list<name_value.NameValue> headers;
    4: optional i32 headersSize;
    5: optional string httpVersion;
    
}