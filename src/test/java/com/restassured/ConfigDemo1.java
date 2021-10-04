package com.restassured;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.FailureConfig;
import io.restassured.config.FailureConfig;
import io.restassured.listener.ResponseValidationFailureListener;
import static org.hamcrest.Matchers.*;
//import static com.psrestassured.ConfigFactory.getDefaultConfig;
import static io.restassured.config.FailureConfig.*;
import static io.restassured.config.RedirectConfig.redirectConfig;


public class ConfigDemo1 {
	
	public static final String BASE_URL = "https://api.github.com/";

	
	@Test
    public void failureConfigExample() {
		
		//Give more info in case of failure

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



}
