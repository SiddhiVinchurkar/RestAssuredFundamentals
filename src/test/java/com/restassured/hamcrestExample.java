package com.restassured;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import org.testng.annotations.Test;



public class hamcrestExample {

	
	@Test
	public void hamcrestEx()
	{
		assertThat(10, lessThan(11));
	}
}
