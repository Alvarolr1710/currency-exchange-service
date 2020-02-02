package microservicescourse.currencyexchangeserver.controller;

import microservicescourse.currencyexchangeserver.exchangevalue.ExchangeValue;
import microservicescourse.currencyexchangeserver.exchangevalue.ExchangeValueEntity;
import microservicescourse.currencyexchangeserver.exchangevalue.Exchanger;
import microservicescourse.currencyexchangeserver.repository.ExchangeValueEntityRepository;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static java.lang.Integer.parseInt;
import static java.util.Objects.requireNonNull;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueEntityRepository exchangeValueEntityRepository;

    @GetMapping("currency-exchange-API/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValueUsingAPI(@PathVariable String from, @PathVariable String to) throws IOException, JSONException {
        return getExchangeValue(from, to);
    }

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public ExchangeValueEntity retrieveExchangeValue(@PathVariable String from, @PathVariable String to) throws IOException, JSONException {
        return getExchangeValueEntity(from, to);

    }

    private ExchangeValueEntity getExchangeValueEntity(@PathVariable String from, @PathVariable String to) {
        ExchangeValueEntity exchangeValue = exchangeValueEntityRepository.findByFromAndTo(from,to);
        exchangeValue.setPort(parseInt(requireNonNull(environment.getProperty("local.server.port"))));
        return exchangeValue;
    }

    private ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) throws IOException, JSONException {
        ExchangeValue exchangeValue = new ExchangeValue(1710L, from, to, Exchanger.getExchangeMultiple(from, to));
        exchangeValue.setPort(parseInt(requireNonNull(environment.getProperty("local.server.port"))));
        return exchangeValue;
    }
}
