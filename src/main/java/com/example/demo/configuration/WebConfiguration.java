package com.example.demo.configuration;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;


@Configuration  
public class WebConfiguration extends WebMvcConfigurationSupport  {  
	
	 @Override
	    public void configurePathMatch(PathMatchConfigurer matcher) {
	        matcher.setUseRegisteredSuffixPatternMatch(true);
	    }
	 
	 @Override
	    protected void extendMessageConverters( List<HttpMessageConverter<?>> converters ) {
	        for ( HttpMessageConverter<?> converter : converters ) {
	            if ( converter instanceof MappingJackson2HttpMessageConverter) {
	                MappingJackson2HttpMessageConverter jacksonConverter = (MappingJackson2HttpMessageConverter) converter;
	                jacksonConverter.getObjectMapper()
	                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
	                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
	                .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES,false)
	                .setSerializationInclusion(Include.NON_NULL)
	                .setSerializationInclusion(Include.NON_EMPTY);
	                jacksonConverter.setPrettyPrint(true);
	               
	                break;
	            }
	        }
	 }
}
	
 
