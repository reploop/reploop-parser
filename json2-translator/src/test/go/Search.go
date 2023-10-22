package main

import "search"
type Search struct {
    Area map[string]search.Area `json:"area"`
    City map[string]string `json:"city"`
    Code int32 `json:"code"`
    Date string `json:"date"`
    Error string `json:"error"`
    Result string `json:"result"`
    
}
