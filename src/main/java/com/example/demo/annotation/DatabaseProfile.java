package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Target({ElementType.TYPE})
@Profile("database")
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@EnableScheduling
@Configuration
public @interface DatabaseProfile {


}