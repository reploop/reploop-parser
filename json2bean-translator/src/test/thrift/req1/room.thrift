include "room/list.thrift"
namespace * req1
struct Room {
    1: optional list<list.List> list;
    
}