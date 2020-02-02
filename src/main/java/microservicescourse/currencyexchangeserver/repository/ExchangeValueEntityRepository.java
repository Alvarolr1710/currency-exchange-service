package microservicescourse.currencyexchangeserver.repository;

import microservicescourse.currencyexchangeserver.exchangevalue.ExchangeValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueEntityRepository extends JpaRepository<ExchangeValueEntity, Long> {

    ExchangeValueEntity findByFromAndTo(String from, String to);
}
