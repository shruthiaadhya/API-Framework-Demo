package com.rmgyantra.CRUD_Operation_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {

	@Test
	public void updateProjectWithPut()
	{

		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "pravi1");
		jObj.put("projectName", "RMG-66");
		jObj.put("status","Completed");
		jObj.put("teamSize", 2);
		
		RequestSpecification reqSpe = RestAssured.given();
		reqSpe.contentType(ContentType.JSON);
		reqSpe.body(jObj);
		
		Response rsps = reqSpe.put("http://localhost:8084/projects/TY_PROJ_001");
		ValidatableResponse vres = rsps.then();
		vres.assertThat().statusCode(200);
	}
}
