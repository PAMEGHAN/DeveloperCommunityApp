
package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.entity.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Integer> {

	@Query("select f from Feed f where f.query like %:keyword% ")
	List<Feed> findByKeyword(@Param("keyword") String key);

	List<Feed> findByTopic(String topic);

	// @
	// Query("select count(*) from Feed f, d where f.devId=d.devId andf.devId=:devcode" )
	List<Feed> findByDeveloper(int dcode);

}
