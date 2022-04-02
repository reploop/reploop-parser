package data

import "res1/data/list"
type List struct {
    CityId string `json:"city_id"`
    Hotels []list.Hotels `json:"hotels"`
    MaxPrice int32 `json:"max_price"`
    MinPrice int32 `json:"min_price"`
    
}
