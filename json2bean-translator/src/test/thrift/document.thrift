include "document/boiling_point.thrift"
include "document/density.thrift"
struct Document {
    1: optional boiling_point.BoilingPoint boiling_point;
    2: optional bool dangerous;
    3: optional density.Density density;
    4: optional string name;
    5: optional string type;
    
}