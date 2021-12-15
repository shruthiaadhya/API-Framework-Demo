package com.rmgyantra.Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GithubParameterTest {
	
	@Test
	public void githubParameter()
	{
		given()
		.pathParam("username", "aadhyashru194")
		.queryParam("sort", "created")
		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then()
		.log().all();
	}

}
