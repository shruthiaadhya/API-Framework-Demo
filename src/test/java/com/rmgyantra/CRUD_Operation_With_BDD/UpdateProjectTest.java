package com.rmgyantra.CRUD_Operation_With_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
	
	@Test
	public void updateProject()
	{
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "navya2");
		jObj.put("projectName", "RMG222");
		jObj.put("status", "On Going");
		jObj.put("teamSize", 7);
		
		given()
		.contentType(ContentType.JSON)
		.body(jObj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1003")
		.then()
		.assertThat()
		.statusCode(200)
		.log()
		.all();
		
		
	}

}
