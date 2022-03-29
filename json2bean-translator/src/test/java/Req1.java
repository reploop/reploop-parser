import req1.CityList;
import com.fasterxml.jackson.annotation.JsonProperty;
import req1.Room;
import java.io.Serializable;
import java.util.List;
import req1.PlanPrefer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Req1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("city_list")
    private List<req1.CityList> cityList;
    @JsonProperty("plan_prefer")
    private req1.PlanPrefer planPrefer;
    private List<req1.Room> room;
    
    public List<req1.CityList> getCityList() {
        return cityList;
    }
    
    public void setCityList(List<req1.CityList> cityList) {
        this.cityList = cityList;
    }
    
    public req1.PlanPrefer getPlanPrefer() {
        return planPrefer;
    }
    
    public void setPlanPrefer(req1.PlanPrefer planPrefer) {
        this.planPrefer = planPrefer;
    }
    
    public List<req1.Room> getRoom() {
        return room;
    }
    
    public void setRoom(List<req1.Room> room) {
        this.room = room;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("cityList", getCityList())
                .add("planPrefer", getPlanPrefer())
                .add("room", getRoom())
                .toString();
    }
    
    public static Builder newReq1Builder() {
        return new Builder();
    }
    
    public static class Builder {
        private final Req1 data = new Req1();
        
        public Builder cityList(List<req1.CityList> cityList) {
            data.setCityList(cityList);
            return this;
        }
        
        public Builder planPrefer(req1.PlanPrefer planPrefer) {
            data.setPlanPrefer(planPrefer);
            return this;
        }
        
        public Builder room(List<req1.Room> room) {
            data.setRoom(room);
            return this;
        }
        
        public Req1 build() {
            return data;
        }
        
    }
    
}
