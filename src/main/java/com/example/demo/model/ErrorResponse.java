package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {

	
    private int httpStatus;
    private String errorMessage;
    private String errorTimestamp;
	
	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}

}
