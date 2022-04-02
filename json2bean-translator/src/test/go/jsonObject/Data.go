package jsonObject

type Data struct {
    CountHistory int32 `json:"count_history"`
    CountLastWeek int32 `json:"count_last_week"`
    PlayUrl string `json:"play_url"`
    RankTrend int32 `json:"rank_trend"`
    CountYesterday int32 `json:"count_yesterday"`
    TvId int64 `json:"tv_id"`
    TvName string `json:"tv_name"`
    VvWeek int32 `json:"vv_week"`
    
}
