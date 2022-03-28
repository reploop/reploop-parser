package res1.data.list.hotels.additional_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import java.util.List; 
import res1.data.list.hotels.additional_info.room.RoomList; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<RoomList> list;
    
    public List<RoomList> getList() {
        return list;
    }
    
    public void setList(List<RoomList> list) {
        this.list = list;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("list", list)
                .toString();
    }
    
    public static Builder newRoomBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Room data = new Room();
        
        public Builder list(List<RoomList> list) {
            data.setList(list);
            return this;
        }
        
        public Room build() {
            return data;
        }
        
    }
    
}
