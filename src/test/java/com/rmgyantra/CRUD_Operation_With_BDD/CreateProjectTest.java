package com.rmgyantra.CRUD_Operation_With_BDD;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest {
	
	@Test
	public void createProject()
	{
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "navya1");
		jObj.put("projectName", "RMG22");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 5);
		
		given()
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log()
		.all();
	}

}
