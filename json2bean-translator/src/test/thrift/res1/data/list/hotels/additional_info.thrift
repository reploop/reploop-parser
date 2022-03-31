include "additional_info/room.thrift"
include "additional_info/plan_prefer.thrift"
include "additional_info/city_list.thrift"
namespace * res1.data.list.hotels
struct AdditionalInfo {
    1: optional list<city_list.CityList> city_list;
    2: optional plan_prefer.PlanPrefer plan_prefer;
    3: optional list<room.Room> room;
    
}