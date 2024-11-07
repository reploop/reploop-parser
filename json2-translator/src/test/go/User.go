package main

import "user"
type User struct {
    Code int32 `json:"code"`
    Count int32 `json:"count"`
    Date string `json:"date"`
    Error string `json:"error"`
    Result []user.Result `json:"result"`
    
}
