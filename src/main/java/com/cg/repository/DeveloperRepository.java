package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer,Integer>{

	//Developer setUpdateStatus(String string, int devId);

	//Developer getDeveloper(int devId);
	
	
	/*Developer saveDeveloper(Developer dev);

	Developer updateDeveloper(Developer dev);
	
	Developer statusDeveloper(Developer dev);
	
	Developer fetchDeveloper(int devId);
	
	List<Developer> fetchAllDeveloper();
	
*/

}

