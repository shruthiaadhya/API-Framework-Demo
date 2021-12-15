package com.rmgyantra.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PreemptiveAndDigestiveAuthTest {

	@Test
	public void preemptiveAuth()
	{
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
		.assertThat()
		.statusCode(202);
		
	}
	
	@Test
	public void digestiveAuth()
	{
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
		.assertThat()
		.statusCode(202);
	}
}
