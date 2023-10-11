package user

type Result struct {
    AreaId string `json:"area_id"`
    AreaName string `json:"area_name"`
    GdEdu string `json:"gd_edu"`
    GdJob string `json:"gd_job"`
    GdMajor string `json:"gd_major"`
    GdSchool string `json:"gd_school"`
    GuidePrice map[int32]int32 `json:"guide_price"`
    Price int32 `json:"price"`
    Remark []string `json:"remark"`
    SerFace string `json:"ser_face"`
    SerHot string `json:"ser_hot"`
    SerRmkc string `json:"ser_rmkc"`
    SerSort string `json:"ser_sort"`
    SerStarC string `json:"ser_starc"`
    SerStatus string `json:"ser_status"`
    SerTitle string `json:"ser_title"`
    SerUTime string `json:"ser_utime"`
    ServiceFace string `json:"service_face"`
    Tag []string `json:"tag"`
    UserAvatar string `json:"user_avatar"`
    UserGender string `json:"user_gender"`
    UserId string `json:"user_id"`
    UserName string `json:"user_name"`
    
}
