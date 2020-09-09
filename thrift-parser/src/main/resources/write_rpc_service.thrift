// Author: Yin Zeng(zengyin@reploop.com)
//
// This file defines the interface of writing service of qipu.

namespace cpp knowledge.pub
namespace java knowledge.pub


include "test.thrift"

exception InvalidWriteOperation {
  1: optional string message;
}

// The entity.
struct Entity {
   // The entity id.
   1: optional i32 id;
}
// Support
enum Support {
    // Support E
    E = 1;
    // Support F
    F = 2;
}

service WriteRpcService2 {
  void setMetadata2(1:binary set_metadata_request)
      throws (1:InvalidWriteOperation e);

}
/**
 * The Write Rpc Service.
 */
service WriteRpcService {
  // All functions in this service
  //
  // @param binary string of corresponding proto defined in write_service.proto
  // @return binary string of WriteResponse defined in write_service.proto
  // @throws InvalidWriteOperation

  void setMetadata(1:binary set_metadata_request)
      throws (1:InvalidWriteOperation e);
  i32 setPeopleMetadata(1:binary set_people_metadata_request)
      throws (1:InvalidWriteOperation e);
  InvalidWriteOperation setImageMetadata(1:binary set_image_metadata_request)
      throws (1:InvalidWriteOperation e);
  binary setUgcMetadata(1:binary set_ugc_metadata_request)
      throws (1:InvalidWriteOperation e);
  binary setLiveMetadata(1:binary set_live_metadata_request)
      throws (1:InvalidWriteOperation e);
  binary setPpsUgcChannelMetadata(1:binary set_pps_ugc_channel_metadata_request)
      throws (1:InvalidWriteOperation e);
  i32 setOrganizationSharePartnerMetadata(1:binary set_organization_share_partner_metadata_request)
      throws (1:InvalidWriteOperation e);
  binary setAdsMaterialMetadata(1:binary set_ads_material_metadata_request)
      throws (1:InvalidWriteOperation e);
  binary setTvLiveCenterMetadata(1:binary set_tv_live_center_metadata_request)
      throws (1:InvalidWriteOperation e);
  binary setAppGroupMetadata(1:binary set_app_group_metadata_request)
      throws (1:InvalidWriteOperation e);

  binary setDeleted(1:binary set_deleted_request)
      throws (1:InvalidWriteOperation e);

  binary setPuyu(1:binary set_puyu_request)
      throws (1:InvalidWriteOperation e);

  binary setSeo(1:binary set_seo_request)
      throws (1:InvalidWriteOperation e);

  binary setBase(1:binary set_base_request)
      throws (1:InvalidWriteOperation e);

  binary setCommonBase(1:binary set_common_base_request)
      throws (1:InvalidWriteOperation e);

  binary setUgcBase(1:binary set_ugc_base_request)
      throws (1:InvalidWriteOperation e);

  binary setVideoFileInfo(1:binary set_video_file_info_request)
      throws (1:InvalidWriteOperation e);

  binary setUgcCheck(1:binary set_ugc_check_request)
      throws (1:InvalidWriteOperation e);

  binary setBoss(1:binary set_boss_request)
      throws (1:InvalidWriteOperation e);

  // Please only set stats.PlayCount
  binary setStats(1:binary set_stats_request)
      throws (1:InvalidWriteOperation e);

  binary increaseStatsCount(1:binary increase_stats_count_request)
      throws (1:InvalidWriteOperation e);

  binary setStatsCount(1:binary set_stats_counts_request)
      throws (1:InvalidWriteOperation e);

  binary setDoubanId(1:binary set_douban_id_request)
      throws (1:InvalidWriteOperation e);

  binary setQitan(1:binary set_qitan_request)
      throws (1:InvalidWriteOperation e);

  binary setBaidu(1:binary set_baidu_request)
      throws (1:InvalidWriteOperation e);

  binary setStartEndPoint(1:binary set_start_end_point_request)
      throws (1:InvalidWriteOperation e);

  binary setCollectionType(1:binary set_collection_type_request)
      throws (1:InvalidWriteOperation e);

  binary setCollectionSubType(1:binary set_collection_sub_type_request)
      throws (1:InvalidWriteOperation e);

  binary setAvailableStatus(1:binary set_available_status_request)
      throws (1:InvalidWriteOperation e);
  binary setPagePublishStatus(1:binary set_page_publish_status_request)
      throws (1:InvalidWriteOperation e);

  binary setSharePartner(1:binary set_share_partner_request)
      throws (1:InvalidWriteOperation e);

  binary setDrmKey(1:binary set_drm_key_request)
      throws (1:InvalidWriteOperation e);
  binary setPpsUgcChannelAuditStatus(1:binary set_pps_ugc_channel_audit_status_request)
      throws (1:InvalidWriteOperation e);
  binary setPpsUgcChannelStats(1:binary set_pps_ugc_channel_stats_request)
      throws (1:InvalidWriteOperation e);
  binary setPpsUgcChannelIdList(1:binary set_pps_channel_id_list_request)
      throws (1:InvalidWriteOperation e);

  binary setLiveStatus(1:binary set_live_status_request)
      throws (1:InvalidWriteOperation e);
  binary setGameInfo(1:binary set_game_info_request)
      throws (1:InvalidWriteOperation e);
  binary setStreamList(1:binary set_stream_list_request)
      throws (1:InvalidWriteOperation e);

  binary setIsResourceGroup(1:binary set_is_resource_group_request)
      throws (1:InvalidWriteOperation e);

  binary setResourceType(1:binary set_resource_type_request)
      throws (1:InvalidWriteOperation e);

  binary setPlatformRegionControl(1:binary set_platform_region_control_request)
      throws (1:InvalidWriteOperation e);

  binary setRelatedPeopleList(1:binary set_related_people_list_request)
      throws (1:InvalidWriteOperation e);
  binary setRelatedEpisodeList(1:binary set_related_episode_list_request)
      throws (1:InvalidWriteOperation e);
  binary setPassportId(1:binary set_passport_id_request)
      throws (1:InvalidWriteOperation e);
  binary setRepresentativeWorkList(1:binary set_representative_work_list_request)
      throws (1:InvalidWriteOperation e);

  binary setContentType(1:binary set_content_type_request)
      throws (1:InvalidWriteOperation e);
  binary setPpsCategoryPlatformData(1:binary set_pps_category_platform_data_request)
      throws (1:InvalidWriteOperation e);
  binary setPpsCategoryBase(1:binary set_pps_category_base_request)
      throws (1:InvalidWriteOperation e);

  binary setTotalDuration(1:binary set_total_duration_request)
      throws (1:InvalidWriteOperation e);
  binary setUgcPlayListInfo(1:binary set_ugc_play_list_info_request)
      throws (1:InvalidWriteOperation e);
  binary setBrand(1:binary set_brand_request)
      throws (1:InvalidWriteOperation e);

  binary setSearchInfo(1:binary set_search_info_request)
      throws (1:InvalidWriteOperation e);
  binary setFilmTvCheckStatus(1:binary set_film_tv_check_status_request)
      throws (1:InvalidWriteOperation e);
  binary setFilmTvId(1:binary set_film_tv_id_request)
      throws (1:InvalidWriteOperation e);

  binary setIsAppGroup(1:binary set_is_app_group_request)
      throws (1:InvalidWriteOperation e);
  binary setAppMediaList(1:binary set_app_media_list_request)
      throws (1:InvalidWriteOperation e);
  binary setAppGameInfo(1:binary set_app_game_info_request)
      throws (1:InvalidWriteOperation e);
  binary setAppPermissionList(1:binary set_app_permission_list_request)
      throws (1:InvalidWriteOperation e);
  binary setAppCheck(1:binary set_app_check_request)
      throws (1:InvalidWriteOperation e);
  binary setAppRating(1:binary set_app_rating_request)
      throws (1:InvalidWriteOperation e);
  binary setAppBase(1:binary set_app_base_request)
      throws (1:InvalidWriteOperation e);

  binary setVoteInfo(1:binary set_vote_info_request)
      throws (1:InvalidWriteOperation e);
  binary setCopyrightProtection(1:binary set_copyright_protection_request)
      throws (1:InvalidWriteOperation e);
  binary setVirtualUgcInfo(1:binary set_virtual_ugc_info_request)
      throws (1:InvalidWriteOperation e);
  binary setRecommendDataSourceList(1:binary set_recommend_data_source_list_request)
      throws (1:InvalidWriteOperation e);
  binary setOnlineCountUpdateStrategy(1:binary set_online_count_update_strategy_request)
      throws (1:InvalidWriteOperation e);
  binary setMusicInfo(1:binary set_music_info_request)
      throws (1:InvalidWriteOperation e);
  binary setSiteInfoList(1:binary set_site_info_list_request)
      throws (1:InvalidWriteOperation e);
  binary setDoubanInfo(1:binary set_douban_info_request)
      throws (1:InvalidWriteOperation e);

  binary setFingerprint(1:binary set_fingerprint_request)
      throws (1:InvalidWriteOperation e);

  binary deleteOptionField(1:binary delete_option_field_request)
      throws (1:InvalidWriteOperation e);

  binary addTvLiveStreamList(1:binary add_tv_live_stream_list_request)
      throws (1:InvalidWriteOperation e);
  binary deleteTvLiveStreamList(1:binary delete_tv_live_stream_list_request)
      throws (1:InvalidWriteOperation e);
  binary addTvLiveBase(1:binary add_tv_live_base_request)
      throws (1:InvalidWriteOperation e);
  binary deleteTvLiveBase(1:binary delete_tv_live_base_request)
      throws (1:InvalidWriteOperation e);

  binary addTvChannel(1:binary add_tv_channel_request)
      throws (1:InvalidWriteOperation e);
  binary deleteTvChannel(1:binary delete_tv_channel_request)
      throws (1:InvalidWriteOperation e);
  binary addElectronicProgramGuide(1:binary add_electronic_program_guide_request)
      throws (1:InvalidWriteOperation e);
  binary deleteElectronicProgramGuide(1:binary delete_electronic_program_guide_request)
      throws (1:InvalidWriteOperation e);

  binary addFormat(1:binary add_format_request)
      throws (1:InvalidWriteOperation e);
  binary deleteFormat(1:binary delete_format_request)
      throws (1:InvalidWriteOperation e);
  binary addImageFormat(1:binary add_image_format_request)
      throws (1:InvalidWriteOperation e);
  binary deleteImageFormat(1:binary delete_image_format_request)
      throws (1:InvalidWriteOperation e);

  binary setSingularFather(1:binary set_singular_father_request)
      throws (1:InvalidWriteOperation e);
  binary setLiveChildSummary(1:binary set_live_child_summary_request)
      throws (1:InvalidWriteOperation e);
  binary setUgcOperation(1:binary set_ugc_operation_request)
      throws (1:InvalidWriteOperation e);
  binary setPpsUrls(1:binary set_pps_urls_request)
      throws (1:InvalidWriteOperation e);
  binary setUploadType(1:binary set_upload_type_request)
      throws (1:InvalidWriteOperation e);

  binary setMiniAutoClusterBase(1:binary set_mini_auto_cluster_base_request)
      throws (1:InvalidWriteOperation e);
  binary addAlbumVideoData(1:binary add_album_video_request)
      throws (1:InvalidWriteOperation e);
  binary deleteAlbumVideoData(1:binary delete_album_video_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The difference between adding and deleting a repeated father(collection father
   * and video_group father) is whether set the is_valid flag, with true indicating
   * it is valid, vice versa.
   * For a CollectionFather expected to be deleted, the is_valid should be set to
   * false in this CollectionFather.
   */
  binary setRepeatedFather(1:binary set_repeated_father_request)
      throws (1:InvalidWriteOperation e);

  binary addChildSummary(1:binary add_child_summary_request)
      throws (1:InvalidWriteOperation e);
  binary deleteChildSummary(1:binary delete_child_summary_request)
      throws (1:InvalidWriteOperation e);

  binary addTag(1:binary add_tag_request)
      throws (1:InvalidWriteOperation e);
  binary deleteTag(1:binary delete_tag_request)
      throws (1:InvalidWriteOperation e);

  binary addKeyValuePair(1:binary add_key_value_pair_request)
      throws (1:InvalidWriteOperation e);
  binary deleteKeyValuePair(1:binary delete_key_value_pair_request)
      throws (1:InvalidWriteOperation e);

  binary addViewLink(1:binary add_view_link_request)
      throws (1:InvalidWriteOperation e);
  binary deleteViewLink(1:binary delete_view_link_request)
      throws (1:InvalidWriteOperation e);

  binary addSubtitle(1:binary add_subtitle_request)
      throws (1:InvalidWriteOperation e);
  binary deleteSubtitle(1:binary delete_subtitle_request)
      throws (1:InvalidWriteOperation e);

  binary addResourceElements(1:binary add_resource_elements_request)
      throws (1:InvalidWriteOperation e);
  binary deleteResourceElements(1:binary delete_resource_elements_request)
      throws (1:InvalidWriteOperation e);

  binary addAppVersionChangeInfo(1:binary add_app_version_change_info_request)
      throws (1:InvalidWriteOperation e);
  binary deleteAppVersionChangeInfo(1:binary delete_app_version_change_info_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The difference between adding a MultiPublish and deleting a MultiPublish
   * is whether set the is_valid flag, with true indicating it is valid, vice versa.
   * For a MultiPublish expected to be deleted, the is_valid should be set to
   * false in this MultiPublish.
   */
  binary setMultiPublish(1:binary set_multi_publish_request)
      throws (1:InvalidWriteOperation e);
  binary deleteMultiPublish(1:binary delete_multi_publish_request)
      throws (1:InvalidWriteOperation e);

  binary setFilmTvMetadata(1: binary set_film_tv_metadata_request)
      throws (1:InvalidWriteOperation e);

  binary setPlaySourceId(1: binary set_play_resource_id_request)
      throws (1:InvalidWriteOperation e);

  binary setQipuId(1: binary set_qipu_id_request) throws (1:InvalidWriteOperation e);

  binary setPoster(1: binary set_poster_request) throws (1:InvalidWriteOperation e);

  binary addOtherImage(1: binary add_other_image_request) throws (1:InvalidWriteOperation e);

  binary deleteOtherImage(1: binary delete_other_image_request) throws (1:InvalidWriteOperation e);

  binary addAccessPlayControl(1:binary add_access_play_control_request)
      throws (1:InvalidWriteOperation e);
  binary deleteAccessPlayControl(1:binary delete_access_play_control_request)
      throws (1:InvalidWriteOperation e);

  /**
   * Add or delete the field of feed from the entity of filmTvLibrary, or throws an exception if this operation is not
   * valid.
   */
  binary addFeed(1:binary add_feed_request) throws (1:InvalidWriteOperation e);
  binary deleteFeed(1:binary delete_feed_request) throws (1:InvalidWriteOperation e);

  /**
   * Set the field of liveChannelBase | isEnable | defaultLiveStream from the entity of liveChannel, or throws an exception if this operation is not
   * valid.
   */
  binary setLiveChannelBase(1: binary set_live_channel_base_request) throws (1:InvalidWriteOperation e);
  binary setIsEnable(1: binary set_is_enable_request) throws (1:InvalidWriteOperation e);
  binary setDefaultLiveStream(1: binary set_default_live_stream_request) throws (1:InvalidWriteOperation e);

  /**
   * Add or delete the field of liveStream from the entity of liveChannel, or throws an exception if this operation is not
   * valid.
   */
  binary addLiveStream(1:binary add_live_stream_request) throws (1:InvalidWriteOperation e);
  binary deleteLiveStream(1:binary delete_live_stream_request) throws (1:InvalidWriteOperation e);

  /**
   * Set the field of liveEpisodeMetadata | liveEpisodeBase | liveEpisodeChargeInfo | liveSports from the entity of liveEpisode,
   * or throws an exception if this operation is not valid.
   */
  binary setLiveEpisodeMetadata(1: binary set_live_episode_metadata_request) throws (1:InvalidWriteOperation e);
  binary setLiveEpisodeBase(1: binary set_live_episode_base_request) throws (1:InvalidWriteOperation e);
  binary setLiveEpisodeChargeInfo(1: binary set_live_episode_charge_info_request) throws (1:InvalidWriteOperation e);
  binary setLiveSports(1: binary set_Live_sports_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for E-Business.
   * Set the field of commodityBase | itemStat | itemDescription | itemShelving | itemAfterSale | itemShipment
   * commodityExtra | mainEpisode | approvalStatus from the entity of commodity,
   * or set the field of spuBase from the entity of spu,
   * or set the field of itemBrandBase from the entity of itemBrand,
   * or throws an exception if this operation is not valid.
   */
  binary setCommodityBase(1: binary set_commodity_base_request) throws (1:InvalidWriteOperation e);
  binary setItemStat(1: binary set_item_stat_request) throws (1:InvalidWriteOperation e);
  binary setItemDescription(1: binary set_item_description_request) throws (1:InvalidWriteOperation e);
  binary setItemShelving(1: binary set_item_shelving_request) throws (1:InvalidWriteOperation e);
  binary setItemAfterSale(1: binary set_item_after_sale_request) throws (1:InvalidWriteOperation e);
  binary setItemShipment(1: binary set_item_shipment_request) throws (1:InvalidWriteOperation e);
  binary setCommodityExtra(1: binary set_commodity_extra_request) throws (1:InvalidWriteOperation e);
  binary setSpuBase(1: binary set_spu_base_request) throws (1:InvalidWriteOperation e);
  binary setItemBrandBase(1: binary set_item_brand_base_request) throws (1:InvalidWriteOperation e);
  binary setMainEpisode(1: binary set_main_episode_request) throws (1:InvalidWriteOperation e);
  binary setApprovalStatus(1:binary set_approval_status_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of adding and deleting for E-Business.
   * Add or delete the field of sku from the entity of commodity,
   * or add | delete the field of itemProperty from the entity of spu,
   * or throws an exception if this operation is not valid.
   */
  binary addSku(1:binary add_sku_request) throws (1:InvalidWriteOperation e);
  binary deleteSku(1:binary delete_sku_request) throws (1:InvalidWriteOperation e);
  binary addItemProperty(1:binary add_item_property_request) throws (1:InvalidWriteOperation e);
  binary deleteItemProperty(1:binary delete_item_property_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for film tickets.
   * Set the field of on theater from the entity of filmTvLibrary,
   * or set the field of theaterBase | route | theaterScore | Openning | Rank from the entity of Theater,
   * or throws an exception if this operation is not valid.
   */
  binary setOnTheater(1:binary set_on_theater_request) throws (1:InvalidWriteOperation e);
  binary setTheaterBase(1:binary set_theater_base_request) throws (1:InvalidWriteOperation e);
  binary setRoute(1:binary set_route_request) throws (1:InvalidWriteOperation e);
  binary setTheaterScore(1:binary set_theater_score_request) throws (1:InvalidWriteOperation e);
  binary setOpenning(1:binary set_openning_request) throws (1:InvalidWriteOperation e);
  binary setRank(1:binary set_rank_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for qiqu tag.
   * Set the field of qiquTagMetadata | quality | hot | resultCheck from the entity of QiquTag,
   * or throws an exception if this operation is not valid.
   */
  binary setQiquTagMetadata(1:binary set_qipu_tag_metadata_request) throws (1:InvalidWriteOperation e);
  binary setQuality(1:binary set_quality_request) throws (1:InvalidWriteOperation e);
  binary setHot(1:binary set_hot_request) throws (1:InvalidWriteOperation e);
  binary setResultCheck(1:binary set_result_check_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of adding and deleting for qiqu tag.
   * Add or delete the field of relatedTag | qiquTagSummary from the entity of QiquTag,
   * or throws an exception if this operation is not valid.
   */
  binary addRelatedTag(1:binary add_related_tag_request) throws (1:InvalidWriteOperation e);
  binary deleteRelatedTag(1:binary delete_related_tag_request) throws (1:InvalidWriteOperation e);
  binary addQiquTagSummary(1:binary add_qiqu_tag_summary_request) throws (1:InvalidWriteOperation e);
  binary deleteQiquTagSummary(1:binary delete_qiqu_tag_summary_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of adding and deleting for ppsCategoryRanking.
   * Add or delete the field of ppsCategoryRanking from the entity of album, episode, collection or ppsCategory,
   * or throws an exception if this operation is not valid.
   */
  binary addPpsCategoryRanking(1:binary add_pps_category_ranking_request) throws (1:InvalidWriteOperation e);
  binary deletePpsCategoryRanking(1:binary delete_pps_category_ranking_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for episodeType.
   * Set the field of episodeType from the entity of episode,
   * or throws an exception if this operation is not valid.
   */
  binary setEpisodeType(1:binary set_episode_type_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for autoPlaylistInfo.
   * Set the field of autoPlaylistInfo from the entity of collection,
   * or throws an exception if this operation is not valid.
   */
  binary setAutoPlaylistInfo(1:binary set_auto_playlist_info_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for appGroup.
   * Set the field of detailPageUrl | monthlyDownloadCount from the entity of AppGroup,
   * or throws an exception if this operation is not valid.
   */
  binary setDetailPageUrl(1:binary set_detail_page_url_request) throws (1:InvalidWriteOperation e);
  binary setMonthlyDownloadCount(1:binary set_monthly_download_count_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for ppsCategory.
   * Set the field of updateFrequence from the entity of PpsCategory,
   * or throws an exception if this operation is not valid.
   */
  binary setUpdateFrequence(1:binary set_update_frequence_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of adding and deleting for ppsCategory.
   * Add or delete the field of updateSource from the entity of ppsCategory,
   * or throws an exception if this operation is not valid.
   */
  binary addUpdateSource(1:binary add_update_source_request) throws (1:InvalidWriteOperation e);
  binary deleteUpdateSource(1:binary delete_update_source_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of adding and deleting for filmTvLibrary.
   * Add or delete the field of season from the entity of filmTvLibrary,
   * or throws an exception if this operation is not valid.
   */
  binary addSeason(1:binary add_season_request) throws (1:InvalidWriteOperation e);
  binary deleteSeason(1:binary delete_season_request) throws (1:InvalidWriteOperation e);
  binary deleteAllSeasons(1:binary delete_all_seasons_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for topicMetadata.
   * Set the field of topicMetadata from the entity of topic,
   * or throws an exception if this operation is not valid.
   */
  binary setTopicMetadata(1:binary set_topic_metadata_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for shop.
   * Set the field of shopBase,shopLinkage,shopScore,bulletin and status from the entity of Shop,
   * or throws an exception if this operation is not valid.
   */
  binary setShopBase(1:binary set_shop_base_request) throws (1:InvalidWriteOperation e);
  binary setShopLinkage(1:binary set_shop_linkage_request) throws (1:InvalidWriteOperation e);
  binary setShopScore(1:binary set_shop_score_request) throws (1:InvalidWriteOperation e);
  binary setBulletin(1:binary set_bulletin_request) throws (1:InvalidWriteOperation e);
  binary setStatus(1:binary set_status_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Episode.
   * Set the field of topicMetadata from the entity of topic,
   * or throws an exception if this operation is not valid.
   */
  binary setOcrTag(1:binary set_ocr_tag_request) throws (1:InvalidWriteOperation e);
  binary setAsrTag(1:binary set_asr_tag_request) throws (1:InvalidWriteOperation e);
  binary setSmartTag(1:binary set_smart_tag_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of adding and deleting for episode.
   * Add or delete the field of topicSummary from the entity of episode,
   * or throws an exception if this operation is not valid.
   */
  binary addTopicSummary(1:binary add_topic_summary_request) throws (1:InvalidWriteOperation e);
  binary deleteTopicSummary(1:binary delete_topic_summary_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of adding and deleting for spu.
   * Add or delete the field of albumSummary | episodeSummary | peopleSummary
   * from the entity of spu,
   * or throws an exception if this operation is not valid.
   */
  binary addSpuChildSummary(1:binary add_spu_child_summary_request) throws (1:InvalidWriteOperation e);
  binary deleteSpuChildSummary(1:binary delete_spu_child_summary_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of deleting for qipu entity.
   * Delete all the fields of tag from the entity of qipu,
   * or throws an exception if this operation is not valid.
   */
  binary deleteAllTags(1:binary delete_all_tags_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of adding and deleting for episode|album.
   * Add or delete the field of categorySummary from the entity of episode|album,
   * or throws an exception if this operation is not valid.
   */
  binary addCategorySummary(1:binary add_category_summary_request) throws (1:InvalidWriteOperation e);
  binary deleteCategorySummary(1:binary delete_category_summary_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Episode|UgcEpisode.
   * Set the field of adPointTag from the entity of episode|ugcEpisode,
   * or throws an exception if this operation is not valid.
   */
  binary setAdPointTag(1:binary set_ad_point_tag_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for LiveChannel|LiveEpisode.
   * Set the field of pageUrl from the entity of liveChannel|liveEpisode,
   * or throws an exception if this operation is not valid.
   */
  binary setPageUrl(1:binary set_page_url_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of adding and deleting for episode|album.
   * Add or delete the field of notice from the entity of episode|album,
   * or throws an exception if this operation is not valid.
   */
  binary addNotice(1:binary add_notice_request) throws (1:InvalidWriteOperation e);
  binary deleteNotice(1:binary delete_notice_request) throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for album|episode|filmTvLibrary|people.
   * Set the field of relatedVideos from the entity of album|episode|filmTvLibrary|people,
   * or throws an exception if this operation is not valid.
   */
  binary setRelatedVideos(1:binary set_related_videos_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for album|episode|filmTvLibrary|people.
   * Set the field of relatedCelebrities from the entity of album|episode|filmTvLibrary|people,
   * or throws an exception if this operation is not valid.
   */
  binary setRelatedCelebrities(1:binary set_related_celebrities_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of adding and deleting for Presenter.
   * Add or delete the field of alias_name from the entity of Presenter,
   * or throws an exception if this operation is not valid.
   */
  binary addAliasName(1:binary add_alias_name_request)
      throws (1:InvalidWriteOperation e);
  binary deleteAliasName(1:binary delete_alias_name_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Presenter.
   * Set the field of grade from the entity of Presenter,
   * or throws an exception if this operation is not valid.
   */
  binary setGrade(1:binary set_grade_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Presenter|ShowRoom.
   * Set the field of recommend_rate from the entity of Presenter|ShowRoom,
   * or throws an exception if this operation is not valid.
   */
  binary setRecommendRate(1:binary set_recommend_rate_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Presenter|ShowRoom.
   * Set the field of recommend_remark from the entity of Presenter|ShowRoom,
   * or throws an exception if this operation is not valid.
   */
  binary setRecommendRemark(1:binary set_recommend_remark_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for ShowRoom.
   * Set the field of url from the entity of ShowRoom,
   * or throws an exception if this operation is not valid.
   */
  binary setUrl(1:binary set_url_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for ShowRoom.
   * Set the field of current_presenter_id from the entity of ShowRoom,
   * or throws an exception if this operation is not valid.
   */
  binary setCurrentPresenterId(1:binary set_current_presenter_id_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for ShowRoom.
   * Set the field of show_status from the entity of ShowRoom,
   * or throws an exception if this operation is not valid.
   */
  binary setShowStatus(1:binary set_show_status_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for ShowRoom.
   * Set the field of start_time from the entity of ShowRoom,
   * or throws an exception if this operation is not valid.
   */
  binary setStartTime(1:binary set_start_time_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for ShowRoom.
   * Set the field of audience_count from the entity of ShowRoom,
   * or throws an exception if this operation is not valid.
   */
  binary setAudienceCount(1:binary set_audience_count_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for ShowRoom.
   * Set the field of room_type from the entity of ShowRoom,
   * or throws an exception if this operation is not valid.
   */
  binary setRoomType(1:binary set_room_type_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Collection.
   * Set the field of graph_playlist_type from the entity of Collection,
   * or throws an exception if this operation is not valid.
   */
  binary setGraphPlaylistType(1:binary set_graph_playlist_type_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Collection|Album|Episode|People|UgcEpisode|UgcCollection|FilmTvLibrary.
   * Set the field of up_down_score from the entity of Collection|Album|Episode|People|UgcEpisode|UgcCollection|FilmTvLibrary,
   * or throws an exception if this operation is not valid.
   */
  binary setUpDownScore(1:binary set_up_down_score_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for SnsScore.
   * Set the field of sns_score from the entity of Album|Episode|FilmTvLibrary,
   * or throws an exception if this operation is not valid.
   */
  binary setSnsScore(1:binary set_sns_score_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for AudioFormat.
   * Add the field of audio_format from the entity of Episode,
   * or throws an exception if this operation is not valid.
   */
  binary addAudioFormat(1:binary add_audio_format_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for AudioFormat.
   * Delete the field of audio_format from the entity of Episode,
   * or throws an exception if this operation is not valid.
   */
  binary deleteAudioFormat(1:binary delete_audio_format_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Promotion.
   * Add the field of promotion from the entity of Commodity,
   * or throws an exception if this operation is not valid.
   */
  binary addPromotion(1:binary add_promotion_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Promotion.
   * Delete the field of promotion from the entity of Commodity,
   * or throws an exception if this operation is not valid.
   */
  binary deletePromotion(1:binary delete_promotion_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Image.
   * Delete the field of image_format from the entity of Image,
   * or throws an exception if this operation is not valid.
   */
  binary deleteAllImageFormat(1:binary delete_all_image_format_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Collection|Videogroup.
   * Delete the field of ChildSummary from the entity of Collection|Videogroup,
   * or throws an exception if this operation is not valid.
   */
  binary setChildSummaryList(1:binary set_child_summary_list_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Presenter.
   * Set the field of fan_count from the entity of Presenter,
   * or throws an exception if this operation is not valid.
   */
  binary setFanCount(1:binary set_fan_count_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Presenter.
   * Set the field of last_live_end_time from the entity of Presenter,
   * or throws an exception if this operation is not valid.
   */
  binary setLastLiveEndTime(1:binary set_last_live_end_time_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Presenter.
   * Set the field of next_live_start_time from the entity of Presenter,
   * or throws an exception if this operation is not valid.
   */
  binary setNextLiveStartTime(1:binary set_next_live_start_time_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Presenter.
   * Set the field of current_live_start_time from the entity of Presenter,
   * or throws an exception if this operation is not valid.
   */
  binary setCurrentLiveStartTime(1:binary set_current_live_start_time_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Presenter.
   * Set the field of current_live_end_time from the entity of Presenter,
   * or throws an exception if this operation is not valid.
   */
  binary setCurrentLiveEndTime(1:binary set_current_live_end_time_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Presenter.
   * Add the field of owned_metal from the entity of Presenter,
   * or throws an exception if this operation is not valid.
   */
  binary addOwnedMetal(1:binary add_owned_metal_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Presenter.
   * Delete the field of owned_metal from the entity of Presenter,
   * or throws an exception if this operation is not valid.
   */
  binary deleteOwnedMetal(1:binary delete_owned_metal_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Presenter.
   * Set the field of show_room_name from the entity of Presenter,
   * or throws an exception if this operation is not valid.
   */
  binary setShowRoomName(1:binary set_show_room_name_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Commodity.
   * Add the field of commodity_category from the entity of Commodity,
   * or throws an exception if this operation is not valid.
   */
  binary addCommodityCategory(1:binary add_commodity_category_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Presenter.
   * Delete the field of commodity_category from the entity of Commodity,
   * or throws an exception if this operation is not valid.
   */
  binary deleteCommodityCategory(1:binary delete_commodity_category_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Episode.
   * Set the field of pano_format from the entity of Episode,
   * or throws an exception if this operation is not valid.
   */
  binary setPanoFormat(1:binary set_pano_format_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Episode.
   * Add the field of celebrity_figure_out from the entity of Episode,
   * or throws an exception if this operation is not valid.
   */
  binary addCelebrityFigureOut(1:binary add_celebrity_figure_out_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Episode.
   * Delete the field of celebrity_figure_out from the entity of Episode,
   * or throws an exception if this operation is not valid.
   */
  binary deleteCelebrityFigureOut(1:binary delete_celebrity_figure_out_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for UgcEpisode.
   * Set all field of UgcEpisode,
   * or throws an exception if this operation is not valid.
   */
  binary setUgcEpisode(1:binary set_ugc_episode_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Album.
   * Set all field of Album,
   * or throws an exception if this operation is not valid.
   */
  binary setAlbum(1:binary set_album_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Episode.
   * Set all field of Episode,
   * or throws an exception if this operation is not valid.
   */
  binary setEpisode(1:binary set_episode_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Collection.
   * Set all field of Collection,
   * or throws an exception if this operation is not valid.
   */
  binary setCollection(1:binary set_collection_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Image.
   * Set all field of Image,
   * or throws an exception if this operation is not valid.
   */
  binary setImage(1:binary set_image_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for People.
   * Set all field of People,
   * or throws an exception if this operation is not valid.
   */
  binary setPeople(1:binary set_people_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Css.
   * Set all field of Css,
   * or throws an exception if this operation is not valid.
   */
  binary setCss(1:binary set_css_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for VideoGroup.
   * Set all field of VideoGroup,
   * or throws an exception if this operation is not valid.
   */
  binary setVideoGroup(1:binary set_video_group_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for LiveBroadcast.
   * Set all field of LiveBroadcast,
   * or throws an exception if this operation is not valid.
   */
  binary setLiveBroadcast(1:binary set_live_broadcast_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for ResourceContainer.
   * Set all field of ResourceContainer,
   * or throws an exception if this operation is not valid.
   */
  binary setResourceContainer(1:binary set_resource_container_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for PpsUgcChannel.
   * Set all field of PpsUgcChannel,
   * or throws an exception if this operation is not valid.
   */
  binary setPpsUgcChannel(1:binary set_pps_ugc_channel_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for FilmTvLibrary.
   * Set all field of FilmTvLibrary,
   * or throws an exception if this operation is not valid.
   */
  binary setFilmTvLibrary(1:binary set_film_tv_library_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for OrganizationSharePartner.
   * Set all field of OrganizationSharePartner,
   * or throws an exception if this operation is not valid.
   */
  binary setOrganizationSharePartner(1:binary set_organization_share_partner_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for UgcCollection.
   * Set all field of UgcCollection,
   * or throws an exception if this operation is not valid.
   */
  binary setUgcCollection(1:binary set_ugc_collection_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for AdsMaterial.
   * Set all field of AdsMaterial,
   * or throws an exception if this operation is not valid.
   */
  binary setAdsMaterial(1:binary set_ads_material_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for TvLiveCenter.
   * Set all field of TvLiveCenter,
   * or throws an exception if this operation is not valid.
   */
  binary setTvLiveCenter(1:binary set_tv_live_center_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for PpsCategory.
   * Set all field of PpsCategory,
   * or throws an exception if this operation is not valid.
   */
  binary setPpsCategory(1:binary set_pps_category_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for AppGroup.
   * Set all field of AppGroup,
   * or throws an exception if this operation is not valid.
   */
  binary setAppGroup(1:binary set_app_group_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for People.
   * Set all field of People,
   * or throws an exception if this operation is not valid.
   */
  binary setMiniAutoCluster(1:binary set_mini_auto_cluster_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for LiveChannel.
   * Set all field of LiveChannel,
   * or throws an exception if this operation is not valid.
   */
  binary setLiveChannel(1:binary set_live_channel_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for LiveEpisode.
   * Set all field of LiveEpisode,
   * or throws an exception if this operation is not valid.
   */
  binary setLiveEpisode(1:binary set_live_episode_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Commodity.
   * Set all field of Commodity,
   * or throws an exception if this operation is not valid.
   */
  binary setCommodity(1:binary set_commodity_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Spu.
   * Set all field of Spu,
   * or throws an exception if this operation is not valid.
   */
  binary setSpu(1:binary set_spu_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for ItemBrand.
   * Set all field of ItemBrand,
   * or throws an exception if this operation is not valid.
   */
  binary setItemBrand(1:binary set_item_brand_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Theater.
   * Set all field of Theater,
   * or throws an exception if this operation is not valid.
   */
  binary setTheater(1:binary set_theater_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for QiquTag.
   * Set all field of QiquTag,
   * or throws an exception if this operation is not valid.
   */
  binary setQiquTag(1:binary set_qiqu_tag_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Topic.
   * Set all field of Topic,
   * or throws an exception if this operation is not valid.
   */
  binary setTopic(1:binary set_topic_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Shop.
   * Set all field of Shop,
   * or throws an exception if this operation is not valid.
   */
  binary setShop(1:binary set_shop_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for Presenter.
   * Set all field of Presenter,
   * or throws an exception if this operation is not valid.
   */
  binary setPresenter(1:binary set_presenter_request)
      throws (1:InvalidWriteOperation e);

  /**
   * The write interfaces of setting for ShowRoom.
   * Set all field of ShowRoom,
   * or throws an exception if this operation is not valid.
   */
  binary setShowRoom(1:binary set_showRoom_request)
      throws (1:InvalidWriteOperation e);
}
