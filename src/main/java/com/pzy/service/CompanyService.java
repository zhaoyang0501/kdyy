
package com.pzy.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pzy.entity.Company;
import com.pzy.repository.CompanyRepository;
/***
 * 
 * @author qq:263608237
 *
 */
@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public  List<Company> findByName(final String name){
    	 Specification<Company> spec = new Specification<Company>() {
             public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
             Predicate predicate = cb.conjunction();
             if (name != null) {
                  predicate.getExpressions().add(cb.like(root.get("name").as(String.class), "%"+name+"%"));
             }
             return predicate;
             }
        };
        return companyRepository.findAll(spec);
    }
    
 	public List<Company> findTop3() {
 		return companyRepository.findAll(
 				new PageRequest(0, 15, new Sort(Direction.DESC, "createDate")))
 				.getContent();
 	}
     public List<Company> findAll() {
         return (List<Company>) companyRepository.findAll();
     }
     public Page<Company> findAll(final int pageNumber, final int pageSize,final String name){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
         Specification<Company> spec = new Specification<Company>() {
              public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (name != null) {
                   predicate.getExpressions().add(cb.like(root.get("name").as(String.class), "%"+name+"%"));
              }
              return predicate;
              }
         };
         Page<Company> result = (Page<Company>) companyRepository.findAll(spec, pageRequest);
         return result;
     	}
     
     public Page<Company> findAll(final int pageNumber, final int pageSize,final Integer type ){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
         Specification<Company> spec = new Specification<Company>() {
              public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (type != null) {
                  predicate.getExpressions().add(cb.equal(root.get("type").as(Integer.class),type));
               }
              return predicate;
              }
         };
         Page<Company> result = (Page<Company>) companyRepository.findAll(spec, pageRequest);
         return result;
     	}
		public void delete(Long id){
			companyRepository.delete(id);
		}
		public Company find(Long id){
			  return companyRepository.findOne(id);
		}
		public void save(Company company){
			companyRepository.save(company);
		}
}