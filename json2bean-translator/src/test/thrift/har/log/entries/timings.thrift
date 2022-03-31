namespace * har.log.entries
struct Timings {
    1: optional i32 blocked;
    2: optional i32 connect;
    3: optional i32 dns;
    4: optional i32 receive;
    5: optional i32 send;
    6: optional i32 ssl;
    7: optional i32 wait;
    
}