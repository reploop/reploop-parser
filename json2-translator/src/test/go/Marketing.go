package main

import "marketing"
type Marketing struct {
    Reason string `json:"reason"`
    Result []marketing.Result `json:"result"`
    ResultCode string `json:"resultCode"`
    Success bool `json:"success"`
    
}
