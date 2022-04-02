package data

type DriverData struct {
    Address string `json:"address"`
    AgentId int32 `json:"agent_id"`
    BanStatus int32 `json:"ban_status"`
    Channel string `json:"channel"`
    CityName string `json:"city_name"`
    ContactPhone string `json:"contact_phone"`
    IdCardLocation int32 `json:"id_card_location"`
    IdNo string `json:"id_no"`
    IdnOBackUrl string `json:"idno_back_url"`
    IdnOFrontUrl string `json:"idno_front_url"`
    LicenceBackUrl string `json:"licence_back_url"`
    LicenceFrontUrl string `json:"licence_front_url"`
    Name string `json:"name"`
    OnlineGvid string `json:"online_gvid"`
    QualificationUrl string `json:"qualification_url"`
    RegTime string `json:"reg_time"`
    Sex string `json:"sex"`
    SupplierId int32 `json:"supplier_id"`
    
}
