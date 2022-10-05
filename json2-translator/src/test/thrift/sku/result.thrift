include "../java/time/local_date_time.thrift"
namespace * sku
struct Result {
    1: optional bool addedFlag;
    2: optional local_date_time.LocalDateTime createTime;
    3: optional string goodsInfoId;
    4: optional bool inStock;
    5: optional double marketPrice;
    6: optional string sku;
    7: optional double unitValue;
    
}