include "log/name_version.thrift"
include "log/entries.thrift"
include "log/pages.thrift"
namespace * har
struct Log {
    1: optional name_version.NameVersion browser;
    2: optional name_version.NameVersion creator;
    3: optional list<entries.Entries> entries;
    4: optional list<pages.Pages> pages;
    5: optional string version;
    
}