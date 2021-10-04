package com.restassured;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class StatusCodeConstant {
	
	@Test
	public void basicExample()
	{
		RestAssured.get()
					.then()
					.statusCode(HttpStatus.SC_OK);   
		
		// instead of using 200 we can use httpStatus class or create an interface of your own and define all the status code there
		
	}

}
