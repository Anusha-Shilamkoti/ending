package my.spring.project.controller;

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

import my.spring.project.dao.CompanyRelatedRepository;
import my.spring.project.pojos.CompanyRelated;
//import my.spring.project.pojos.CompanyRelated;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("companyrelated")
public class CompanyRelatedController {
	@Autowired
	private CompanyRelatedRepository companyrelatedrepository;
	@RequestMapping("/getAllcompanies")
	public Iterable<CompanyRelated> getAllcompanies()
	{
		return companyrelatedrepository.findAll();
	}
	@PostMapping("/savecompany")
	public CompanyRelated saveCompany(@RequestBody CompanyRelated companyrelated) {
		System.out.println(companyrelated);
		companyrelatedrepository.save(companyrelated);
		return companyrelated;
	}
	@PutMapping("/updatecompany/{id}")
	public CompanyRelated updateCompany(@RequestBody CompanyRelated companyrelated, @PathVariable("id") Integer id)
	{
		companyrelated.setId(id);
		System.out.println(companyrelated);
		companyrelatedrepository.save(companyrelated);
		return companyrelated;
	}
	@GetMapping("/find/{id}")
	public CompanyRelated find(@PathVariable("id")Integer id) {
		Optional<CompanyRelated> companyrelated=companyrelatedrepository.findById(id);
		return companyrelated.get();
	}
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable("id")Integer id) {
		companyrelatedrepository.deleteById(id);
		return true;
	}
	
	
	

}
