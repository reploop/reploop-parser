package main

import "store"
type Store struct {
    List []store.List `json:"list"`
    Msg string `json:"msg"`
    Success bool `json:"success"`
    
}
