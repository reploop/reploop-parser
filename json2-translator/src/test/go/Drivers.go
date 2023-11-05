package main

import "drivers"
type Drivers struct {
    Code int32 `json:"code"`
    Msg string `json:"msg"`
    Rows []drivers.Rows `json:"rows"`
    Total int32 `json:"total"`
    
}
