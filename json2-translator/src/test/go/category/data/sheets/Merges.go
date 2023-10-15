package sheets

type Merges struct {
    StartColumnIndex int32 `json:"startColumnIndex"`
    StartRowIndex int32 `json:"startRowIndex"`
    RowCount int32 `json:"rowCount"`
    ColumnCount int32 `json:"columnCount"`
    
}
