include "data/properties.thrift"
include "data/sheets.thrift"
namespace * category
struct Data {
    1: optional properties.Properties properties;
    2: optional list<sheets.Sheets> sheets;
    3: optional string spreadsheetToken;
    
}