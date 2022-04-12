include "store/list.thrift"
struct Store {
    1: optional list<list.List> list;
    2: optional string msg;
    3: optional bool success;
    
}