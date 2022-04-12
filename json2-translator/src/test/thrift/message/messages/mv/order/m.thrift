include "m/code.thrift"
include "m/states.thrift"
include "m/created.thrift"
include "m/pick_point.thrift"
include "m/items.thrift"
include "m/flight.thrift"
include "m/picker.thrift"
namespace * message.messages.mv.order
struct M {
    1: optional code.Code code;
    2: optional created.Created created;
    3: optional flight.Flight flight;
    4: optional items.Items items;
    5: optional pick_point.PickPoint pickPoint;
    6: optional picker.Picker picker;
    7: optional states.States states;
    
}