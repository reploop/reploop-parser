// Author: Wang Tianxing<wangtianxing@qiyi.com>
//
// This file defines the rpc methods for knowledge mixer service

include "../common.thrift"

namespace java knowledge.pub.mixer

service MixerRpcService {
  binary getFilmTvLibPlaySource(1:binary get_film_tv_lib_play_source_request) throws
    (1:common.UserException ue, 2: common.RpcException re);
}
