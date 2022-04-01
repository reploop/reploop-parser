package entries

import "har/log/entries/request"
type Request struct {
    Method string `json:"method"`
    PostData request.PostData `json:"postData"`
    QueryString []NameValue `json:"queryString"`
    Url string `json:"url"`
    HeadersSize int32 `json:"headersSize"`
    Cookies []NameValue `json:"cookies"`
    BodySize int32 `json:"bodySize"`
    HttpVersion string `json:"httpVersion"`
    Headers []NameValue `json:"headers"`
    
}
