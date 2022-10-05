package request

import "har/log/entries"
type PostData struct {
    Params []entries.NameValue `json:"params"`
    MimeType string `json:"mimeType"`
    Text string `json:"text"`
    
}
