import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Mt implements Serializable {
    private static final long serialVersionUID = 1L;
    private String a;
    private Integer b;
    private String c;
    private Integer d;
    private String e;
    
    public String getA() {
        return a;
    }
    
    public void setA(String a) {
        this.a = a;
    }
    
    public Integer getB() {
        return b;
    }
    
    public void setB(Integer b) {
        this.b = b;
    }
    
    public String getC() {
        return c;
    }
    
    public void setC(String c) {
        this.c = c;
    }
    
    public Integer getD() {
        return d;
    }
    
    public void setD(Integer d) {
        this.d = d;
    }
    
    public String getE() {
        return e;
    }
    
    public void setE(String e) {
        this.e = e;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("a", a)
                .add("b", b)
                .add("c", c)
                .add("d", d)
                .add("e", e)
                .toString();
    }
    
}
