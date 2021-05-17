import Store.StoreList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<StoreList> list;
    private String msg;
    private Boolean success;

    public List<StoreList> getList() {
        return list;
    }

    public void setList(List<StoreList> list) {
        this.list = list;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("list", list)
            .add("msg", msg)
            .add("success", success)
            .toString();
    }

}
