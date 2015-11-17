package com.pzy.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface AreaRepository extends PagingAndSortingRepository<com.pzy.entity.Area, Long>,JpaSpecificationExecutor<com.pzy.entity.Area>{
}

