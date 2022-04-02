include "sheets/merges.thrift"
namespace * category.data
struct Sheets {
    1: optional i32 columnCount;
    2: optional i32 frozenColCount;
    3: optional i32 frozenRowCount;
    4: optional i32 index;
    5: optional list<merges.Merges> merges;
    6: optional i32 rowCount;
    7: optional string sheetId;
    8: optional string title;
    
}