// Author: Jiannan Tan (tanjiannan@qiyi.com)
//
// This file defines the interface of avatar service of qipu.
//

include "../pub/common.thrift"

namespace cpp knowledge.pub
namespace java knowledge.pub

service AvatarRpcService {
  /**
   * 获取奇谱entity实体.
   */
  binary getEntity(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);
    

  /**
   * 获取奇谱entity实体.(无内存缓存)
   */
  binary getEntityWithoutCache(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 获取明星相关视频id
   */
  binary getRelatedVideoIdsOfCelebrity(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 对视频进行过滤
   */
  binary getFilteredVideos(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 对视频进行排序
   */
  binary getRankedVideos(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 获取视频相关信息
   */
  binary getVideoDatasFromIds(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 获取明星相关明星id
   */
  binary getRelatedCelebrityIdsOfCelebrity(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 获取明星相关信息
   */
  binary getCelebrityDataFromIds(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);
}