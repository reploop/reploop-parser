
namespace cpp knowledge.pub.tracker
namespace java knowledge.pub.tracker

// If an error occurs, this exception is threw.
exception InvalidTrackerReadOperation {
    1: optional string message;
}

// The interface for the read service.
service TrackerReadRpcService {

   binary getChangeLog(1:binary GetChangeLogRequest) throws (1:InvalidTrackerReadOperation e);

   binary getChangeLogById(1:binary GetChangeLogByIdRequest) throws (1:InvalidTrackerReadOperation e);

   binary getBatchChangeLog(1:binary GetChangeLogRequest) throws (1:InvalidTrackerReadOperation e);


}