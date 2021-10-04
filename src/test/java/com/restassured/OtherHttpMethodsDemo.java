package com.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class OtherHttpMethodsDemo {
	
	public static final String BASE_URL = "https://api.github.com/user/repos" ;
    public static final String TOKEN = "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";
	 
    
    @Test
    public void patchTest()
    {
    	RestAssured
    				.given()     // RequestSpecification
    						.header("Authorization","token "+TOKEN)
    						.body("{\"name\":\"deleteme-pathched\"}")
    				.when()      // Syntactic Sugar
    						.patch("https://api.github.com/user/repos/SiddhiVinchurkar/RestApi")
    				.then()      // Validatable Response
    						.statusCode(200);
    }

    
    @Test
    public void postTest()
    {
    	RestAssured
    				.given()     // RequestSpecification
    						.header("Authorization","token "+TOKEN)
    						.body("{\"name\":\"RestApi\"}")
    				.when()      // Syntactic Sugar
    						.post(BASE_URL)
    				.then()      // Validatable Response
    						.statusCode(201);
    }
    
   
}
