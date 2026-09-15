import com.fasterxml.jackson.annotation.JsonProperty;
import shuFtipro.Address;
import java.io.Serializable;
import shuFtipro.Document;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShuFTipRo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Address address;
    @JsonProperty("callback_url")
    private String callbackUrl;
    private String country;
    private Document document;
    private String email;
    private String language;
    @JsonProperty("redirect_url")
    private String redirectUrl;
    private String reference;
    private Integer ttl;
    @JsonProperty("verification_mode")
    private String verificationMode;
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public String getCallbackUrl() {
        return callbackUrl;
    }
    
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public Document getDocument() {
        return document;
    }
    
    public void setDocument(Document document) {
        this.document = document;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public void setLanguage(String language) {
        this.language = language;
    }
    
    public String getRedirectUrl() {
        return redirectUrl;
    }
    
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
    
    public String getReference() {
        return reference;
    }
    
    public void setReference(String reference) {
        this.reference = reference;
    }
    
    public Integer getTtl() {
        return ttl;
    }
    
    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }
    
    public String getVerificationMode() {
        return verificationMode;
    }
    
    public void setVerificationMode(String verificationMode) {
        this.verificationMode = verificationMode;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("address", getAddress())
                .add("callbackUrl", getCallbackUrl())
                .add("country", getCountry())
                .add("document", getDocument())
                .add("email", getEmail())
                .add("language", getLanguage())
                .add("redirectUrl", getRedirectUrl())
                .add("reference", getReference())
                .add("ttl", getTtl())
                .add("verificationMode", getVerificationMode())
                .toString();
    }
    
    public static Builder newShuFTipRoBuilder() {
        return new Builder();
    }
    
    public static class Builder {
        private final ShuFTipRo data = new ShuFTipRo();
        
        public Builder address(Address address) {
            data.setAddress(address);
            return this;
        }
        
        public Builder callbackUrl(String callbackUrl) {
            data.setCallbackUrl(callbackUrl);
            return this;
        }
        
        public Builder country(String country) {
            data.setCountry(country);
            return this;
        }
        
        public Builder document(Document document) {
            data.setDocument(document);
            return this;
        }
        
        public Builder email(String email) {
            data.setEmail(email);
            return this;
        }
        
        public Builder language(String language) {
            data.setLanguage(language);
            return this;
        }
        
        public Builder redirectUrl(String redirectUrl) {
            data.setRedirectUrl(redirectUrl);
            return this;
        }
        
        public Builder reference(String reference) {
            data.setReference(reference);
            return this;
        }
        
        public Builder ttl(Integer ttl) {
            data.setTtl(ttl);
            return this;
        }
        
        public Builder verificationMode(String verificationMode) {
            data.setVerificationMode(verificationMode);
            return this;
        }
        
        public ShuFTipRo build() {
            return data;
        }
        
    }
    
}
