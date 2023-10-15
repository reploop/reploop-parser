package entries

import "har/log/entries/request"
type Request struct {
    Method string `json:"method"`
    PostData request.PostData `json:"postData"`
    QueryString []NameValue `json:"queryString"`
    Url string `json:"url"`
    Cookies []NameValue `json:"cookies"`
    HeadersSize int32 `json:"headersSize"`
    HttpVersion string `json:"httpVersion"`
    Headers []NameValue `json:"headers"`
    BodySize int32 `json:"bodySize"`
    
}
