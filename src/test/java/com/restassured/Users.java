package com.restassured;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * This is added so that it will check only id and login from the json response
 * If not given the test fails as all the other fields have not been defined
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Users 
{

	public String login;
	public int id;	
	
	@JsonProperty("public_repos")
	public int publicRepos;
	
	/*
	 * These name should map Json fields exactly : public int public_repos;
	 * Or add JSON property to match the Json fields
	 */
	
	public String getLogin() 
	{
		return login;
	}
	
	
	public int getId() 
	{
		return id;
	}
	
	
	public int getpublicRepos() 
	{
		return publicRepos;
	}
}
