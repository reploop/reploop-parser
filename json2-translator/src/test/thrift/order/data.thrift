include "data/records.thrift"
namespace * order
struct Data {
    1: optional string countId;
    2: optional i32 current;
    3: optional string entity;
    4: optional bool hitCount;
    5: optional string maxLimit;
    6: optional bool optimizeCountSql;
    7: optional list<string> orders;
    8: optional i32 pages;
    9: optional list<records.Records> records;
    10: optional bool searchCount;
    11: optional i32 size;
    12: optional i32 total;
    
}