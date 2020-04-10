/**
 * simple_source.thrift
 * Simple Source Definition.
 */
namespace java com.qiyi.vrs.vis.ugc.model

include "ugc_common.thrift"
include "mixin_video.thrift"
include "ugc_person.thrift"

enum SourceType{
    // 明星
    STAR = 1;
}
/**
 * 来源信息
 */
struct TSimpleSource {
    //事件区域
    5: optional string area = "其他",

}