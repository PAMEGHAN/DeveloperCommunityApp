
package com.cg.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Response;
import com.cg.exception.ResponseNotFoundException;
import com.cg.repository.ResponseRepository;
import com.cg.service.IResponseService;

@Service
public class ResponseService implements IResponseService {

	@Autowired
	public ResponseRepository rrepository;

	@Autowired
	public FeedService fs;

	public String addResponse(Response response) {
		rrepository.saveAndFlush(response);
		return "Response is added";
	}

	public Response editAnswer(int respId, String answer) {
		Response response = rrepository.findById(respId).get();
		response.setAnswer(answer);
		return rrepository.saveAndFlush(response);
	}

	public List<Response> likeResponse(int respId, int accuracy) {
		if (!rrepository.existsById(respId)) {
			throw new ResponseNotFoundException();
		}

		Response response = rrepository.findById(respId).get();
		response.setAccuracy(accuracy);
		return rrepository.findAll();
	}

	public List<Response> deleteResponse(int respId) {
		rrepository.deleteById(respId);
		return rrepository.findAll();

	}

	public List<Response> getResponseByDev(int devId) {
		return rrepository.findByDev(devId);

	}

	public List<Response> getResponseByFeed(int feedId) {
		return rrepository.findByFeeds(feedId);
	}

}
