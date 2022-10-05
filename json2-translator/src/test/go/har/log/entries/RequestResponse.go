package entries

type RequestResponse struct {
    Headers []NameValue `json:"headers"`
    HttpVersion string `json:"httpVersion"`
    BodySize int32 `json:"bodySize"`
    HeadersSize int32 `json:"headersSize"`
    Cookies []NameValue `json:"cookies"`
    
}
