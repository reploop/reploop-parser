include "mv/items.thrift"
include "mv/code.thrift"
include "mv/order.thrift"
include "mv/states.thrift"
include "mv/upload_info.thrift"
include "mv/heading_code.thrift"
include "mv/life_cycle.thrift"
include "mv/pick_info.thrift"
namespace * message.messages
struct Mv {
    1: optional code.Code code;
    2: optional heading_code.HeadingCode headingCode;
    3: optional items.Items items;
    4: optional life_cycle.LifeCycle lifeCycle;
    5: optional order.Order order;
    6: optional pick_info.PickInfo pickInfo;
    7: optional states.States states;
    8: optional upload_info.UploadInfo uploadInfo;
    
}