include "items/m.thrift"
namespace * message.messages.mv.order.m
struct Items {
    1: optional map<i32, m.M> m;
    
}