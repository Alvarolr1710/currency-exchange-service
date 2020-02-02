package microservicescourse.currencyexchangeserver.controller;

import microservicescourse.currencyexchangeserver.IntegrationTestBase;
import org.apache.http.HttpStatus;
import org.hamcrest.core.Is;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertThat;

public class CurrencyExchangeControllerIT extends IntegrationTestBase {

    @Test
    public void shouldRetrieveExchangeRateFromAPI() {
        response = given().log().all()
                .when().get("currency-exchange-API/from/GBP/to/USD").thenReturn();
        response.then().log().all();

        assertThat(response.getStatusCode(), Is.is(HttpStatus.SC_OK));
        assertThat(response.getBody().asString().contains("GBP"), Is.is(true));
        assertThat(response.getBody().asString().contains("USD"), Is.is(true));
    }

}