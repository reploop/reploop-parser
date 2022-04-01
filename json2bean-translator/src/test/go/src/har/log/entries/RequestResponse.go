package entries

type RequestResponse struct {
    BodySize int32 `json:"bodySize"`
    Headers []NameValue `json:"headers"`
    HttpVersion string `json:"httpVersion"`
    Cookies []NameValue `json:"cookies"`
    HeadersSize int32 `json:"headersSize"`
    
}
