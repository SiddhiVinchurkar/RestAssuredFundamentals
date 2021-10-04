package com.restassured;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ValidatableResponse_Header {

	public static final String BASE_URL = "https://api.github.com" ;

	
	@Test
	public void basicValidatableExample()
	{
		RestAssured.get(BASE_URL)
		            .then()       // from ValidatbleResponse
		            .statusCode(200)
		            .contentType(ContentType.JSON)
		            .header("x-ratelimit-limit", "60") ;
		
		//No need of Assert.methods() here. Assertion is performed in these methods directly
	}
	
	
	
	
	/*
	 * Syntactic Sugar (SS) methods are added just for readability
	 * They do nothing 
	 */
	@Test
	public void basicValidatableSyntaticSugarExample()
	{
		RestAssured.get(BASE_URL)
		            .then()       // from ValidatbleResponse
		            .assertThat()    		  // SS
		            	.statusCode(200)
		            .and()                   // SS
		            	.contentType(ContentType.JSON)
		            .and().assertThat()             // SS
		            	.header("x-ratelimit-limit", "60") ;		   	
		
	}
	
	Map<String, String> expectedHeaders = new HashMap<String,String>()
			{{
		put("content-encoding","gzip") ;
		put("access-control-allow-origin","*");
		
			}};
	
			
	
	@Test
	public void usingHapsToTestHeaders()
	{
		RestAssured.get(BASE_URL)
		           .then()
		           .headers(expectedHeaders);
	}
}
