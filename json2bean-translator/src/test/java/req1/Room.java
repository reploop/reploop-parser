package req1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import req1.room.RoomList; 
import java.util.List; 
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
    
}
