// Author: Yin Zeng(zengyin@qiyi.com)
//
// This file defines the rpc methods for accessing the Graph.

include "../../pub/common.thrift"

namespace java knowledge.graph.pub

// Keep this to assure backward compatibility
exception RpcException {
  1: optional string message;
}

service GraphRpcService {
  binary getCanonicalIds(1:binary request) throws (1:RpcException e);
  binary getRelatedEntities(1:binary request) throws (1:RpcException e);
  binary getRelatedCelebrities(1:binary request) throws (1:RpcException e);
  binary getRelatedCelebritiesOfVideo(1:binary request) throws (1:RpcException e);

  binary getTopicList(1:binary request) throws (1:RpcException e);

  binary getRelatedVideos(1:binary request) throws (1:RpcException e);
  binary getUploadedVideos(1:binary request) throws (1:RpcException e);

  binary getTopicSearchIndex(1:binary request) throws (1:RpcException e);
  binary getRelatedTopicNews(1:binary request) throws (1:RpcException e);
  binary getRecommendTopicVideo(1:binary request) throws (1:RpcException e);
  binary getRecommendTopic(1:binary request) throws (1:RpcException e);

  binary getFilmTvLibPlaySource(1:binary get_film_tv_lib_play_source_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary getFilmTvLibInfo(1:binary get_film_tv_lib_info_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary getEntityId(1:binary get_entity_id_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary getFilmTvLibPrevue(1:binary get_film_tv_lib_prevue_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary getFilmTvLibs(1:binary get_film_tv_libs_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary getCollections(1:binary get_collections_request) throws
    (1:common.UserException ue, 2: common.RpcException re);
}
