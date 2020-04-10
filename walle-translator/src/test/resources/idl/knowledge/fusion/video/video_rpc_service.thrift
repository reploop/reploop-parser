// Author: Jiannan Tan (tanjiannan@qiyi.com)
//
// This file defines the interface of video service of qipu.
//

include "../../pub/common.thrift"

namespace cpp knowledge.pub
namespace java knowledge.pub

service VideoRpcService {
  /**
   * 获取视频概要
   */
  binary getVideoSummary(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);
  
  /**
  *  获取videoBrief 概要
  */
  binary getVideoBrief(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
  *  获取videoBrief专辑概要
  */
  binary getAlbumBrief(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);
      
  /**
  *  获取videoBrief 列表
  */
  binary getVideoBriefList(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);
    
  /**
   * 根据明星的奇谱id获取相关作品: 数据来自qipu rpc服务。
   * 对应graph接口: getRelatedEntities
   */
  binary getRelatedVideosOfCelebrity(1:binary get_related_videos_of_celebrity_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * graph遗留接口: getRelatedEntities
   */
  binary getRelatedEntities(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);
    
  /**
   * 获取影视大全以及下面的明星概略信息
   */
  binary getFilmTvAndCelebrity(1:binary get_film_tv_and_celebrity_request) throws
    (1:common.UserException ue, 2: common.RpcException re);
    
  /**
   * 获取明星相关的影视大全信息
   */
  binary getRelatedFilmTvOfCelebrity(1:binary get_film_tv_and_celebrity_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 获取影视大全下面的UGC列表信息（如有的话）
   */
  binary getUgcSummaryOfFilmTv(1:binary get_ugc_summary_of_filmtv_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
  *  1.获得指定日期的来源类视频信息
  *  2.获得早于某一期的来源类视频信息
  */    
  binary getSourceVideoBriefList(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);
    
  /**
  *  混合取花絮、预告片接口(视频id)
  */      
  binary getMixVideoBriefList(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);    

  /**
  *  混合取花絮、预告片接口(专辑id)
  */     
  binary getMixVideoBriefListByAlbum(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);
}