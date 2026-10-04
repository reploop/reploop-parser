package main

import "driver"
type Driver struct {
    Data driver.Data `json:"data"`
    ErrMsg string `json:"errmsg"`
    ErrNo int32 `json:"errno"`
    TraceId string `json:"trace_id"`
    
}
