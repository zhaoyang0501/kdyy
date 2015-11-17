
package com.pzy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzy.entity.Area;
import com.pzy.repository.AreaRepository;

/***
 * 
 * @author qq:263608237
 *
 */
@Service
public class AreaService {
     @Autowired
     private AreaRepository areaRepository;
     public List<Area> findAll() {
         return (List<Area>) areaRepository.findAll();
     }
    
	 public Area find(Long id){
		 return areaRepository.findOne(id);
	 }
		
}