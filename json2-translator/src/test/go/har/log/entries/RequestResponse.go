package entries

type RequestResponse struct {
    BodySize int32 `json:"bodySize"`
    HttpVersion string `json:"httpVersion"`
    Cookies []NameValue `json:"cookies"`
    HeadersSize int32 `json:"headersSize"`
    Headers []NameValue `json:"headers"`
    
}
