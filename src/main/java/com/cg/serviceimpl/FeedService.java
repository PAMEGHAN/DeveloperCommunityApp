package com.cg.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Feed;
import com.cg.exception.FeedNotFoundException;
import com.cg.repository.FeedRepository;
import com.cg.service.IFeedService;
@Service
public class FeedService implements IFeedService {
	
	@Autowired
	public FeedRepository frepository;
	
	@Autowired
	public DeveloperService ds;

	public String addFeed(Feed feed)
	{
		frepository.saveAndFlush(feed);
		return "Feedback is added";	
	}
	
	public Feed editComment(int feedId, int totalcomments)
	{
		Feed feed= frepository.findById(feedId).get();
		feed.setTotalComments(totalcomments);
		return frepository.saveAndFlush(feed);
	}
	
	public List<Feed> likeFeed(int feedId, int relevance){
		if(!frepository.existsById(feedId)) {
			throw new FeedNotFoundException();
		}
		Feed feed = frepository.findById(feedId).get();
		feed.setRelevance(relevance);
		//frepository.flush();
		return frepository.findAll();
	}



   public List<Feed> getFeedsByDeveloper(int dcode){
    	
		return frepository.findByDeveloper(dcode);

	 }

	public List<Feed> getFeedsByKeyword(String keyword)
	 {

		 return frepository.findByKeyword(keyword);
		 
	 }

	public List<Feed> getFeedsByTopic(String topic)
	{
		return  frepository.findByTopic(topic);
	}

	public Feed getFeed(int fcode){
		if(!frepository.existsById(fcode)) {
			throw new FeedNotFoundException();
		}
		return frepository.findById(fcode).get();
	}

	public List<Feed> deleteFeed(int feedId) {
		
		 frepository.deleteById(feedId);
		return frepository.findAll(); 
	}

	
	 
}
