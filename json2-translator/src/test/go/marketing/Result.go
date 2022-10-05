package marketing

import "java/time"
type Result struct {
    BeginTime string `json:"beginTime"`
    CreateTime time.LocalDateTime `json:"createTime"`
    EndTime string `json:"endTime"`
    MarketingId int32 `json:"marketingId"`
    MarketingName string `json:"marketingName"`
    MarketingType int32 `json:"marketingType"`
    Pause bool `json:"pause"`
    
}
