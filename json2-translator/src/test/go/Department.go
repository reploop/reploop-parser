package main

import "department"
type Department struct {
    Code int32 `json:"code"`
    Data department.Data `json:"data"`
    Msg string `json:"msg"`
    
}
