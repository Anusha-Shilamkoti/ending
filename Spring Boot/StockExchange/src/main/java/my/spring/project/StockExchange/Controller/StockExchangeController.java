package my.spring.project.StockExchange.Controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import my.spring.project.dao.SectorsRepository;
import my.spring.project.StockExchange.dao.StockExchangeRepository;
import my.spring.project.StockExchange.pojos.StockExchange;
//import my.spring.project.pojos.Sectors;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("stockexchange")
public class StockExchangeController {
	@Autowired
	private StockExchangeRepository stockexchangerepository;
	@RequestMapping("/getAllstockexchange")
	public Iterable<StockExchange> getAllstockexchange()
	{
		return stockexchangerepository.findAll();
	}
	@PostMapping("/savestockexchange")
	public StockExchange saveStockExchange(@RequestBody StockExchange stockexchange) {
		System.out.println(stockexchange);
		stockexchangerepository.save(stockexchange);
		return stockexchange;
	}
	@PutMapping("/updatestockexchange/{id}")
	public StockExchange updatestockexchange(@RequestBody StockExchange stockexchangeObj, @PathVariable("id") Integer id)
	{
		stockexchangeObj.setId(id);
		System.out.println(stockexchangeObj);
		stockexchangerepository.save(stockexchangeObj);
		return stockexchangeObj;
	}
	@GetMapping("/find/{id}")
	public StockExchange find(@PathVariable("id")Integer id) {
		Optional<StockExchange> stockexchange=stockexchangerepository.findById(id);
		return stockexchange.get();
	}
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable("id")Integer id) {
		stockexchangerepository.deleteById(id);
		return true;
	}
}
