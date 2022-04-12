package entries

type RequestResponse struct {
    HeadersSize int32 `json:"headersSize"`
    Headers []NameValue `json:"headers"`
    Cookies []NameValue `json:"cookies"`
    HttpVersion string `json:"httpVersion"`
    BodySize int32 `json:"bodySize"`
    
}
