// Author: Chuaqian Wang (wangchuanqian@qiyi.com)
//
// This file defines the interface of read service.

namespace cpp knowledge.pub
namespace java knowledge.pub

// If an error occurs, this exception is threw.
exception InvalidReadOperation {
    1: optional string message;
}

// The interface for the read service.
service ReadRpcService {
   // read统一接口,使用bytes传输数据,RPC客户端负责解析
   binary readEntity(1:binary read_entity_request) throws (1:InvalidReadOperation e);

   binary getMetadata(1:binary get_metadata_request) throws (1:InvalidReadOperation e);

   binary getPeopleMetadata(1:binary get_metadata_request) throws (1:InvalidReadOperation e);

   binary getImageMetadata(1:binary get_metadata_request) throws (1:InvalidReadOperation e);

   binary getUgcMetadata(1:binary get_ugc_request) throws (1:InvalidReadOperation e);

   binary getPpsUgcChannelMetadata(1:binary get_metadata_request) throws (1:InvalidReadOperation e);

   binary getLiveMetadata(1:binary get_live_metadata_request) throws (1:InvalidReadOperation e);

   binary getOrganizationSharePartnerMetadata(1:binary get_organization_share_partner_metadata_request) throws (1:InvalidReadOperation e);

   binary getAdsMaterialMetadata(1:binary get_metadata_request) throws (1:InvalidReadOperation e);

   binary getTvLiveCenterMetadata(1:binary get_tv_live_center_metadata_request) throws (1:InvalidReadOperation e);

   // Get deleted status of entity.
   binary getDeleted(1:binary get_deleted_request) throws (1:InvalidReadOperation e);

   binary getFormat(1:binary get_format_request) throws (1:InvalidReadOperation e);

   binary getImageFormat(1:binary get_image_format_request) throws (1:InvalidReadOperation e);

   binary getChildSummary(1:binary get_child_summary_request) throws (1:InvalidReadOperation e);

   binary getLiveChildSummary(1:binary get_live_child_summary_request) throws (1:InvalidReadOperation e);

   binary getTag(1:binary get_tag_request) throws (1:InvalidReadOperation e);

   binary getKeyValuePair(1:binary get_key_value_pair_request) throws (1:InvalidReadOperation e);

   binary getViewLink(1:binary get_view_link_request) throws (1:InvalidReadOperation e);

   binary getSubtitle(1:binary get_subtitle_request) throws (1:InvalidReadOperation e);

   binary getEntity(1:binary get_entity_request) throws (1:InvalidReadOperation e);

   binary getPuyu(1:binary get_puyu_request) throws (1:InvalidReadOperation e);

   binary getSeo(1:binary get_seo_request) throws (1:InvalidReadOperation e);

   binary getBoss(1:binary get_boss_request) throws (1:InvalidReadOperation e);

   binary getBase(1:binary get_base_request) throws (1:InvalidReadOperation e);

   binary getPlatformRegionControl(1:binary get_platform_region_control_request) throws (1:InvalidReadOperation e);

   binary getUgcBase(1:binary get_ugc_base_request) throws (1:InvalidReadOperation e);

   binary getQitan(1:binary get_qitan_request) throws (1:InvalidReadOperation e);

   binary getGameInfo(1:binary get_game_info_request) throws (1:InvalidReadOperation e);

   binary getStreamList(1:binary get_stream_list_request) throws (1:InvalidReadOperation e);

   binary getBaidu(1:binary get_baidu_request) throws (1:InvalidReadOperation e);

   binary getStartEndPoint(1:binary get_start_end_point_request) throws (1:InvalidReadOperation e);

   binary getCollectionType(1:binary get_collection_type_request) throws (1:InvalidReadOperation e);

   binary getCollectionSubType(1:binary get_collection_sub_type_request) throws (1:InvalidReadOperation e);

   binary getAvailableStatus(1:binary get_available_status_request) throws (1:InvalidReadOperation e);

   binary getPagePublishStatus(1:binary get_page_publish_status_request) throws (1:InvalidReadOperation e);

   binary getStats(1:binary get_stats_request) throws (1:InvalidReadOperation e);

   binary getCount(1:binary get_count_request) throws (1:InvalidReadOperation e);

   binary getLiveStatus(1:binary get_live_status_request) throws (1:InvalidReadOperation e);

   binary getSharePartner(1:binary get_share_partner_request) throws (1:InvalidReadOperation e);

   binary getDrmKey(1:binary get_drm_key_request) throws (1:InvalidReadOperation e);

   binary getDoubanId(1:binary get_douban_id_request) throws (1:InvalidReadOperation e);

   binary getPpsUgcChannelIdList(1:binary get_pps_ugc_channel_id_list_request) throws (1:InvalidReadOperation e);

   binary getPpsUgcChannelAuditStatus(1:binary get_pps_ugc_channel_audit_status_request) throws (1:InvalidReadOperation e);

   binary getPpsUgcChannelStats(1:binary get_pps_ugc_channel_stats_request) throws (1:InvalidReadOperation e);

   binary getFatherAlbum(1:binary get_father_album_request) throws (1:InvalidReadOperation e);

   binary getFatherCollection(1:binary get_father_collection_request) throws (1:InvalidReadOperation e);

   binary getFatherUgcCollection(1:binary get_father_ugc_collection_request) throws (1:InvalidReadOperation e);

   binary getFatherVideoGroup(1:binary get_father_video_group_request) throws (1:InvalidReadOperation e);

   binary getFatherPpsCategory(1:binary get_father_pps_category_request) throws (1:InvalidReadOperation e);

   binary getOfficialEpisodeId(1:binary get_official_episode_id_request) throws (1:InvalidReadOperation e);

   binary getLastUpdateTime(1:binary get_last_update_time_request) throws (1:InvalidReadOperation e);

   binary getMultiPublish(1:binary get_multi_publish_request) throws (1:InvalidReadOperation e);

   binary getAggregation(1:binary get_aggregation_request) throws (1:InvalidReadOperation e);

   binary getResourceElementsChildSummary(1:binary get_resource_elements_child_summary_request) throws (1:InvalidReadOperation e);

   binary getIsResourceGroup(1:binary get_is_resource_group) throws (1:InvalidReadOperation e);

   binary getResourceType(1:binary get_resource_type) throws (1:InvalidReadOperation e);

   binary getFilmTvMetadata(1:binary get_film_tv_metadata_request) throws (1:InvalidReadOperation e);
   binary getPlaySourceId(1: binary get_play_resource_id_request) throws (1:InvalidReadOperation e);

  // This interface is used to get related qipu entity of film tv library.
   binary getQipuId(1: binary get_qipu_id_request) throws (1:InvalidReadOperation e);

   binary getPoster(1: binary get_poster_request) throws (1:InvalidReadOperation e);

   binary getOtherImage(1: binary get_other_image_request) throws (1:InvalidReadOperation e);

   binary getVideoFileInfo(1:binary get_video_file_info_request) throws (1:InvalidReadOperation e);

   binary getUgcCheck(1:binary get_ugc_check_request) throws (1:InvalidReadOperation e);

   binary getRelatedPeopleList(1:binary get_related_people_list_request) throws (1:InvalidReadOperation e);

   binary getRelatedEpisodeList(1:binary get_related_episode_list_request) throws (1:InvalidReadOperation e);

   binary getPassportId(1:binary get_passport_id_request) throws (1:InvalidReadOperation e);

   binary getRepresentativeWorkList(1:binary get_representative_work_list_request) throws (1:InvalidReadOperation e);

   binary getTvChannel(1:binary get_tv_channel_request) throws (1:InvalidReadOperation e);

   binary getElectronicProgramGuide(1:binary get_electronic_program_guide_request) throws (1:InvalidReadOperation e);

   binary getTvLiveBase(1:binary get_tv_live_base_request) throws (1:InvalidReadOperation e);

   binary getTvLiveStreamList(1:binary get_tv_live_stream_list_request) throws (1:InvalidReadOperation e);

  binary getUgcOperation(1:binary get_ugc_operation_request) throws (1:InvalidReadOperation e);

   binary getPpsUrls(1:binary get_pps_urls_request) throws (1:InvalidReadOperation e);

   binary getContentType(1:binary get_content_type_request) throws (1:InvalidReadOperation e);

   binary getPpsCategoryBase(1:binary get_pps_category_base_request) throws (1:InvalidReadOperation e);

   binary getPpsCategoryPlatformData(1:binary get_pps_category_platform_data_request) throws (1:InvalidReadOperation e);

   binary getTotalDuration(1:binary get_total_duration_request) throws (1:InvalidReadOperation e);

   binary getUgcPlayListInfo(1:binary get_ugc_play_list_info_request) throws (1:InvalidReadOperation e);

   binary getBrand(1:binary get_brand_request) throws (1:InvalidReadOperation e);

   binary getSearchInfo(1:binary get_search_info_request) throws (1:InvalidReadOperation e);

   binary getFilmTvCheckStatus(1:binary get_film_tv_check_status_request) throws (1:InvalidReadOperation e);

   binary getFingerprint(1:binary get_fingerprint_request) throws (1:InvalidReadOperation e);

   binary getAccessPlayControl(1:binary get_access_play_control_request) throws (1:InvalidReadOperation e);

  /**
   * The read interfaces of getting for ppsCategoryRanking.
   * get the field of ppsCategoryRanking from the entity of 
   * album, episode, collection or ppsCategory, or throws an exception if this operation is not valid.
   */
   binary getPpsCategoryRanking(1:binary get_pps_category_ranking_request) throws (1:InvalidReadOperation e);
}
