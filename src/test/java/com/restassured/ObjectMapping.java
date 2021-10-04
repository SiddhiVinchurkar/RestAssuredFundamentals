package com.restassured;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;

public class ObjectMapping 
{
	public static final String BASE_URL = "https://api.github.com/users/rest-assured" ;

	
	@Test
	public void objectMappingReplyingOnMapperType()
	{
			
	Users  user = RestAssured.get(BASE_URL)
							 .as(Users.class, ObjectMapperType.JACKSON_2);
	
	/*
	 * We are explicitly saying use Jackson parser. For  GSON parser
	 * 
	 *RestAssured.get(BASE_URL)
							 .as(Users.class, ObjectMapperType.GSON);
	 */
	
	assertEquals(user.getLogin(), "rest-assured");
	
	
	}
	
}
