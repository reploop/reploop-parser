package records

type RecordsUserOrderAdditional struct {
    CreateTime string `json:"createTime"`
    OrderId string `json:"orderId"`
    Delay string `json:"delay"`
    DriverPhone string `json:"driverPhone"`
    ActionSource string `json:"actionSource"`
    SettlementPrice string `json:"settlementPrice"`
    Operator string `json:"operator"`
    VehicleBrand string `json:"vehicleBrand"`
    PreDriverId string `json:"preDriverId"`
    Night bool `json:"night"`
    DriverOrderId string `json:"driverOrderId"`
    
}
