package main

import "detail"
type Detail struct {
    Reason string `json:"reason"`
    Result []detail.Result `json:"result"`
    ResultCode string `json:"resultCode"`
    Success bool `json:"success"`
    
}
