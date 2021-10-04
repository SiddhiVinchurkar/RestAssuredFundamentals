package com.restassured;

import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;
import org.hamcrest.core.SubstringMatcher;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ValidatableResponse_Body 
{
	public static final String BASE_URL = "https://api.github.com" ;

	
	@Test
	public void bodyMethods()
	{
		RestAssured.get(BASE_URL)
		 			.then()
		 			.body("resources.core.limit", equalTo(60))
		 			.body("resources.core.remaining" , lessThanOrEqualTo(60))
		 			.body("resources.core.reset" , notNullValue());
		
		 			
		 		
		 			
	}

}
