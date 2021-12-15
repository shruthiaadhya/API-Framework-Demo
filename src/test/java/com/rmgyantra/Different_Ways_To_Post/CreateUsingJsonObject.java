package com.rmgyantra.Different_Ways_To_Post;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUsingJsonObject {
	
	@Test
	public void postByJsonObject()
	{
	
	JSONObject jObj=new JSONObject();
	jObj.put("createdBy", "navya2");
	jObj.put("projectName", "RMG233");
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
