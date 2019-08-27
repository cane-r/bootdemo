package com.example.demo.interceptor;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.NoValueSpecifiedException;
import com.example.demo.model.ErrorResponse;

@ControllerAdvice
public class ErrorHandlerInterceptor extends ResponseEntityExceptionHandler {

	    @ExceptionHandler(NoValueSpecifiedException.class)
	    public ResponseEntity<ErrorResponse> errorHandler(Exception ex) throws IOException {
	       ErrorResponse response=ErrorResponse.builder()
	    		   .errorMessage(ex.getMessage())
	    		   .httpStatus(HttpServletResponse.SC_BAD_REQUEST)
	    		   .errorTimestamp(LocalDateTime.now().toString()).build();
	       return ResponseEntity.badRequest().body(response);
	    		   
	    }
		public ErrorHandlerInterceptor() {
			// TODO Auto-generated constructor stub
		}
}
