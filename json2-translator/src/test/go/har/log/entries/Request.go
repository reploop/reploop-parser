package entries

import "har/log/entries/request"
type Request struct {
    Method string `json:"method"`
    PostData request.PostData `json:"postData"`
    QueryString []NameValue `json:"queryString"`
    Url string `json:"url"`
    HttpVersion string `json:"httpVersion"`
    Cookies []NameValue `json:"cookies"`
    Headers []NameValue `json:"headers"`
    HeadersSize int32 `json:"headersSize"`
    BodySize int32 `json:"bodySize"`
    
}
