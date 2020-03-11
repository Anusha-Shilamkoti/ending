package my.spring.project.StockExchange.dao;
import org.springframework.data.repository.CrudRepository;

import my.spring.project.StockExchange.pojos.StockExchange;;

public interface StockExchangeRepository extends CrudRepository<StockExchange, Integer> {

}