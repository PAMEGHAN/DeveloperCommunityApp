
  package com.cg.repository;
  
  import java.util.List;
  
  import org.springframework.data.jpa.repository.JpaRepository; 
  import org.springframework.data.jpa.repository.Query;
  
  import com.cg.entity.Response;
  
  public interface ResponseRepository extends JpaRepository<Response,Integer>{
  
  //@Query("select r from Response r where r.id ") 
	  List<Response> findByDev(int devId);
  
  List<Response> findByFeeds(int feedId);

  
  
  }
 