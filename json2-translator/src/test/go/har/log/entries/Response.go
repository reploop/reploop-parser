package entries

import "har/log/entries/response"
type Response struct {
    Content response.Content `json:"content"`
    RedirectUrL string `json:"redirectURL"`
    Status int32 `json:"status"`
    StatusText string `json:"statusText"`
    HttpVersion string `json:"httpVersion"`
    Cookies []NameValue `json:"cookies"`
    Headers []NameValue `json:"headers"`
    HeadersSize int32 `json:"headersSize"`
    BodySize int32 `json:"bodySize"`
    
}
