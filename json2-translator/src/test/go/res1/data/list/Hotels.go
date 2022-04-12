package list

import "res1/data/list/hotels"
type Hotels struct {
    AdditionalInfo hotels.AdditionalInfo `json:"additional_info"`
    CheckIn string `json:"checkin"`
    Checkout string `json:"checkout"`
    COord string `json:"coord"`
    HotelId string `json:"hotel_id"`
    Name string `json:"name"`
    NameEn string `json:"name_en"`
    Price int32 `json:"price"`
    Star int32 `json:"star"`
    Tags []string `json:"tags"`
    
}
