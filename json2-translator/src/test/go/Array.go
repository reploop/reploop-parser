package main

import "array"
type Array struct {
    Code string `json:"code"`
    Data []array.Data `json:"data"`
    Empty []string `json:"empty"`
    
}
