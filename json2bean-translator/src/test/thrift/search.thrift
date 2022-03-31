include "search/area.thrift"
struct Search {
    1: optional map<string, area.Area> area;
    2: optional map<string, string> city;
    3: optional i32 code;
    4: optional string date;
    5: optional string error;
    6: optional string result;
    
}