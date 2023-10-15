package entries

type RequestResponse struct {
    Cookies []NameValue `json:"cookies"`
    HeadersSize int32 `json:"headersSize"`
    HttpVersion string `json:"httpVersion"`
    Headers []NameValue `json:"headers"`
    BodySize int32 `json:"bodySize"`
    
}
