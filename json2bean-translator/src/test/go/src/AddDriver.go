package main

type AddDriver struct {
    DriverLicenseNo string `json:"driverLicenseNo"`
    Files []string `json:"files"`
    Id string `json:"id"`
    IdNo string `json:"idNo"`
    Name string `json:"name"`
    OfficeId string `json:"officeId"`
    Phone int64 `json:"phone"`
    Remarks string `json:"remarks"`
    Sex string `json:"sex"`
    
}
