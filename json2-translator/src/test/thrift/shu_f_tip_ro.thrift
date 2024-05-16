include "shuFtipro/address.thrift"
include "shuFtipro/document.thrift"
struct ShuFTipRo {
    1: optional address.Address address;
    2: optional string callback_url;
    3: optional string country;
    4: optional document.Document document;
    5: optional string email;
    6: optional string language;
    7: optional string redirect_url;
    8: optional string reference;
    9: optional i32 ttl;
    10: optional string verification_mode;
    
}