package entries

type Timings struct {
    Blocked int32 `json:"blocked"`
    Connect int32 `json:"connect"`
    Dns int32 `json:"dns"`
    Receive int32 `json:"receive"`
    Send int32 `json:"send"`
    Ssl int32 `json:"ssl"`
    Wait int32 `json:"wait"`
    
}
