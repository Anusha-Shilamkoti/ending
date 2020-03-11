package my.spring.project.CompanyRelated.dao;
import org.springframework.data.repository.CrudRepository;

import my.spring.project.CompanyRelated.pojos.CompanyRelated;

public interface CompanyRelatedRepository extends CrudRepository<CompanyRelated, String> {

}
