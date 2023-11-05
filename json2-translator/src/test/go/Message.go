package main

import "message"
type Message struct {
    Messages []message.Messages `json:"messages"`
    Result message.Result `json:"result"`
    
}
