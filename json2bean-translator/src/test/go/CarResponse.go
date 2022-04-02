package main

import "carResponse"
type CarResponse struct {
    Code int32 `json:"code"`
    Msg string `json:"msg"`
    Rows []carResponse.Rows `json:"rows"`
    Total int32 `json:"total"`
    
}
