package com.restassured;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class BasicResponseHeader 
{
	public static final String BASE_URL = "https://api.github.com" ;

	@Test
	void convienceMethod()
	{
	Response response = RestAssured.get(BASE_URL);
	Assert.assertEquals(response.getStatusCode(),200);
	Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
	
	}
	
	//application/json; charset=utf-8
	
/*
1) Using Response.getHeader() method we can get tag value of any tags in the header
2) getHeader method will return an object of header	
3) getHeader will always return a string hence numbers will be treated as String.
4) If needed we can convert using the parse methods	
*/	
	
	@Test
	public void genericHeader()
	{
		Response response = RestAssured.get(BASE_URL);
		Assert.assertEquals(response.getHeader("server"), "GitHub.com");
		Assert.assertEquals(response.getHeader("x-ratelimit-limit"), "60");
	}
	
	@Test
	public void getHeaders()
	{
		Response response = RestAssured.get(BASE_URL);
		Headers header = response.getHeaders();
		//System.out.println(header.toString());  // prints all headers with their values
		String value = header.getValue("header1");
		int size = header.size();
		System.out.println("Value : "+ value +" Size : "+size);
		List<Header> list = header.asList();
		boolean isPresent = header.hasHeaderWithName("header2");
		Assert.assertTrue(isPresent);	
	}
	
/*
 * 1) getTime() and time() are the same methods
 * 2) They will tell us the measured response time
 */
	
	@Test
	public void timeExample()
	{
		Response response = RestAssured.get(BASE_URL);
		System.out.println("Get Time method : "+ response.getTime());
		System.out.println("Get Time In method " +response.getTimeIn(TimeUnit.MINUTES));
	    
	}
	
	
}
