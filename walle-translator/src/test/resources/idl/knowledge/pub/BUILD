
proto_library(
    name = 'activemq_message_proto',
    srcs = [ 'activemq_message.proto' ],
    deps = [
        ':common_proto',
    ],
)

proto_library(
    name = 'aggregation_proto',
    srcs = [ 'aggregation.proto' ],
    deps = [
        ':common_proto',
    ],
)

proto_library(
    name = 'common_proto',
    srcs = [ 'common.proto' ],
)

proto_library(
    name = 'formats_proto',
    srcs = [ 'formats.proto' ],
)

proto_library(
    name = 'id_service_proto',
    srcs = [ 'id_service.proto' ],
    deps = [
        ':common_proto',
    ],
)

proto_library(
    name = 'qipu_options_proto',
    srcs = [ 'qipu_options.proto' ],
)

proto_library(
    name = 'validator_proto',
    srcs = [ 'validator.proto' ],
    deps = [
        ':common_proto',
    ],
)

thrift_library(
    name = 'id_rpc_service_thrift',
    srcs = [ 'id_rpc_service.thrift' ],
)

proto_library(
    name = 'knowledge_proto',
    srcs = [ 'knowledge.proto' ],
    deps = [
        ':common_proto',
        ':formats_proto',
        ':metadatas_proto',
        ':properties_proto',
        ':validator_proto',
        '//knowledge/graph/pub:properties_proto',
        '//knowledge/pub/library:film_library_idl_proto',
    ],
)

proto_library(
    name = 'metadatas_proto',
    srcs = [ 'metadatas.proto' ],
    deps = [
        ':common_proto',
    ],
)

proto_library(
    name = 'properties_proto',
    srcs = [ 'properties.proto' ],
    deps = [
        ':common_proto',
        ':formats_proto',
        ':metadatas_proto',
    ],
)

proto_library(
    name = 'read_service_proto',
    srcs = [ 'read_service.proto' ],
    deps = [
        ':aggregation_proto',
        ':common_proto',
        ':formats_proto',
        ':knowledge_proto',
        ':metadatas_proto',
        ':properties_proto',
        ':qipu_options_proto',
        '//knowledge/pub/library:film_library_idl_proto',
    ],
)

thrift_library(
    name = 'read_rpc_service_thrift',
    srcs = [ 'read_rpc_service.thrift' ],
)

proto_library(
    name = 'write_service_proto',
    srcs = [ 'write_service.proto' ],
    deps = [
        ':common_proto',
        ':formats_proto',
        ':knowledge_proto',
        ':metadatas_proto',
        ':properties_proto',
        '//knowledge/graph/pub:properties_proto',
        '//knowledge/pub/library:film_library_idl_proto',
    ],
)

thrift_library(
    name = 'write_rpc_service_thrift',
    srcs = [ 'write_rpc_service.thrift' ],
)
