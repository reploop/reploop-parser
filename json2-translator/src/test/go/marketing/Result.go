package marketing

type Result struct {
    BeginTime string `json:"beginTime"`
    CreateTime string `json:"createTime"`
    EndTime string `json:"endTime"`
    MarketingId int32 `json:"marketingId"`
    MarketingName string `json:"marketingName"`
    MarketingType int32 `json:"marketingType"`
    Pause bool `json:"pause"`
    
}
