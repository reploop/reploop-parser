package res1.data.list.hotels;

import res1.data.list.hotels.additional_info.Room;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import res1.data.list.hotels.additional_info.PlanPrefer;
import res1.data.list.hotels.additional_info.CityList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("city_list")
    private List<res1.data.list.hotels.additional_info.CityList> cityList;
    @JsonProperty("plan_prefer")
    private res1.data.list.hotels.additional_info.PlanPrefer planPrefer;
    private List<res1.data.list.hotels.additional_info.Room> room;
    
    public List<res1.data.list.hotels.additional_info.CityList> getCityList() {
        return cityList;
    }
    
    public void setCityList(List<res1.data.list.hotels.additional_info.CityList> cityList) {
        this.cityList = cityList;
    }
    
    public res1.data.list.hotels.additional_info.PlanPrefer getPlanPrefer() {
        return planPrefer;
    }
    
    public void setPlanPrefer(res1.data.list.hotels.additional_info.PlanPrefer planPrefer) {
        this.planPrefer = planPrefer;
    }
    
    public List<res1.data.list.hotels.additional_info.Room> getRoom() {
        return room;
    }
    
    public void setRoom(List<res1.data.list.hotels.additional_info.Room> room) {
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
    
    public static Builder newAdditionalInfoBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final AdditionalInfo data = new AdditionalInfo();
        
        public Builder cityList(List<res1.data.list.hotels.additional_info.CityList> cityList) {
            data.setCityList(cityList);
            return this;
        }
        
        public Builder planPrefer(res1.data.list.hotels.additional_info.PlanPrefer planPrefer) {
            data.setPlanPrefer(planPrefer);
            return this;
        }
        
        public Builder room(List<res1.data.list.hotels.additional_info.Room> room) {
            data.setRoom(room);
            return this;
        }
        
        public AdditionalInfo build() {
            return data;
        }
        
    }
    
}
