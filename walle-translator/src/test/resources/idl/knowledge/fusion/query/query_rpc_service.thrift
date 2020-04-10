// Author: Wang Tianxing<wangtianxing@qiyi.com>
//
// This file defines the rpc methods for knowledge mixer service

include "../../pub/common.thrift"

namespace java knowledge.pub.query

service QueryRpcService {
  binary templateQuery(1:binary template_query_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary queryUploadedVideos(1:binary query_uploaded_videos_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary queryDspVideos(1:binary query_dsp_videos_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary queryVideosByPagePublishTime(1:binary query_videos_by_page_publish_time_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary queryCategoryByChannelId(1:binary query_category_by_channel_id_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary queryCategoryByIds(1:binary query_category_by_ids_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary queryAllSubCategories(1:binary query_all_categories_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary queryAllChannels(1:binary query_all_channels_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary termsQuery(1:binary terms_query_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary querySimilarFilmTv(1:binary query_similar_film_tv_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary searchRecommend(1:binary search_recommend_request) throws
    (1:common.UserException ue, 2: common.RpcException re);

  binary verticalSearch(1:binary vertical_search_request) throws
    (1:common.UserException ue, 2: common.RpcException re);
}
