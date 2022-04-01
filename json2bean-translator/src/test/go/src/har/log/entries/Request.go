package entries

import "har/log/entries/request"
type Request struct {
    Method string `json:"method"`
    PostData request.PostData `json:"postData"`
    QueryString []NameValue `json:"queryString"`
    Url string `json:"url"`
    BodySize int32 `json:"bodySize"`
    Headers []NameValue `json:"headers"`
    HttpVersion string `json:"httpVersion"`
    Cookies []NameValue `json:"cookies"`
    HeadersSize int32 `json:"headersSize"`
    
}
