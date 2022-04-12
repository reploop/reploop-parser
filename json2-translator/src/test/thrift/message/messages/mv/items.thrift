include "items/m.thrift"
namespace * message.messages.mv
struct Items {
    1: optional map<i32, m.M> m;
    
}