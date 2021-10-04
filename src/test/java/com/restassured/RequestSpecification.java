package com.restassured;

import static com.restassured.ConfigFactory.getDefaultConfig;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

public class RequestSpecification {
	
	
	public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void testUsingLocalRequestSpec() {
        RestAssured
                .given()
                    .spec(getDefaultRequestSpec())
                .when()
                    .get()
                .then()
                    .statusCode(200);
    }

    public static io.restassured.specification.RequestSpecification getDefaultRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setConfig(getDefaultConfig())
                .build();
    }

}
