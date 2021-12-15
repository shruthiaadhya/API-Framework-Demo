package com.rmgyantra.Different_Ways_To_Post;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUsingHashMap {
	
	@Test
	public void postByHashMap()
	{
		HashMap hp=new HashMap();
		hp.put("createdBy", "navya3");
		hp.put("projectName", "RMG24");
	    hp.put("status", "On Going");
		hp.put("teamSize", 3);
		
		given()
		.contentType(ContentType.JSON)
		.body(hp)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log()
		.all();
	}

}
