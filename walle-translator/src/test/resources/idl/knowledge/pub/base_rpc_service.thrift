
namespace java knowledge.pub

/**
 * 这个类定义通用的Protobuf作为Protocol的服务
 *
 */
service BaseRpcService {
  /**
    * 通用的execute服务。
   **/
  binary execute(1:binary request) ;
  
  }