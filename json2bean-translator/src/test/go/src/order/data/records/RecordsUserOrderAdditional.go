package records

type RecordsUserOrderAdditional struct {
	SettlementPrice string `json:"settlementPrice"`
	CreateTime      string `json:"createTime"`
	OrderId         string `json:"orderId"`
	Delay           string `json:"delay"`
	PreDriverId     string `json:"preDriverId"`
	Operator        string `json:"operator"`
	VehicleBrand    string `json:"vehicleBrand"`
	DriverOrderId   string `json:"driverOrderId"`
	Night           bool   `json:"night"`
	ActionSource    string `json:"actionSource"`
	DriverPhone     string `json:"driverPhone"`
}
