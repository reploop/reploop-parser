// Author: Qi Qiao (qiaoqi@qiyi.com)
//
// This file defines the interface for category related service.

namespace java knowledge.pub

exception InvalidCategoryOperation {
  1: optional string message;
}

service CategoryRpcService {
  // The method for getting all categories of one channel.
  binary getChannelCategoryList(1:binary get_channel_category_list_request) throws (1:InvalidCategoryOperation e);

  // The method for getting all secondary categories.
  binary getSubCategory(1:binary get_subcategory_request) throws (1:InvalidCategoryOperation e);

  // The method for getting a category by its id.
  binary getCategoryById(1:binary get_category_request) throws (1:InvalidCategoryOperation e);
  
  // The method for delete a category by its id.
  binary deleteCategoryById(1:binary delete_category_request) throws (1:InvalidCategoryOperation e);

  // The method for inserting or updating a category.
  binary setCategory(1:binary set_category_request) throws (1:InvalidCategoryOperation e);
}
