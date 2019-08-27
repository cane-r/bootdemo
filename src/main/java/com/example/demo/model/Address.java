package com.example.demo.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Embeddable
public class Address extends BaseModel {


private String street;

private String suite;

private String city;

private String zipcode;

@Embedded
private Geo geo;

}
