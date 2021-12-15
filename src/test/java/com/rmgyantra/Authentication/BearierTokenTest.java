package com.rmgyantra.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearierTokenTest
{
	@Test
	public void bearierToken()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://github.com/user/repos")
		.then()
		.log()
		.all();
	}
	

}
