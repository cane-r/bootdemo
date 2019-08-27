package com.example.demo.aspect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.RequestDetails;
import com.example.demo.model.RequestDetails.RequestDetail;


@Aspect
@Component
//or HandlerInterceptorAdapter can be used for intercepting calls
public class LoggingAspect {
	
	  @Autowired
	  private RequestDetails requestDetails;

	
	@Around("pointcut()")
	public Object interceptAndLogHttpRequest(ProceedingJoinPoint joinPoint) throws Throwable {
		  String methodName=joinPoint.getSignature().getName();
		  Map<String,String> nameValuePairs=new HashMap<String, String>();
		  Object[] args = joinPoint.getArgs();
		  Method method=((MethodSignature)joinPoint.getStaticPart().getSignature()).getMethod();
		  Parameter params []=method.getParameters();
		  int methodParameterCount=method.getParameterCount();
		  String httpMethod= method.getDeclaredAnnotation(RequestMapping.class).method()[0].name();
		  String requestPath=method.getDeclaredAnnotation(RequestMapping.class).value()[0];
		  for(int i=0;i<methodParameterCount;i++) {
			  nameValuePairs.put(params[i].getName(), args[i].toString());  
		  }
		  RequestDetail requestDetail=RequestDetail.builder()
		  .httpMethod(httpMethod)
		  .classMethodName(methodName)
		  .methodParamsAndValues(nameValuePairs)
		  .requestTime(LocalDateTime.now())
		  .build();
		  
		 requestDetails.addRequestDetails(requestPath, requestDetail);
		
		 return joinPoint.proceed();
		
		
	}
	
	@Pointcut("execution(* com.example.demo.controller..*(..))")
	public void pointcut() {
		
	}
	
	
}
