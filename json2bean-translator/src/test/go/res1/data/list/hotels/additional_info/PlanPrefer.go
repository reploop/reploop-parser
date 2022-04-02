package additional_info

import "res1/data/list/hotels/additional_info/plan_prefer"
type PlanPrefer struct {
    Price plan_prefer.Price `json:"price"`
    Star []int32 `json:"star"`
    Tags []string `json:"tags"`
    
}
