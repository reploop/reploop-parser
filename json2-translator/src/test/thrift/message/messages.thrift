include "messages/mv.thrift"
namespace * message
struct Messages {
    1: optional string id;
    2: optional map<string, string> labels;
    3: optional mv.Mv mv;
    4: optional string roomID;
    5: optional string sender;
    6: optional i32 sequenceNO;
    7: optional string timestamp;
    
}