package data

import "category/data/sheets"
type Sheets struct {
    FrozenColCount int32 `json:"frozenColCount"`
    FrozenRowCount int32 `json:"frozenRowCount"`
    Index int32 `json:"index"`
    Merges []sheets.Merges `json:"merges"`
    SheetId string `json:"sheetId"`
    Title string `json:"title"`
    ColumnCount int32 `json:"columnCount"`
    RowCount int32 `json:"rowCount"`
    
}
