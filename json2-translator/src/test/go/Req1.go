package main

import "req1"
type Req1 struct {
    CityList []req1.CityList `json:"city_list"`
    PlanPrefer req1.PlanPrefer `json:"plan_prefer"`
    Room []req1.Room `json:"room"`
    
}
