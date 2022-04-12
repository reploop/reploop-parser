include "response/content.thrift"
include "name_value.thrift"
namespace * har.log.entries
struct Response {
    1: optional i32 bodySize;
    2: optional content.Content content;
    3: optional list<name_value.NameValue> cookies;
    4: optional list<name_value.NameValue> headers;
    5: optional i32 headersSize;
    6: optional string httpVersion;
    7: optional string redirectURL;
    8: optional i32 status;
    9: optional string statusText;
    
}