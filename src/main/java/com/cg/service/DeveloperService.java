package com.cg.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Developer;
import com.cg.exception.DeveloperNotFoundException;
import com.cg.repository.DeveloperRepository;

@Service
public class DeveloperService{
	
	List<Developer> dlist=new ArrayList();
	@Autowired
	public DeveloperRepository drepository;
	
	public String addDeveloper(Developer dev) {
		drepository.save(dev);
		return "Developer is Added";
	}
    public List<Developer> getAllDeveloper() {
		return drepository.findAll();
	}
   

	public List<Developer> editFeeds(int dcode,int totalFeeds){
		if(!drepository.existsById(dcode)) {
			throw new DeveloperNotFoundException();
		}
		Developer dev=drepository.findById(dcode).get();
		dev.setTotalFeeds(totalFeeds);
		return drepository.findAll();
	}
	
	
	public Developer getById(int devId) {
		return  drepository.findById(devId).get();
		
	}
	
	public String updateStatus(int dcode,String skillLevel){
		Developer dev=drepository.findById(dcode).get();
		
		if(dev.getSkillLevel().equals("poor") || dev.getSkillLevel().equals("Average")) {
			dev.setSkillLevel("poor");
			return "Developer is blocked";
		}
		else if(dev.getSkillLevel().equals("Excellent") || dev.getSkillLevel().equals("good") || dev.getSkillLevel().equals("Verygood")) {
			dev.setSkillLevel("Excellent");
			return "Developer is Verified";
		}
		return "Either verified or blocked";
				
}
	
}
	