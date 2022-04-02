package pickPoint

import "message/messages/mv/order/m/pickPoint/m"
type M struct {
    Airport m.Airport `json:"airport"`
    Name m.Name `json:"name"`
    Terminal m.Terminal `json:"terminal"`
    
}
