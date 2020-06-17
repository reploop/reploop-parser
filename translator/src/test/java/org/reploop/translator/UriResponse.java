package org.reploop.translator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class UriResponse {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Data {
        @JsonIgnoreProperties(ignoreUnknown = true)
        public class Volume {
            private String clusterName;
            private String location;
            private String production;
            private Long startupTime;
            private Long storageWeight;
            private Long useType;
            private String volumeName;
            private Long volumeType;
            public String getClusterName(){
                return clusterName;
            }
            public void setClusterName(String clusterName){
                this.clusterName = clusterName;
            }
            public String getLocation(){
                return location;
            }
            public void setLocation(String location){
                this.location = location;
            }
            public String getProduction(){
                return production;
            }
            public void setProduction(String production){
                this.production = production;
            }
            public Long getStartupTime(){
                return startupTime;
            }
            public void setStartupTime(Long startupTime){
                this.startupTime = startupTime;
            }
            public Long getStorageWeight(){
                return storageWeight;
            }
            public void setStorageWeight(Long storageWeight){
                this.storageWeight = storageWeight;
            }
            public Long getUseType(){
                return useType;
            }
            public void setUseType(Long useType){
                this.useType = useType;
            }
            public String getVolumeName(){
                return volumeName;
            }
            public void setVolumeName(String volumeName){
                this.volumeName = volumeName;
            }
            public Long getVolumeType(){
                return volumeType;
            }
            public void setVolumeType(Long volumeType){
                this.volumeType = volumeType;
            }
            @Override
            public String toString(){
                return MoreObjects.toStringHelper(this)
                .add("clusterName", clusterName)
                .add("location", location)
                .add("production", production)
                .add("startupTime", startupTime)
                .add("storageWeight", storageWeight)
                .add("useType", useType)
                .add("volumeName", volumeName)
                .add("volumeType", volumeType)
                .toString();
            }

        }
        @JsonIgnoreProperties(ignoreUnknown = true)
        public class ColdStorageInfo {
            @JsonProperty("external_uri")
            private String externalUri;
            @JsonProperty("internal_uri")
            private String internalUri;
            private String storage;
            @JsonProperty("token_expire")
            private String tokenExpire;
            private String uri;
            @JsonProperty("X-Auth-Token")
            private String xAuthToken;
            public String getExternalUri(){
                return externalUri;
            }
            public void setExternalUri(String externalUri){
                this.externalUri = externalUri;
            }
            public String getInternalUri(){
                return internalUri;
            }
            public void setInternalUri(String internalUri){
                this.internalUri = internalUri;
            }
            public String getStorage(){
                return storage;
            }
            public void setStorage(String storage){
                this.storage = storage;
            }
            public String getTokenExpire(){
                return tokenExpire;
            }
            public void setTokenExpire(String tokenExpire){
                this.tokenExpire = tokenExpire;
            }
            public String getUri(){
                return uri;
            }
            public void setUri(String uri){
                this.uri = uri;
            }
            public String getXAuthToken(){
                return xAuthToken;
            }
            public void setXAuthToken(String xAuthToken){
                this.xAuthToken = xAuthToken;
            }
            @Override
            public String toString(){
                return MoreObjects.toStringHelper(this)
                .add("externalUri", externalUri)
                .add("internalUri", internalUri)
                .add("storage", storage)
                .add("tokenExpire", tokenExpire)
                .add("uri", uri)
                .add("xAuthToken", xAuthToken)
                .toString();
            }

        }
        @JsonProperty("cold_path")
        private String coldPath;
        @JsonProperty("cold_storage")
        private String coldStorage;
        @JsonProperty("cold_storage_info")
        private UriResponse.Data.ColdStorageInfo coldStorageInfo;
        @JsonProperty("cold_uri")
        private String coldUri;
        @JsonProperty("cold_volume")
        private UriResponse.Data.Volume coldVolume;
        private String path;
        private String storage;
        private String uri;
        private UriResponse.Data.Volume volume;
        public String getColdPath(){
            return coldPath;
        }
        public void setColdPath(String coldPath){
            this.coldPath = coldPath;
        }
        public String getColdStorage(){
            return coldStorage;
        }
        public void setColdStorage(String coldStorage){
            this.coldStorage = coldStorage;
        }
        public UriResponse.Data.ColdStorageInfo getColdStorageInfo(){
            return coldStorageInfo;
        }
        public void setColdStorageInfo(UriResponse.Data.ColdStorageInfo coldStorageInfo){
            this.coldStorageInfo = coldStorageInfo;
        }
        public String getColdUri(){
            return coldUri;
        }
        public void setColdUri(String coldUri){
            this.coldUri = coldUri;
        }
        public UriResponse.Data.Volume getColdVolume(){
            return coldVolume;
        }
        public void setColdVolume(UriResponse.Data.Volume coldVolume){
            this.coldVolume = coldVolume;
        }
        public String getPath(){
            return path;
        }
        public void setPath(String path){
            this.path = path;
        }
        public String getStorage(){
            return storage;
        }
        public void setStorage(String storage){
            this.storage = storage;
        }
        public String getUri(){
            return uri;
        }
        public void setUri(String uri){
            this.uri = uri;
        }
        public UriResponse.Data.Volume getVolume(){
            return volume;
        }
        public void setVolume(UriResponse.Data.Volume volume){
            this.volume = volume;
        }
        @Override
        public String toString(){
            return MoreObjects.toStringHelper(this)
            .add("coldPath", coldPath)
            .add("coldStorage", coldStorage)
            .add("coldStorageInfo", coldStorageInfo)
            .add("coldUri", coldUri)
            .add("coldVolume", coldVolume)
            .add("path", path)
            .add("storage", storage)
            .add("uri", uri)
            .add("volume", volume)
            .toString();
        }

    }
    private String code;
    private UriResponse.Data data;
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public UriResponse.Data getData(){
        return data;
    }
    public void setData(UriResponse.Data data){
        this.data = data;
    }
    @Override
    public String toString(){
        return MoreObjects.toStringHelper(this)
        .add("code", code)
        .add("data", data)
        .toString();
    }

}
