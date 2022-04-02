include "plan_prefer/price.thrift"
namespace * req1
struct PlanPrefer {
    1: optional price.Price price;
    2: optional list<i32> star;
    3: optional list<string> tags;
    
}