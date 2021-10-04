package com.restassured;



import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicTest 
{
	public static final String BASE_URL = "https://api.github.com" ;

	
	 @Test
	 void someTest()
		{
			RestAssured.get(BASE_URL)
			.then()
			.statusCode(200);
			
			//RestAssured.get().statusCode(); 
			// Also allowed but for fluent interface we add then
		}
	
	 
// Peek prints both header and body to the standard output	 
	 @Test
	 public void peek()
	 {
		 System.out.println("------Starting peek method-----");
		 RestAssured.get(BASE_URL)
	                 .peek();
	 }

	// Pretty Peek prints both header and body (in a nice format) to the standard output		  
	 @Test
	 public void prettyPeek()
	 {
		 System.out.println("------Starting pretty peek method-----");
		 RestAssured.get(BASE_URL)
	                 .prettyPeek(); 	 
	 }
	 
	// Print prints and body to the standard output		  
	 @Test
	 public void print()
	 {
		 System.out.println("------Starting print method-----");
		 RestAssured.get(BASE_URL)
	                 .print() ;	 
	 }
	 
	// Pretty Print prints body (in a nice format) to the standard output and as a String	  
	 @Test
	 public void prettyPrint()
	 {
		 System.out.println("------Starting pretty print method-----");
		 RestAssured.get(BASE_URL)
	                 .prettyPrint() ;	 
	 }
	 
	 /*
	  * We can use all the above methods for header and body separately as well
	  * RestAssured.get().getHeader() & RestAssured.get().getBody() 
	  * OR
	  * respone.get().getHeader() & response.get().getBody() 
	  * 
	  */
	 
}
