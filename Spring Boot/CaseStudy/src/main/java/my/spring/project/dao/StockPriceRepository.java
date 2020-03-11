package my.spring.project.dao;

import org.springframework.data.repository.CrudRepository;

import my.spring.project.pojos.StockPrice;;

public interface StockPriceRepository extends CrudRepository<StockPrice, String> {

}
