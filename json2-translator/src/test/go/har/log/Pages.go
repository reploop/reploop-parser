package log

import "har/log/pages"
type Pages struct {
    Id string `json:"id"`
    PageTimings pages.PageTimings `json:"pageTimings"`
    StartedDateTime string `json:"startedDateTime"`
    
}
