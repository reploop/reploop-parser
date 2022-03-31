include "plan_prefer/price.thrift"
namespace * res1.data.list.hotels.additional_info
struct PlanPrefer {
    1: optional price.Price price;
    2: optional list<i32> star;
    3: optional list<string> tags;
    
}