include "m/phone.thrift"
include "m/identity.thrift"
include "m/real_name.thrift"
namespace * message.messages.mv.order.m.picker
struct M {
    1: optional identity.Identity identity;
    2: optional phone.Phone phone;
    3: optional real_name.RealName realName;
    
}