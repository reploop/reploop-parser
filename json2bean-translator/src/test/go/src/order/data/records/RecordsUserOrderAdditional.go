package records

type RecordsUserOrderAdditional struct {
    Operator string `json:"operator"`
    VehicleBrand string `json:"vehicleBrand"`
    ActionSource string `json:"actionSource"`
    OrderId string `json:"orderId"`
    PreDriverId string `json:"preDriverId"`
    SettlementPrice string `json:"settlementPrice"`
    Delay string `json:"delay"`
    Night bool `json:"night"`
    DriverOrderId string `json:"driverOrderId"`
    DriverPhone string `json:"driverPhone"`
    CreateTime string `json:"createTime"`
    
}
