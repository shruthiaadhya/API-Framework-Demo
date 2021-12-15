package com.rmgyantra.RequestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingTest {
	
	@Test
	public void requestChaining()
	{
		Response res = given()
		.get("http://localhost:8084/projects");
		String projectId = res.jsonPath().get("[1].projectId");
		System.out.println(projectId);
		
		given()
		.pathParam("proId", projectId)
		.when()
		.delete("http://localhost:8084/projects/{proId}")
		.then()
		.log()
		.all();
	}

}
