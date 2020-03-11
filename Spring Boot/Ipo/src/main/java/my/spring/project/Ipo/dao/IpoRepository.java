package my.spring.project.Ipo.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import my.spring.project.Ipo.pojos.Ipo;

public interface IpoRepository extends CrudRepository<Ipo, Integer>{

	List<Ipo> findByCompanyName(String companyName);

}
