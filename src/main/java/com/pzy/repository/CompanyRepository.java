package com.pzy.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.Company;
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long>,JpaSpecificationExecutor<Company>{
    public List<Company> findByName(String key);
}

