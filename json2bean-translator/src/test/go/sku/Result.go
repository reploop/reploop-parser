package sku

type Result struct {
    AddedFlag bool `json:"addedFlag"`
    CreateTime string `json:"createTime"`
    GoodsInfoId string `json:"goodsInfoId"`
    InStock bool `json:"inStock"`
    MarketPrice float32 `json:"marketPrice"`
    Sku string `json:"sku"`
    UnitValue float32 `json:"unitValue"`
    
}
