package com.qiyi.walle.translator.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
class Uri {
    @JsonIgnoreProperties(ignoreUnknown = true)
    class Data {
        @JsonIgnoreProperties(ignoreUnknown = true)
        class Volume {
            private String clusterName;
            private String location;
            private String production;
            private Long startupTime;
            private Long storageWeight;
            private Long useType;
            private String volumeName;
            private Long volumeType;

            public String getClusterName() {
                return clusterName;
            }

            public void setClusterName(String clusterName) {
                this.clusterName = clusterName;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getProduction() {
                return production;
            }

            public void setProduction(String production) {
                this.production = production;
            }

            public Long getStartupTime() {
                return startupTime;
            }

            public void setStartupTime(Long startupTime) {
                this.startupTime = startupTime;
            }

            public Long getStorageWeight() {
                return storageWeight;
            }

            public void setStorageWeight(Long storageWeight) {
                this.storageWeight = storageWeight;
            }

            public Long getUseType() {
                return useType;
            }

            public void setUseType(Long useType) {
                this.useType = useType;
            }

            public String getVolumeName() {
                return volumeName;
            }

            public void setVolumeName(String volumeName) {
                this.volumeName = volumeName;
            }

            public Long getVolumeType() {
                return volumeType;
            }

            public void setVolumeType(Long volumeType) {
                this.volumeType = volumeType;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        class ColdStorageInfo {
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

            public String getExternalUri() {
                return externalUri;
            }

            public void setExternalUri(String externalUri) {
                this.externalUri = externalUri;
            }

            public String getInternalUri() {
                return internalUri;
            }

            public void setInternalUri(String internalUri) {
                this.internalUri = internalUri;
            }

            public String getStorage() {
                return storage;
            }

            public void setStorage(String storage) {
                this.storage = storage;
            }

            public String getTokenExpire() {
                return tokenExpire;
            }

            public void setTokenExpire(String tokenExpire) {
                this.tokenExpire = tokenExpire;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getxAuthToken() {
                return xAuthToken;
            }

            public void setxAuthToken(String xAuthToken) {
                this.xAuthToken = xAuthToken;
            }
        }

        @JsonProperty("cold_path")
        private String coldPath;
        @JsonProperty("cold_storage")
        private String coldStorage;
        @JsonProperty("cold_storage_info")
        private ColdStorageInfo coldStorageInfo;
        @JsonProperty("cold_uri")
        private String coldUri;
        @JsonProperty("cold_volume")
        private Volume coldVolume;
        private String path;
        private String storage;
        private String uri;
        private Volume volume;

        public String getColdPath() {
            return coldPath;
        }

        public void setColdPath(String coldPath) {
            this.coldPath = coldPath;
        }

        public String getColdStorage() {
            return coldStorage;
        }

        public void setColdStorage(String coldStorage) {
            this.coldStorage = coldStorage;
        }

        public ColdStorageInfo getColdStorageInfo() {
            return coldStorageInfo;
        }

        public void setColdStorageInfo(ColdStorageInfo coldStorageInfo) {
            this.coldStorageInfo = coldStorageInfo;
        }

        public String getColdUri() {
            return coldUri;
        }

        public void setColdUri(String coldUri) {
            this.coldUri = coldUri;
        }

        public Volume getColdVolume() {
            return coldVolume;
        }

        public void setColdVolume(Volume coldVolume) {
            this.coldVolume = coldVolume;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getStorage() {
            return storage;
        }

        public void setStorage(String storage) {
            this.storage = storage;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public Volume getVolume() {
            return volume;
        }

        public void setVolume(Volume volume) {
            this.volume = volume;
        }
    }

    private String code;
    private Data data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", code)
                .add("data", data)
                .toString();
    }
}
