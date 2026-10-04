package main

import "simple"
type Simple struct {
    Area map[int32]simple.Area `json:"area"`
    City map[string]string `json:"city"`
    Code int32 `json:"code"`
    Date string `json:"date"`
    Error string `json:"error"`
    Result string `json:"result"`
    
}
