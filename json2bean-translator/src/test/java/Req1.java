import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import req1.CityList; 
import req1.PlanPrefer; 
import req1.Room; 
import java.util.List; 
import com.fasterxml.jackson.annotation.JsonProperty; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Req1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("city_list")
    private List<CityList> cityList;
    @JsonProperty("plan_prefer")
    private PlanPrefer planPrefer;
    private List<Room> room;
    
    public List<CityList> getCityList() {
        return cityList;
    }
    
    public void setCityList(List<CityList> cityList) {
        this.cityList = cityList;
    }
    
    public PlanPrefer getPlanPrefer() {
        return planPrefer;
    }
    
    public void setPlanPrefer(PlanPrefer planPrefer) {
        this.planPrefer = planPrefer;
    }
    
    public List<Room> getRoom() {
        return room;
    }
    
    public void setRoom(List<Room> room) {
        this.room = room;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("cityList", cityList)
                .add("planPrefer", planPrefer)
                .add("room", room)
                .toString();
    }
    
}
