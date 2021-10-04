package com.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import static org.hamcrest.Matchers.*;
/*
 * JSON is the default parser, adding or removing defaultParser() wont make a difference
 * 
 */

public class DefualtParser {
	
	public static final String BASE_URL = "https://api.github.com" ;

	
	@Test
	public void Dparser()
	{
		RestAssured.get(BASE_URL)
					.then()
					.using()   // Syntatic Sugar
						.defaultParser(Parser.XML)
					.body("current_user_url", equalTo(BASE_URL + "user"));
					
	}

}
