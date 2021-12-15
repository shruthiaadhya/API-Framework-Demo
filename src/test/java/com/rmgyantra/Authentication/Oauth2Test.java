package com.rmgyantra.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2Test {
	
	@Test
	public void oauth()
	{
		Response res = given()
		.formParam("client_id", "shruthi")
		.formParam("client_secret","d7185c03052873dd02af59dc0247c3b7")
		.formParam("grant_type","client_credentials")
		.formParam("redirect_uri","http://coopexample.com")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(res.prettyPrint());
		
		String token = res.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", "2576")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then()
		.log()
		.all();
	}

}
