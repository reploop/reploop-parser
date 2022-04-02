package main

import "category"
type Category struct {
    Code int32 `json:"code"`
    Data category.Data `json:"data"`
    Msg string `json:"msg"`
    
}
