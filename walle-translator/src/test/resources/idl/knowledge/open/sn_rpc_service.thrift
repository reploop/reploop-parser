// Author: Zheng Cheng(zhengcheng@qiyi.com)
//
// This file defines the SN RPC service interface.
//
include "../pub/common.thrift"

namespace cpp knowledge.open
namespace java knowledge.open

//
// SN PRC service
// This service takes one parameter sn_request (defined in sn_service.proto)
// and return id response (defined in sn_service.proto)
//
service SNRpcService {
    binary getUniqueId(1: binary sn_request) throws (1:common.UserException ue, 2: common.RpcException re);

    binary registerIdType(1: binary sn_register_request) throws (1:common.UserException ue, 2: common.RpcException re);

    binary findTypeInfo(1: binary sn_find_type_info_request) throws (1:common.UserException ue, 2: common.RpcException re);

}
