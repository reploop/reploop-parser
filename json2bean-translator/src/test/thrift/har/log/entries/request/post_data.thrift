include "../name_value.thrift"
namespace * har.log.entries.request
struct PostData {
    1: optional string mimeType;
    2: optional list<name_value.NameValue> params;
    3: optional string text;
    
}