package request

import "har/log/entries"
type PostData struct {
    Params []entries.NameValue `json:"params"`
    Text string `json:"text"`
    MimeType string `json:"mimeType"`
    
}
