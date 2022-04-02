package message

import "message/messages"
type Messages struct {
    Id string `json:"id"`
    Labels map[string]string `json:"labels"`
    Mv messages.Mv `json:"mv"`
    RoomID string `json:"roomID"`
    Sender string `json:"sender"`
    SequenceNO int32 `json:"sequenceNO"`
    Timestamp string `json:"timestamp"`
    
}
