package log

import "har/log/entries"
type Entries struct {
    SecurityState string `json:"_securityState"`
    Cache entries.Cache `json:"cache"`
    Connection string `json:"connection"`
    PageRef string `json:"pageref"`
    Request entries.Request `json:"request"`
    Response entries.Response `json:"response"`
    ServerIpAddress string `json:"serverIPAddress"`
    StartedDateTime string `json:"startedDateTime"`
    Time int32 `json:"time"`
    Timings entries.Timings `json:"timings"`
    
}
