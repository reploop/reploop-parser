
namespace java com.qiyi.knowledge.service.test

/**
 * 仅供测试用的Service
 *
**/
service HelloService {
  /**
    * 用的hello service,输入为姓名，输出为 hello 姓名。
   **/
  binary hello(1:binary hello_request) ;
   /**
    * 用的hello service,输入为姓名，输出为 hello 姓名。
   **/
  binary foo(1:binary foo_request) ;
}
