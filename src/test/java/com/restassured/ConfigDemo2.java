package com.restassured;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static com.restassured.ConfigFactory.getDefaultConfig;

public class ConfigDemo2 {

	
	
	 @BeforeSuite
	    void setup() {
	        RestAssured.config = getDefaultConfig();
	    }
	    
	    

	    @Test
	    public void cleanTestWithHiddenConfig() {
	       Users user = RestAssured.get("https://api.github.com/users/rest-assured")
	                .as(Users.class);

	        assertEquals(user.login, "rest-assured");
	        assertEquals(user.id, 19369327);
	    }
}
