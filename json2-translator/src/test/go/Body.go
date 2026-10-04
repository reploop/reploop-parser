package main

import "body"
type Body struct {
    CanShippedOrderParcelList []body.CanShippedOrderParcelList `json:"canShippedOrderParcelList"`
    CanShippedParcelNum int32 `json:"canShippedParcelNum"`
    ExpiredParcelNum int32 `json:"expiredParcelNum"`
    NotExpiredParcelNum int32 `json:"notExpiredParcelNum"`
    
}
