include "m/time.thrift"
include "m/status.thrift"
namespace * message.messages.mv.order.m.states.l
struct M {
    1: optional status.Status status;
    2: optional time.Time time;
    
}