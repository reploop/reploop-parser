package entries

import "har/log/entries/response"
type Response struct {
    Content response.Content `json:"content"`
    RedirectUrL string `json:"redirectURL"`
    Status int32 `json:"status"`
    StatusText string `json:"statusText"`
    BodySize int32 `json:"bodySize"`
    Headers []NameValue `json:"headers"`
    HttpVersion string `json:"httpVersion"`
    Cookies []NameValue `json:"cookies"`
    HeadersSize int32 `json:"headersSize"`
    
}
