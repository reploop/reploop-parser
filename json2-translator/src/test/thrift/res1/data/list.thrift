include "list/hotels.thrift"
namespace * res1.data
struct List {
    1: optional string city_id;
    2: optional list<hotels.Hotels> hotels;
    3: optional i32 max_price;
    4: optional i32 min_price;
    
}