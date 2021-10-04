package com.restassured;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import junit.framework.Assert;

public class ObjectMappingDemo {


	public static final String BASE_URL = "https://api.github.com/users/rest-assured" ;

	
	@Test
	public void objectMappingTestOne()
	{
		Users user = RestAssured.get(BASE_URL)
					.as(Users.class);
	
		// as method is used to unmarshall JSON response as a User class and save it to the user variable	
		
		assertEquals(user.getLogin(), "rest-assured");
	    assertEquals(user.getId(), 19369327);
	    assertEquals(user.getpublicRepos(), 2);
	    
		
	}
}
