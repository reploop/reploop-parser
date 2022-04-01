package order

import "order/data"

type Data struct {
	CountId          string         `json:"countId"`
	Current          int32          `json:"current"`
	Entity           string         `json:"entity"`
	HitCount         bool           `json:"hitCount"`
	MaxLimit         string         `json:"maxLimit"`
	OptimizeCountSql bool           `json:"optimizeCountSql"`
	Orders           []string       `json:"orders"`
	Pages            int32          `json:"pages"`
	Records          []data.Records `json:"records"`
	SearchCount      bool           `json:"searchCount"`
	Size             int32          `json:"size"`
	Total            int32          `json:"total"`
}
