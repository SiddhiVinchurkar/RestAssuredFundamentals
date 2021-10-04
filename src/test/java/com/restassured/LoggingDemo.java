package com.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;

public class LoggingDemo {

	
	
	 public static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

	    @Test
	    public void test() {
	        RestAssured
	                .given()
	                    .log().all()   // logging from request
	                // OR
	                     .log().headers()
	                     .log().body()       // logging from response
	                .when()
	                    .get(BASE_URL)
	                .then()
	                	.log().headers()
	                	.log().status()
	                	.log().ifValidationFails(LogDetail.HEADERS)
	                    .statusCode(200);

	    }
}
