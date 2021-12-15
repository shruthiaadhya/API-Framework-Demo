package com.rmgyantra.CRUD_Operation_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjectTest {
	
	@Test
	public void deleteProjectTest()
	{
	Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_602");
    ValidatableResponse Vres = response.then();
    Vres.assertThat().statusCode(204);
	}
}
