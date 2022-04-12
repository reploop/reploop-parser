include "pages/page_timings.thrift"
namespace * har.log
struct Pages {
    1: optional string id;
    2: optional page_timings.PageTimings pageTimings;
    3: optional string startedDateTime;
    
}