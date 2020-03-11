package my.spring.project.StockPrice.dao;
import org.springframework.data.repository.CrudRepository;

import my.spring.project.StockPrice.pojos.StockPrice;

public interface StockPriceRepository extends CrudRepository<StockPrice, String> {

}
