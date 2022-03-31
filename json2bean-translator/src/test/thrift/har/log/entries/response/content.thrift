include "../mime_type_text.thrift"
namespace * har.log.entries.response
struct Content {
    1: optional string mimeType;
    2: optional i32 size;
    3: optional string text;
    
}