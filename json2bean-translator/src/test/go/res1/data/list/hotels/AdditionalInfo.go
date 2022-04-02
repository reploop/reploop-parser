package hotels

import "res1/data/list/hotels/additional_info"
type AdditionalInfo struct {
    CityList []additional_info.CityList `json:"city_list"`
    PlanPrefer additional_info.PlanPrefer `json:"plan_prefer"`
    Room []additional_info.Room `json:"room"`
    
}
