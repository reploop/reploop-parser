package spu

type Result struct {
    AddedFlag bool `json:"addedFlag"`
    BrandId int32 `json:"brandId"`
    CateId int32 `json:"cateId"`
    CreateTime string `json:"createTime"`
    GoodsDetail string `json:"goodsDetail"`
    GoodsImage string `json:"goodsImage"`
    GoodsName string `json:"goodsName"`
    GoodsUnit string `json:"goodsUnit"`
    LinePrice float64 `json:"linePrice"`
    Sku string `json:"sku"`
    
}
