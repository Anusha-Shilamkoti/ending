package my.spring.project.dao;

import org.springframework.data.repository.CrudRepository;

import my.spring.project.pojos.CompanyRelated;

public interface CompanyRelatedRepository extends CrudRepository<CompanyRelated, Integer> {

}
