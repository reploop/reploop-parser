// Author: Liang Liuwei (liangliuwei@qiyi.com)
//
// This file defines the interface of category service of qipu.
//

include "../../pub/common.thrift"

namespace cpp knowledge.fusion.category
namespace java knowledge.fusion.category


service CategoryRpcService {
  /**
   * 根据频道获取所有分类树
   */
  binary getCategoryTreeByChannelId(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);
  /**
   * 获取分类树
   */
  binary getCategoryTree(1:binary request) throws
    (1:common.UserException ue, 2: common.RpcException re);
  // 下面是兼容老的category service  
  // The method for getting all categories of one channel.
  binary getChannelCategoryList(1:binary get_channel_category_list_request) throws (1:common.UserException ue, 2: common.RpcException re);

  // The method for getting all secondary categories.
  binary getSubCategory(1:binary get_subcategory_request) throws (1:common.UserException ue, 2: common.RpcException re);

  // The method for getting a category by its id.
  binary getCategoryById(1:binary get_category_request) throws (1:common.UserException ue, 2: common.RpcException re);

  // The method for getting all categories.
  binary getAllCategory(1:binary get_all_category_request) throws (1:common.UserException ue, 2: common.RpcException re);

}