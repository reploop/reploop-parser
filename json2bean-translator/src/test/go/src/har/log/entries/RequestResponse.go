package entries

type RequestResponse struct {
    HeadersSize int32 `json:"headersSize"`
    Cookies []NameValue `json:"cookies"`
    BodySize int32 `json:"bodySize"`
    HttpVersion string `json:"httpVersion"`
    Headers []NameValue `json:"headers"`
    
}
