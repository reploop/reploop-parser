// Author: Zheng Cheng(zhengcheng@qiyi.com)
//
// This file defines the SN RPC service interface.
//
include "../pub/common.thrift"

namespace cpp knowledge.seq
namespace java knowledge.seq

//
// Seq PRC service
// This service takes one parameter request (defined in seq_service.proto)
// and return id response (defined in seq_service.proto)
//
service SequentialRpcService {
    binary read(1: binary read_sequential_request) throws (1:common.UserException ue, 2: common.RpcException re);

    binary write(1: binary write_sequential_request) throws (1:common.UserException ue, 2: common.RpcException re);

    // 完成后标识version可用
    binary releaseVersion(1: binary release_version_request) throws (1:common.UserException ue, 2: common.RpcException re);

    // 注册version
    binary registerVersion(1: binary register_version_request) throws (1:common.UserException ue, 2: common.RpcException re);

    // 查找version
    binary findLatestVersion(1: binary find_latest_version_request) throws (1:common.UserException ue, 2: common.RpcException re);

}
