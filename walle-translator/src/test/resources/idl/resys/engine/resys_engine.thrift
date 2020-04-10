include "../../knowledge/pub/common.thrift"

namespace java com.qiyi.knowledge.resys.engine

service ResysEngineService {
    binary guessSimilarity(1: binary guess_similarity_request) throws
    (1:common.UserException ue, 2: common.RpcException re);
}