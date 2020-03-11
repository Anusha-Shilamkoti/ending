package my.spring.project.Sectors.controller;
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

//import my.spring.project.dao.IpoRepository;
import my.spring.project.Sectors.dao.SectorsRepository;
//import my.spring.project.pojos.Ipo;
import my.spring.project.Sectors.pojos.Sectors;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("sectors")
public class SectorsController {
	@Autowired
	private SectorsRepository sectorsrepository;
	@RequestMapping("/getAllsectors")
	public Iterable<Sectors> getAllsectors()
	{
		return sectorsrepository.findAll();
	}
	@PostMapping("/savesectors")
	public Sectors saveSectors(@RequestBody Sectors sectors) {
		System.out.println(sectors);
		sectorsrepository.save(sectors);
		return sectors;
	}
	@PutMapping("/updatesectors/{id}")
	public Sectors updatesectors(@RequestBody Sectors sectors, @PathVariable("id") Integer id)
	{
		sectors.setId(id);
		System.out.println(sectors);
		sectorsrepository.save(sectors);
		return sectors;
	}
	@GetMapping("/find/{id}")
	public Sectors find(@PathVariable("id")Integer id) {
		Optional<Sectors> sectors=sectorsrepository.findById(id);
		return sectors.get();
	}
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable("id")Integer id) {
		sectorsrepository.deleteById(id);
		return true;
	}


}
