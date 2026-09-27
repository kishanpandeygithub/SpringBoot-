package in.kishanpandey.Day12_SpringBootApplicationConfigaration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("payment-property")
public class PaymentPropertyes {
    private String type;
    private int retryCount;
    private Boolean enabled;
    private int timeOut;

    public void setType(String type) {
        this.type = type;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public String getType() {
        return type;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public int getTimeOut() {
        return timeOut;
    }
}
