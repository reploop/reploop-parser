include "m/name.thrift"
include "m/qty.thrift"
include "m/code.thrift"
include "m/total_price.thrift"
namespace * message.messages.mv.items.m
struct MM {
    1: optional code.Code code;
    2: optional name.Name name;
    3: optional qty.Qty qty;
    4: optional total_price.TotalPrice totalPrice;
    
}