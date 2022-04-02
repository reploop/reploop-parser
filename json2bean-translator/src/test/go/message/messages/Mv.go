package messages

import "message/messages/mv"
type Mv struct {
    Code mv.Code `json:"code"`
    HeadingCode mv.HeadingCode `json:"headingCode"`
    Items mv.Items `json:"items"`
    LifeCycle mv.LifeCycle `json:"lifeCycle"`
    Order mv.Order `json:"order"`
    PickInfo mv.PickInfo `json:"pickInfo"`
    States mv.States `json:"states"`
    UploadInfo mv.UploadInfo `json:"uploadInfo"`
    
}
