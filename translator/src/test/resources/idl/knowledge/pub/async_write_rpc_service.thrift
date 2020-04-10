namespace cpp knowledge.pub
namespace java knowledge.pub

exception AsyncWriteException {
  1: optional string message;
}

service AsyncWriteRpcService {
  // All functions in this service
  //
  // @param binary string of corresponding proto defined in async_write_service.proto
  // @return binary string of WriteResponse defined in async_write_service.proto
  // @throws InvalidAsyncWriteOperation
  /**
   * 异步write统一接口,使用bytes传输数据
   */
  binary writeEntity(1:binary async_write_entity_request)
      throws (1:AsyncWriteException e);
}

