package com.restassured;

import javax.xml.crypto.Data;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.is; 


/*
 *  Using get without the url paramter
 *  Here we are overriding the baseURI which is then given to get() method
 */

public class GlobalVariableDemo {
	
	/*
	 * Here we are overriding the default value of url set for get() method
	 */
	
	@BeforeSuite
	public void setup()
	{
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "api/users";
	    RestAssured.rootPath = "data";
		
	}
	
	/*
	 * Here get is a overloaded method 
	 */
	
	@Test
	public void testOneUsingGlobalConstants()
	{
		RestAssured.get()
					.then()
				//	.body("data.id[0]",is(1));
					.body("id[0]", is(1));
	}
	
	
	@Test
    public void testTwoUsingGlobalConstants() {

        RestAssured.get()
                .then()
                .body("id[1]", is(2));
    }

}
