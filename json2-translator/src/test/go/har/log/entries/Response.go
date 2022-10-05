package entries

import "har/log/entries/response"
type Response struct {
    Content response.Content `json:"content"`
    RedirectUrL string `json:"redirectURL"`
    Status int32 `json:"status"`
    StatusText string `json:"statusText"`
    Headers []NameValue `json:"headers"`
    HttpVersion string `json:"httpVersion"`
    BodySize int32 `json:"bodySize"`
    HeadersSize int32 `json:"headersSize"`
    Cookies []NameValue `json:"cookies"`
    
}
