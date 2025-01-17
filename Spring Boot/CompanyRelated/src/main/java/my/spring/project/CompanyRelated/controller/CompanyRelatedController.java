package my.spring.project.CompanyRelated.controller;
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

import my.spring.project.CompanyRelated.JSONCompanyRelatedClient;
import my.spring.project.CompanyRelated.dao.CompanyRelatedRepository;
import my.spring.project.CompanyRelated.pojos.CompanyRelated;
//import my.spring.project.pojos.CompanyRelated;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("companyrelated")
public class CompanyRelatedController {
	@Autowired
	JSONCompanyRelatedClient jcompany;
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
	@PutMapping("/updatecompany/{companyName}")
	public CompanyRelated updateCompany(@RequestBody CompanyRelated companyrelated, @PathVariable("companyName") String companyName)
	{
		companyrelated.setCompanyName(companyName);
		System.out.println(companyrelated);
		companyrelatedrepository.save(companyrelated);
		return companyrelated;
	}
	@GetMapping("/find/{companyName}")
	public CompanyRelated find(@PathVariable("companyName")String companyName) {
		Optional<CompanyRelated> companyrelated=companyrelatedrepository.findById(companyName);
		CompanyRelated comp=companyrelated.get();
		comp.setIpoList(jcompany.findByCompanyName(companyName));
		return companyrelated.get();
		
	}
	
	
	
	@DeleteMapping("/delete/{companyName}")
	public boolean delete(@PathVariable("companyName")String companyName) {
		companyrelatedrepository.deleteById(companyName);
		return true;
	}
	
	
	

}
