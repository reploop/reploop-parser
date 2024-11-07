package main

import "spu"
type Spu struct {
    Reason string `json:"reason"`
    Result []spu.Result `json:"result"`
    ResultCode string `json:"resultCode"`
    Success bool `json:"success"`
    
}
