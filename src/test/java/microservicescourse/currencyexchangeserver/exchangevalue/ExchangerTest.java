package microservicescourse.currencyexchangeserver.exchangevalue;

import microservicescourse.currencyexchangeserver.config.CurrencyExchangeServerConfig;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class ExchangerTest {

    @Autowired
    private CurrencyExchangeServerConfig currencyExchangeServerConfig;

    @Test
    public void shouldGetExchangeMultipleFromAPI() throws IOException, JSONException {
        String exchangeMultiple =
                Exchanger.getExchangeMultiple(currencyExchangeServerConfig.getAPI_URL(), "USD", "EUR");
        Assert.assertThat(exchangeMultiple, Is.is(IsNull.notNullValue()));
    }
}