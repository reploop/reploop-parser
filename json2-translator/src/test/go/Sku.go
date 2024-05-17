package main

import "sku"
type Sku struct {
    Reason string `json:"reason"`
    Result []sku.Result `json:"result"`
    ResultCode string `json:"resultCode"`
    Success bool `json:"success"`
    
}
