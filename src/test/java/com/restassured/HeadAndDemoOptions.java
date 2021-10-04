package com.restassured;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.*;


/*
 * Head : Get Header only , no body i.e body will be empty 
 * Options : List of supported htpp methods
 */

public class HeadAndDemoOptions 
{

	public static final String BASE_URL = "https://api.github.com" ;

	@Test
	public void headTest()
	{
		RestAssured.head(BASE_URL)
					.then()
					.statusCode(200)
					.body(emptyOrNullString()); 
		
	}
	
	@Test
	public void optionsTest() 
	{
		RestAssured.options(BASE_URL)
					.then()
					.statusCode(204)
					.header("access-control-allow-methods", equalTo("GET, POST, PATCH, PUT, DELETE"))
					.body(emptyOrNullString());
	}
	
		
	
}
