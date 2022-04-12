include "m/airport.thrift"
include "m/terminal.thrift"
include "m/name.thrift"
namespace * message.messages.mv.order.m.pickPoint
struct M {
    1: optional airport.Airport airport;
    2: optional name.Name name;
    3: optional terminal.Terminal terminal;
    
}