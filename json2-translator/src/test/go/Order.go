package main

import "order"
type Order struct {
    Code int32 `json:"code"`
    Data order.Data `json:"data"`
    Msg string `json:"msg"`
    
}
