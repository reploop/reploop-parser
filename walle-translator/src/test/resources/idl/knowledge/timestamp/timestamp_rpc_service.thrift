namespace cpp knowledge.pub
namespace java knowledge.pub

exception TimestampServiceException {
  1: optional string message;
}

service TimestampRpcService {
  // All functions in this service
  //
  // @param binary string of corresponding proto defined in timestamp_service.proto
  // @return binary string of GetTimestampResponse defined in timestamp_service.proto
  // @throws TimestampServiceException
  /**
   * 获取时间戳接口,使用bytes传输数据
   */
  binary getTimestamp(1:binary get_timestamp_request)
      throws (1:TimestampServiceException e);
}

