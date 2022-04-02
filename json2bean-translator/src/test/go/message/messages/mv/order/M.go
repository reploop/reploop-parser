package order

import "message/messages/mv/order/m"
type M struct {
    Code m.Code `json:"code"`
    Created m.Created `json:"created"`
    Flight m.Flight `json:"flight"`
    Items m.Items `json:"items"`
    PickPoint m.PickPoint `json:"pickPoint"`
    Picker m.Picker `json:"picker"`
    States m.States `json:"states"`
    
}
