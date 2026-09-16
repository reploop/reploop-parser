package message.messages.mv;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UploadInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    public static Builder newUploadInfoBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .toString();
    }

    public static class Builder {
        private final UploadInfo data = new UploadInfo();

        public UploadInfo build() {
            return data;
        }

    }

}
