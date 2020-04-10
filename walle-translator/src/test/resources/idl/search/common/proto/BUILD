
proto_library(
    name = 'docinfo_proto',
    srcs = [ 'docinfo.proto' ]
)

proto_library(
    name = 'properties_proto',
    srcs = [ 'properties.proto' ]
)

proto_library(
    name = 'llibrary_proto',
    srcs = [ 'library.proto' ],
    deps = [
        ':docinfo_proto',
        ':properties_proto',
    ],
)
