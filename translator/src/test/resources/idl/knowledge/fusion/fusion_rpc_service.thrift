// Author: Jiannan Tan (tanjiannan@qiyi.com)
//
// This file defines the interface of fusion service of qipu.
//

include "../pub/common.thrift"

namespace cpp knowledge.pub
namespace java knowledge.pub

service FusionRpcService {
  /**
   * 获得奇谱entity实体: 一部分数据取自奇谱rpc服务,而另一部分数据取自龙源rpc服务。
   */
  binary getEntity(1:binary get_entity_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 获得片花列表: 数据可能来自奇谱rpc服务,也可能来自qiso http服务。
   * 对应graph接口: getFilmTvLibPrevue
   */
  binary getVideoPrevues(1:binary get_video_prevues_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 兼容graph接口: getFilmTvLibPrevue
   */
  binary getFilmTvLibPrevue(1:binary get_film_tv_lib_prevue_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 获得全网播放源: 数据来自qiso http服务。
   * 对应graph接口: getFilmTvLibPlaySource
   */
  binary getVideoPlaySources(1:binary get_video_play_sources_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 兼容graph接口: getFilmTvLibPlaySource
   */
  binary getFilmTvLibPlaySource(1:binary get_film_tv_lib_play_sources_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 查询指定时间段内上线的所有视频列表，并从龙源获取最新播放量数据
   */
  binary queryVideosByPagePublishTime(1:binary query_videos_by_page_publish_time_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 根据明星的奇谱id获取相关作品: 数据来自qipu rpc服务。
   * 对应graph接口: getRelatedEntities
   */
  binary getRelatedVideosOfCelebrity(1:binary get_related_videos_of_celebrity_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 根据明星的奇谱id获取相关作品: 数据来自qipu rpc服务。
   * 对应graph接口: getRelatedEntities
   */
  binary getRelatedEntities(1:binary get_related_entities_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 根据视频的id获取相关明星: 数据来自qipu rpc服务。
   * 对应graph接口: getRelatedCelebritiesOfVideo
   */
  binary getRelatedCelebritiesOfVideo(1:binary get_related_celebrities_of_video_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 根据明星奇谱id获取相关明星: 数据来自qipu rpc服务。
   * 对应graph接口: getRelatedCelebrities
   */
  binary getRelatedCelebritiesOfCelebrity(1:binary get_related_celebrities_of_celebrity_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 根据明星奇谱id获取相关明星: 数据来自qipu rpc服务。
   * 对应graph接口: getRelatedCelebrities
   */
  binary getRelatedCelebrities(1:binary get_related_celebrities_request) throws
    (1:common.UserException ue, 2: common.RpcException re);


  /**
   *  根据视频id以及需要查找的类型获取相关视频，数据来自qipu query服务
   *  对应graph接口： getRelatedVideosOfVideo
   */
  binary getMultiRelatedVideosOfVideo(1:binary get_multi_related_videos_of_video_request) throws
    (1:common.UserException ue, 2: common.RpcException re);
  /**
   * 获取符合条件的dsp视频: 数据来自query rpc服务。
   */
  binary getDspVideos(1:binary get_dsp_videos_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 获取指定时间段内上传的播单: 数据来自 query rpc 服务
   */
  binary queryGraphCollectionsByQiyiPublishDate(1:binary query_graph_collections_by_qiyi_publish_date_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 迁移graph接口,根据 passport_id (UID) 获取明星的奇谱 ID: 数据来自 query rpc 服务
   */
  binary getEntityId(1:binary query_celebrity_by_uid_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 迁移graph接口,根据站内视频的奇谱 ID 获取对应的影视大全信息: 数据来自 read rpc 服务
   */
  binary getFilmTvLibInfo(1:binary get_film_tv_lib_from_qipu_id_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 根据用户身份特征获取对应的用户模型: 数据来自 face read rpc 服务
   */
  binary getUserModelByIdentification(1:binary get_user_model_by_identification_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 根据用户获取对应的数据字典: 数据来自 face dict rpc 服务
   */
  binary getDict(1:binary get_dict_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 根据用户id获取对应的用户模型: 数据来自 face read rpc 服务
   */
  binary getUserModelByFaceId(1:binary get_user_model_by_face_id_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 通用的按字段查询接口: 数据来自 query rpc 服务
   */
  binary termsQuery(1:binary terms_query_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 通用的按模板查询接口: 数据来自 query rpc 服务
   */
  binary templateQuery(1:binary template_query_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 根据应用和语言，返回提示语: 数据来自 query rpc 服务
   */
  binary queryOperationTips(1:binary query_operation_tips_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 获取明星相关的信息，包括相关频道的信息以及相关明星的信息
   */
  binary getRelatedInfoOfCelebrity(1:binary get_related_info_of_celebrity_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 迁移graph接口，根据时间获取播单
   */
  binary getCollections(1:binary get_collections_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  /**
   * 迁移graph接口，根据时间获取影视大全信息
   */
  binary getFilmTvLibs(1:binary get_film_tv_libs_by_publish_date_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

 /**
   * 获取最新视频，最热视频，专辑播单的组合
 */
  binary getUploadedVideosAndAlbums(1:binary get_videos_and_albums_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

 /**
   * 根据上传者id获取上传视频列表
 */
  binary getUploadedVideos(1:binary get_uploaded_videos_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

 /**
   * 来源与read service中的getCount
 */
  binary getCount(1:binary get_count_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

 /**
   * 兼容Graph接口，获取视频相关视频
   * 对应graph接口： getRelatedVideos
 */
  binary getRelatedVideos(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);
    
 /**
   * 获取播放记录的视频
 */
  binary getPlayRecordVideo(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);

 /**
    * 获取直播视频、上传视频
  */
   binary getVideosByIpAndPlatform(1:binary get_videos_by_ip_and_platform_request) throws
     (1:common.UserException ue, 2: common.RpcException re);

 /**
     *
   */
    binary getVideosByTitleOrPageUrl(1:binary get_videos_by_title_or_pageUrl_request) throws
      (1:common.UserException ue, 2: common.RpcException re);

  /**
      * 获取直播点播视频
    */
     binary getUserVideos(1:binary get_user_videos_request) throws
       (1:common.UserException ue, 2: common.RpcException re);
       
    /**
    * 获取焦点图
    */
     binary resys(1:binary resys_request) throws
       (1:common.UserException ue, 2: common.RpcException re);
       
    /**
    * 获取IP推荐
    */
     binary iprecommend(1:binary resys_request) throws
            (1:common.UserException ue, 2: common.RpcException re);
            
   /**
     * 影视大全相关接口
   */
     binary getRelatedFilm(1:binary request) throws
       (1:common.UserException ue, 2: common.RpcException re);
}

