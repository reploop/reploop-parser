include "req1/city_list.thrift"
include "req1/room.thrift"
include "req1/plan_prefer.thrift"
struct Req1 {
    1: optional list<city_list.CityList> city_list;
    2: optional plan_prefer.PlanPrefer plan_prefer;
    3: optional list<room.Room> room;
    
}