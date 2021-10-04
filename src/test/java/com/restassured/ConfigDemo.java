package com.restassured;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;

import static org.hamcrest.Matchers.*;
//import static com.restassured.ConfigFactory.getDefaultConfig;
import static io.restassured.config.FailureConfig.*;
import static io.restassured.config.RedirectConfig.redirectConfig;


public class ConfigDemo {
	
	public static final String BASE_URL = "https://api.github.com/";

	
	
	@Test
	public void maxRedirectsTest()
	{
		
		//Explicitly setting the redirect url as false
		
	/*	RestAssured.config = RestAssured.config()
										.redirect(redirectConfig().followRedirects(false));
		*/
			
		
		// Allowing max re directs to the set number here 0
		/*
		RestAssured.config = RestAssured.config()
                .redirect(redirectConfig().followRedirects(true).maxRedirects(0));
		*/
		
		RestAssured.get(BASE_URL+"repos/twitter/bootstrap")
					.then()
					.statusCode(equalTo(200));
	}
	
	
	
	/*
   





    @Test
    public void failureConfigExample() {

        ResponseValidationFailureListener failureListener = (reqSpec, resSpec, response) ->
                        System.out.printf("We have a failure, " +
                                "response status was %s and the body contained: %s",
                                response.getStatusCode(), response.body().asPrettyString());

        RestAssured.config = RestAssured.config()
                                    .failureConfig(failureConfig().failureListeners(failureListener));

        RestAssured.get(BASE_URL + "users/andrejs-ps")
                .then()
                .body("some.path", Matchers.equalTo("a thing"));
    }


  

*/
}
