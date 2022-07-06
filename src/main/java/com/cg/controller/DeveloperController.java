package com.cg.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Developer;
import com.cg.service.DeveloperService;



@RestController
public class DeveloperController {
	
	@Autowired
	private DeveloperService dservice;
	
	@PostMapping("/addDeveloper")
	public String addDeveloper(@Valid @RequestBody Developer dev) {
		return dservice.addDeveloper(dev);
		
	}
	
	@GetMapping("/getAllDevelopers")
	public List<Developer> getAllDeveloper(){
		return dservice.getAllDeveloper();
	}
	@GetMapping(value = "/getDeveloper/{id}")
	public Developer getDeveloper(@PathVariable("id") int dcode) {
	    return dservice.getById(dcode);
	}
	
    @PutMapping("/updateFeeds/{id}/{totalFeeds}")
    public List<Developer> editFeeds(@PathVariable("id") int dcode,@PathVariable("totalFeeds") int totalFeeds){
	    return dservice.editFeeds(dcode, totalFeeds);
      }
    
    @PutMapping("/updateStatus/{devId}/{skillLevel}")
    public String updateStatus(@PathVariable("devId") int dcode,@PathVariable("skillLevel") String skillLevel){
        return dservice.updateStatus(dcode, skillLevel);

    }
}


