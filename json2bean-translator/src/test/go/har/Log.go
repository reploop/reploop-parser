package har

import "har/log"
type Log struct {
    Browser log.NameVersion `json:"browser"`
    Creator log.NameVersion `json:"creator"`
    Entries []log.Entries `json:"entries"`
    Pages []log.Pages `json:"pages"`
    Version string `json:"version"`
    
}
