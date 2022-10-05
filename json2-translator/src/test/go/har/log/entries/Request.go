package entries

import "har/log/entries/request"
type Request struct {
    Method string `json:"method"`
    PostData request.PostData `json:"postData"`
    QueryString []NameValue `json:"queryString"`
    Url string `json:"url"`
    Headers []NameValue `json:"headers"`
    HttpVersion string `json:"httpVersion"`
    BodySize int32 `json:"bodySize"`
    HeadersSize int32 `json:"headersSize"`
    Cookies []NameValue `json:"cookies"`
    
}
