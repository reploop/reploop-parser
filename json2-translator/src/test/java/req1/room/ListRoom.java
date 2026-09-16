package req1.room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListRoom implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer age;

    public static Builder newListRoomBuilder() {
        return new Builder();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("age", getAge())
                .toString();
    }

    public static class Builder {
        private final ListRoom data = new ListRoom();

        public Builder age(Integer age) {
            data.setAge(age);
            return this;
        }

        public ListRoom build() {
            return data;
        }

    }

}
