// Author: Zheng Cheng (zhengcheng@qiyi.com)
//
// This file defines the interface of read service.
include "../common.thrift"

namespace cpp knowledge.pub
namespace java knowledge.pub

// The interface for the read service.
service DataPeekRpcService {
   // read统一接口,使用bytes传输数据,RPC客户端负责解析
   binary readEntity(1:binary read_entity_request) throws (1:common.UserException ue, 2: common.RpcException re);

   binary getEntity(1:binary get_entity_request) throws (1:common.UserException ue, 2: common.RpcException re);
}
