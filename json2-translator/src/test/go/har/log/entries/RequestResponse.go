package entries

type RequestResponse struct {
    HttpVersion string `json:"httpVersion"`
    Cookies []NameValue `json:"cookies"`
    Headers []NameValue `json:"headers"`
    HeadersSize int32 `json:"headersSize"`
    BodySize int32 `json:"bodySize"`
    
}
