package my.spring.project.dao;

import org.springframework.data.repository.CrudRepository;

import my.spring.project.pojos.StockExchange;;

public interface StockExchangeRepository extends CrudRepository<StockExchange, Integer> {

}
