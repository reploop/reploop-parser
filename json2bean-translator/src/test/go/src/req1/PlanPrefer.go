package req1

import "req1/plan_prefer"
type PlanPrefer struct {
    Price plan_prefer.Price `json:"price"`
    Star []int32 `json:"star"`
    Tags []string `json:"tags"`
    
}
