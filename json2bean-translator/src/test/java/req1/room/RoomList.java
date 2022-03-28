package req1.room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomList implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer age;
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("age", age)
                .toString();
    }
    
    public static Builder newRoomListBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final RoomList data = new RoomList();
        
        public Builder age(Integer age) {
            data.setAge(age);
            return this;
        }
        
        public RoomList build() {
            return data;
        }
        
    }
    
}
