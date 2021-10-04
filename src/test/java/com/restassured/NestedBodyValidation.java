package com.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;


public class NestedBodyValidation 
{
	

public static final String BASE_URL = "https://api.github.com" ;

	
	@Test
	public void bodyMethods()
	{
		RestAssured.get(BASE_URL + "rate_limit")
				    .then()
				    .rootPath("resources.core")
		 				.body("limit", equalTo(60))
		 				.body("remaining", lessThanOrEqualTo(60))
		 				.body("reset" , notNullValue())
		 			.rootPath("resources.search")
		 				.body("limit" , equalTo(10))
		 			.noRootPath()    // to reset the path
		 			;
		 				
	}

}
