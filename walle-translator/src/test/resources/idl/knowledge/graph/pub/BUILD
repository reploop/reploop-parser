
proto_library(
    name = 'properties_proto',
    srcs = [ 'properties.proto' ],
    deps = [
      '//knowledge/pub:common_proto',
      '//knowledge/pub:metadatas_proto',
      '//knowledge/pub:properties_proto',
      '//knowledge/pub/library:film_library_idl_proto',
      '//search/common/proto:llibrary_proto',
    ],
)

proto_library(
    name = 'graph_service_proto',
    srcs = [ 'graph_service.proto' ],
    deps = [
      ':properties_proto',
      '//knowledge/pub:common_proto',
    ],
)

thrift_library(
    name = 'graph_rpc_service_thrift',
    srcs = [ 'graph_rpc_service.thrift' ],
)
