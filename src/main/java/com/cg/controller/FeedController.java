
package com.cg.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Feed;
import com.cg.exception.FeedNotFoundException;
import com.cg.service.IFeedService;
import com.cg.serviceimpl.FeedService;

@RestController
public class FeedController {

	@Autowired
	private IFeedService feedService;

	@PostMapping("/addFeed")
	public String saveFeed(@Valid @RequestBody Feed feed) {
		return feedService.addFeed(feed);

	}

	@PutMapping("/editComments/{id}/{totalComments}")
	public Feed editComments(@PathVariable("id") int feedId, @PathVariable("totalComments") int totalComments) {
		return feedService.editComment(feedId, totalComments);
	}

	@PutMapping("/likeFeed/{id}/{relevance}")
	public List<Feed> likeFeed(@PathVariable("id") int feedId, @PathVariable("relevance") int relevance)
			throws FeedNotFoundException {
		return feedService.likeFeed(feedId, relevance);
	}

	@PutMapping(value = "/getFeed/{id}")
	public Feed getFeed(@PathVariable("id") int fcode) {
		return feedService.getFeed(fcode);
	}

	@DeleteMapping("/deleteFeed/{id}")
	public List<Feed> deleteFeed(@PathVariable("id") int feedId) {
		return feedService.deleteFeed(feedId);
	}

	@GetMapping("/getByDevId/{id}")
	public List<Feed> getFeedsByDeveloper(@PathVariable("id") int feedId) {
		return feedService.getFeedsByDeveloper(feedId);
	}

	@GetMapping("/getByKeyword/{keyword}")
	public List<Feed> getFeedsByKeyword(@PathVariable("keyword") String keyword) {
		return feedService.getFeedsByKeyword(keyword);
	}

	@GetMapping("/getByTopic/{topic}")
	public List<Feed> getFeedsByTopic(@PathVariable("topic") String topic) {
		return feedService.getFeedsByTopic(topic);
	}

}
