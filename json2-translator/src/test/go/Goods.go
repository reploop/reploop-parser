package main

import "goods"
type Goods struct {
    Reason string `json:"reason"`
    Result []goods.Result `json:"result"`
    ResultCode string `json:"resultCode"`
    Success bool `json:"success"`
    
}
