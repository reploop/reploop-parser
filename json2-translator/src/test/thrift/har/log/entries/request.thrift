include "request/post_data.thrift"
include "name_value.thrift"
include "name_value.thrift"
namespace * har.log.entries
struct Request {
    1: optional i32 bodySize;
    2: optional list<name_value.NameValue> cookies;
    3: optional list<name_value.NameValue> headers;
    4: optional i32 headersSize;
    5: optional string httpVersion;
    6: optional string method;
    7: optional post_data.PostData postData;
    8: optional list<name_value.NameValue> queryString;
    9: optional string url;
    
}