package com.example.demo.interceptor;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class JsonHttpInterceptor implements ClientHttpRequestInterceptor{
		
	@Override
		  public ClientHttpResponse intercept(HttpRequest request, byte[] body,
		        ClientHttpRequestExecution execution) throws IOException {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("Content-Type", "application/json");
		    return execution.execute(request, body);
		 }
	}


