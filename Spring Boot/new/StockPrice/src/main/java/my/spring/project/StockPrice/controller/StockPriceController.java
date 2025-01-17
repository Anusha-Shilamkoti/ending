package my.spring.project.StockPrice.controller;

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

import com.google.gson.Gson;

//import my.spring.project.dao.SectorsRepository;
import my.spring.project.StockPrice.dao.StockPriceRepository;
//import my.spring.project.pojos.Sectors;
import my.spring.project.StockPrice.pojos.StockPrice;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/stockprice")
public class StockPriceController {
	@Autowired
	private StockPriceRepository stockpricerepository;
	@RequestMapping("/getAllstockprice")
	public Iterable<StockPrice> getAllstockprice()
	{
		return stockpricerepository.findAll();
	}
	@PostMapping("/savestockprice")
	public StockPrice saveStockPrice(@RequestBody StockPrice stockprice) {
		System.out.println(stockprice);
		stockpricerepository.save(stockprice);
		return stockprice;
	}
	@PutMapping("/updatestockprice/{companyCode}")
	public StockPrice updateStockPrice(@RequestBody StockPrice stockprice, @PathVariable("companyCode") String companycode)
	{
		stockprice.setCompanyCode(companycode);
		System.out.println(stockprice);
		stockpricerepository.save(stockprice);
		return stockprice;
	}
	@GetMapping("/find/{companycode}")
	public StockPrice find(@PathVariable("companycode")String companycode) {
		Optional<StockPrice> stockprice=stockpricerepository.findById(companycode);
		return stockprice.get();
	}
	@DeleteMapping("/delete/{companycode}")
	public boolean delete(@PathVariable("companycode")String companycode) {
		stockpricerepository.deleteById(companycode);
		return true;
	}

	@GetMapping("/getGraphData")
	public String getGraphData() {
		String str= "[{\r\n" + 
				"\r\n" + 
				"  name: 'tcs',\r\n" + 
				"\r\n" + 
				"  data: [90000, 20000, 10000, 30000, 60000, 10000, 30000]\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				" name: 'cts',\r\n" + 
				"\r\n" + 
				" data: [70000, 30000, 30000, 20000, 70000, 90000, 50000]\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"]";
		
		Gson g = new Gson();

		return g.toJson(str);
	}
	
	

}
