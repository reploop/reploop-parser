package main

type AddCar struct {
    Brand string `json:"brand"`
    Colour string `json:"colour"`
    DriverUberId int64 `json:"driverUberId"`
    Files []string `json:"files"`
    Id string `json:"id"`
    OfficeId string `json:"officeId"`
    Plate string `json:"plate"`
    PlateColour string `json:"plateColour"`
    Remarks string `json:"remarks"`
    Seating int32 `json:"seating"`
    SettlementPrice int32 `json:"settlementPrice"`
    TrafficCarType string `json:"trafficCarType"`
    Type string `json:"type"`
    VehicleDesc string `json:"vehicleDesc"`
    VehicleNature string `json:"vehicleNature"`
    
}
