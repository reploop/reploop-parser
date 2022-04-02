package entries

import "har/log/entries/response"
type Response struct {
    Content response.Content `json:"content"`
    RedirectUrL string `json:"redirectURL"`
    Status int32 `json:"status"`
    StatusText string `json:"statusText"`
    HeadersSize int32 `json:"headersSize"`
    Headers []NameValue `json:"headers"`
    Cookies []NameValue `json:"cookies"`
    HttpVersion string `json:"httpVersion"`
    BodySize int32 `json:"bodySize"`
    
}
