package entries

import "har/log/entries/request"
type Request struct {
    Method string `json:"method"`
    PostData request.PostData `json:"postData"`
    QueryString []NameValue `json:"queryString"`
    Url string `json:"url"`
    HeadersSize int32 `json:"headersSize"`
    Headers []NameValue `json:"headers"`
    Cookies []NameValue `json:"cookies"`
    HttpVersion string `json:"httpVersion"`
    BodySize int32 `json:"bodySize"`
    
}
