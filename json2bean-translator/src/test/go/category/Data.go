package category

import "category/data"
type Data struct {
    Properties data.Properties `json:"properties"`
    Sheets []data.Sheets `json:"sheets"`
    SpreadsheetToken string `json:"spreadsheetToken"`
    
}
