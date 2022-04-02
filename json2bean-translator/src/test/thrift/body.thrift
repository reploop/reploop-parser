include "body/can_shipped_order_parcel_list.thrift"
struct Body {
    1: optional list<can_shipped_order_parcel_list.CanShippedOrderParcelList> canShippedOrderParcelList;
    2: optional i32 canShippedParcelNum;
    3: optional i32 expiredParcelNum;
    4: optional i32 notExpiredParcelNum;
    
}