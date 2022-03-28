package res1.data.list.hotels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

import res1.data.list.hotels.additional_info.Room; 
import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.List; 
import res1.data.list.hotels.additional_info.PlanPrefer; 
import res1.data.list.hotels.additional_info.CityList; 
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalInfo implements Serializable {
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
    
    public static Builder newAdditionalInfoBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final AdditionalInfo data = new AdditionalInfo();
        
        public Builder cityList(List<CityList> cityList) {
            data.setCityList(cityList);
            return this;
        }
        
        public Builder planPrefer(PlanPrefer planPrefer) {
            data.setPlanPrefer(planPrefer);
            return this;
        }
        
        public Builder room(List<Room> room) {
            data.setRoom(room);
            return this;
        }
        
        public AdditionalInfo build() {
            return data;
        }
        
    }
    
}
