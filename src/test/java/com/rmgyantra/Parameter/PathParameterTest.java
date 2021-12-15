package com.rmgyantra.Parameter;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameterTest {

	@Test
	public void pathParameter()
	{
		given()
		.contentType(ContentType.JSON)
		.pathParam("proId","TY_PROJ_605")
		.when()
		.get("http://localhost:8084/projects/{proId}")
		.then()
		.log()
		.all();
	}
}
