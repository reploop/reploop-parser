package records

type RecordsUserOrderAdditional struct {
    ActionSource string `json:"actionSource"`
    CreateTime string `json:"createTime"`
    OrderId string `json:"orderId"`
    DriverPhone string `json:"driverPhone"`
    Operator string `json:"operator"`
    VehicleBrand string `json:"vehicleBrand"`
    PreDriverId string `json:"preDriverId"`
    Delay string `json:"delay"`
    Night bool `json:"night"`
    DriverOrderId string `json:"driverOrderId"`
    SettlementPrice string `json:"settlementPrice"`
    
}
