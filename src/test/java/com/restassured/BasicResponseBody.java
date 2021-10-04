package com.restassured;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;

public class BasicResponseBody 
{
	public static final String BASE_URL = "https://api.github.com/rate_limit" ;

	@Test
	public void bodyMethods()
	{
	
	Response response = RestAssured.get(BASE_URL);
	
	ResponseBody<?> body = response.body();
	JsonPath jpath1 = body.jsonPath();
	
	// OR
	
	JsonPath jpath2 = response.body().jsonPath();
	                        //.getBody() also works
	
	Map<String , String> fullJson = jpath2.get();
	Map<String , String> subMap1 = jpath2.get("resources");
	Map<String , String> subMap2 = jpath2.get("resources.core");
	int value1 = jpath1.get("resources.core.limit");
	int value2 = jpath1.get("resources.graphql.remaining");
	
	
	System.out.println("-----Full Json ------- : "+fullJson);
	System.out.println("-----sub map1 ------- : "+subMap1);
	System.out.println("-----sub map2 ------- : "+subMap2);
	System.out.println("-----value1 ------- : "+value1);
	System.out.println("-----value2 ------- : "+value2);
	
	Assert.assertEquals(value1, 60);
	Assert.assertEquals(value2, 0);
	
	}
	
	
}
