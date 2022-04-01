package flight

import "message/messages/mv/order/m/flight/m"
type M struct {
    Airport m.Airport `json:"airport"`
    DepartureTime m.DepartureTime `json:"departureTime"`
    No m.No `json:"no"`
    Terminal m.Terminal `json:"terminal"`
    
}
