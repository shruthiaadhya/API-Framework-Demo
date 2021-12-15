package com.rmgyantra.CRUD_Operation_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
	@Test
	public void createProject()
	{
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "pravi");
		jObj.put("projectName", "RMG-55");
		jObj.put("status","Completed");
		jObj.put("teamSize", 4);
		
		RequestSpecification reqSpe = RestAssured.given();
		reqSpe.contentType(ContentType.JSON);
		reqSpe.body(jObj);
		
		Response rsps = reqSpe.post("http://localhost:8084/addProject");
		ValidatableResponse vres = rsps.then();
		vres.assertThat().statusCode(201);
		
		
	}

}
