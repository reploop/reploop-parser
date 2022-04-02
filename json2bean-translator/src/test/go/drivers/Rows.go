package drivers

type Rows struct {
    CreateTime string `json:"createTime"`
    CreateUser string `json:"createUser"`
    DelFlag string `json:"delFlag"`
    DriverLicenseExpiredTime string `json:"driverLicenseExpiredTime"`
    DriverLicenseNo string `json:"driverLicenseNo"`
    DriverLicenseType string `json:"driverLicenseType"`
    EndTime string `json:"endTime"`
    Files string `json:"files"`
    Id int64 `json:"id"`
    IdNo string `json:"idNo"`
    InServiceStatus string `json:"inServiceStatus"`
    JobNo string `json:"jobNo"`
    Name string `json:"name"`
    NumOrders int32 `json:"numOrders"`
    OfficeId string `json:"officeId"`
    PassWord string `json:"passWord"`
    Phone string `json:"phone"`
    Remarks string `json:"remarks"`
    Sex string `json:"sex"`
    StartTime string `json:"startTime"`
    TotalAmount int32 `json:"totalAmount"`
    UpdateTime string `json:"updateTime"`
    UpdateUser string `json:"updateUser"`
    UserId string `json:"userId"`
    WorkStatus string `json:"workStatus"`
    
}
