package microservicescourse.currencyexchangeserver.exchangevalue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValueEntity {

    @Id
    private Long id;

    @Column(name = "startCurrency")
    private String from;

    @Column(name = "endCurrency")
    private String to;
    private String conversionValue;
    private int port;

    public ExchangeValueEntity() {
    }

    public ExchangeValueEntity(Long id, String from, String to, String conversionValue) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionValue = conversionValue;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getConversionValue() {
        return conversionValue;
    }

    public void setConversionValue(String conversionValue) {
        this.conversionValue = conversionValue;
    }
}
