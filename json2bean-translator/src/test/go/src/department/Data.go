package department

import "department/data"
type Data struct {
    HasMore bool `json:"has_more"`
    Items []data.Items `json:"items"`
    
}
