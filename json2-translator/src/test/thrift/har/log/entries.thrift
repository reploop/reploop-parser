include "entries/request.thrift"
include "entries/response.thrift"
include "entries/timings.thrift"
include "entries/cache.thrift"
namespace * har.log
struct Entries {
    1: optional cache.Cache cache;
    2: optional string connection;
    3: optional string pageref;
    4: optional request.Request request;
    5: optional response.Response response;
    6: optional string _securityState;
    7: optional string serverIPAddress;
    8: optional string startedDateTime;
    9: optional i32 time;
    10: optional timings.Timings timings;
    
}