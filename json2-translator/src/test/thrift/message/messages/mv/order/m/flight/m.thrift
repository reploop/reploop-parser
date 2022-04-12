include "m/departure_time.thrift"
include "m/no.thrift"
include "m/terminal.thrift"
include "m/airport.thrift"
namespace * message.messages.mv.order.m.flight
struct M {
    1: optional airport.Airport airport;
    2: optional departure_time.DepartureTime departureTime;
    3: optional no.No no;
    4: optional terminal.Terminal terminal;
    
}