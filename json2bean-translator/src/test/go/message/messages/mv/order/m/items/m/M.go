package m

import "message/messages/mv/order/m/items/m/m"
type M struct {
    Code m.Code `json:"code"`
    Name m.Name `json:"name"`
    Qty m.Qty `json:"qty"`
    TotalPrice m.TotalPrice `json:"totalPrice"`
    
}
