package records

type RecordsUserOrderAdditional struct {
    OrderId string `json:"orderId"`
    SettlementPrice string `json:"settlementPrice"`
    CreateTime string `json:"createTime"`
    DriverPhone string `json:"driverPhone"`
    ActionSource string `json:"actionSource"`
    Night bool `json:"night"`
    PreDriverId string `json:"preDriverId"`
    DriverOrderId string `json:"driverOrderId"`
    Operator string `json:"operator"`
    VehicleBrand string `json:"vehicleBrand"`
    Delay string `json:"delay"`
    
}
