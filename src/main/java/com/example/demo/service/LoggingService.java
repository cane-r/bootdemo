package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.demo.annotation.DatabaseProfile;
import com.example.demo.annotation.RestProfile;
import com.example.demo.model.RequestDetails;
import com.example.demo.model.RequestDetails.RequestDetail;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestProfile
@DatabaseProfile
public class LoggingService {

	 
	 private RequestDetails requestDetails ;
	 private Logger logger; 
	

	@Scheduled(cron = "*/20 * * * * *")
	    public void logRequestDetails() {
		if(!requestDetails.isMapEmpty())
		{
		logger.info("-------*********-------");
	      Map<String,List<RequestDetail>> detail=requestDetails.getStats();
	      //String resourceName=requestDetails.
	      Set<String> keySet=detail.keySet();
	      for(String key:keySet) {
	    	  List<RequestDetail> list = detail.get(key);
	    	  logger.info("--- stats for endpoint : " + key);
	    	  logger.info("---- number of requests: " + list.size());
	    	  list.forEach(req->logger.info(req.toString()));
	    	  
	      }
	      logger.info("-------*********-------");
	      requestDetails.clearStats();
	    }
	}
	}
	
	

