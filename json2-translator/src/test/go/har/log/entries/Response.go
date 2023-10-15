package entries

import "har/log/entries/response"
type Response struct {
    Content response.Content `json:"content"`
    RedirectUrL string `json:"redirectURL"`
    Status int32 `json:"status"`
    StatusText string `json:"statusText"`
    Cookies []NameValue `json:"cookies"`
    HeadersSize int32 `json:"headersSize"`
    HttpVersion string `json:"httpVersion"`
    Headers []NameValue `json:"headers"`
    BodySize int32 `json:"bodySize"`
    
}
