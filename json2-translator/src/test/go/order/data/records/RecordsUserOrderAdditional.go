package records

type RecordsUserOrderAdditional struct {
    CreateTime string `json:"createTime"`
    Delay string `json:"delay"`
    OrderId string `json:"orderId"`
    VehicleBrand string `json:"vehicleBrand"`
    Operator string `json:"operator"`
    SettlementPrice string `json:"settlementPrice"`
    PreDriverId string `json:"preDriverId"`
    DriverOrderId string `json:"driverOrderId"`
    ActionSource string `json:"actionSource"`
    Night bool `json:"night"`
    DriverPhone string `json:"driverPhone"`
    
}
