include "data/items.thrift"
namespace * department
struct Data {
    1: optional bool has_more;
    2: optional list<items.Items> items;
    
}