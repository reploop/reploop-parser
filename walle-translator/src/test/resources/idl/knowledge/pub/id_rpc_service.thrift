// Author: Jianbing Zhang (zhangjianbing@qiyi.com)
//
// This file defines the Id RPC service interface.
//
namespace cpp knowledge.pub
namespace java knowledge.pub

// In case of error, throw this exception
exception InvalidNewIdOperation {
    1: optional string message;
}

//
// Id PRC service
// This service takes one parameter id_request (defined in id_service.proto)
// and return id response (defined in id_service.proto)
//
service IdRpcService {
    binary getNewIds(1: binary id_request) throws (1: InvalidNewIdOperation e);
    binary getCurrentId(1: binary current_id_request) throws (1: InvalidNewIdOperation e);
}
