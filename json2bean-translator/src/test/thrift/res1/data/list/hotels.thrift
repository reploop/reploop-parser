include "hotels/additional_info.thrift"
namespace * res1.data.list
struct Hotels {
    1: optional additional_info.AdditionalInfo additional_info;
    2: optional string coord;
    3: optional string checkin;
    4: optional string checkout;
    5: optional string hotel_id;
    6: optional string name;
    7: optional string name_en;
    8: optional i32 price;
    9: optional i32 star;
    10: optional list<string> tags;
    
}