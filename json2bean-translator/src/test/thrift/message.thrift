include "message/messages.thrift"
include "message/result.thrift"
struct Message {
    1: optional list<messages.Messages> messages;
    2: optional result.Result result;
    
}