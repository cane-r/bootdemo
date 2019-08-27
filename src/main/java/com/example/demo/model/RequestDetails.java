package com.example.demo.model;
import java.util.ArrayList;
import java.time.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDetails {
	 
	//key : endpoint, value:requestdetail
	private Map<String,List<RequestDetail>> stats;
	
	public RequestDetails() {
		stats=new HashMap<String, List<RequestDetail>>();
	}
	
	
	
	public void addRequestDetails(String key,RequestDetail detail) {
		if(stats.get(key)==null ) {
			List<RequestDetail> detailList=new ArrayList<>();
			detailList.add(detail);
			stats.put(key, detailList);
			}
		else {
			stats.get(key).add(detail);
		}
	}
	
	public void clearStats() {
		stats.clear();
	}
	
	public boolean  isMapEmpty() {
		return stats.size()<1;
	}
	
	

	@Data
	@Builder
	public static class RequestDetail{
		private String httpMethod;
		private String classMethodName;
		private Map<String,String> methodParamsAndValues;
		private LocalDateTime requestTime;
	}

}
