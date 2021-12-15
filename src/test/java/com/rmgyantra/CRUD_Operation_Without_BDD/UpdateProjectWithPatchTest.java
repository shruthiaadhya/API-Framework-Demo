package com.rmgyantra.CRUD_Operation_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectWithPatchTest {
	
	@Test
	public void updateByPatch()
	{
		JSONObject jObj = new JSONObject();
		jObj.put("name", "lilly");
		
		
		RequestSpecification reqSpe = RestAssured.given();
		reqSpe.contentType(ContentType.JSON);
		reqSpe.body(jObj);
		
		Response rsps = reqSpe.patch("https://reqres.in/api/users/2");
		ValidatableResponse vres = rsps.then();
		vres.assertThat().statusCode(200);
	}

}
