// Author: Liang Liuwei (liangliuwei@qiyi.com)
//
// This file defines the interface of celebrity service of qipu.
//

include "../../pub/common.thrift"

namespace cpp knowledge.pub
namespace java knowledge.pub

service CelebrityRpcService {
  // graph遗留接口 : get related celebrity of celebrity 
  binary getRelatedCelebrities(1:binary request) throws 
    (1:common.UserException ue, 2: common.RpcException re);

  binary getRelatedCelebritiesOfVideo(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 根据明星奇谱id获取相关明星: 数据来自qipu rpc服务。
   * 对应graph接口: getRelatedCelebrities
   */
  binary getRelatedCelebritiesOfCelebrity(1:binary get_related_celebrities_of_celebrity_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 获取明星的概略信息
   */
  binary getCelebritySummary(1:binary get_celebrity_data_request) throws
    (1:common.UserException ue, 2: common.RpcException re);
    
  /**
   * 获取明星图谱
   */
  binary getCelebrityGraph(1:binary get_celebrity_data_request) throws
    (1:common.UserException ue, 2: common.RpcException re);
}