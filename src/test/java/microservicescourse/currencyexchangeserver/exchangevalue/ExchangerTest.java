package microservicescourse.currencyexchangeserver.exchangevalue;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ExchangerTest {

    @Test
    public void shouldGetExchangeMultipleFromAPI() throws IOException, JSONException {
        String exchangeMultiple = Exchanger.getExchangeMultiple("USD","EUR");
        Assert.assertThat(exchangeMultiple, Is.is(IsNull.notNullValue()));
    }
}