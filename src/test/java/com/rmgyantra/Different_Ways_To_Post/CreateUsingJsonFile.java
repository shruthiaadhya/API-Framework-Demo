package com.rmgyantra.Different_Ways_To_Post;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateUsingJsonFile {
	
	@Test
	public void postByJsonFile()
	{
		File file = new File("./jfile.json");
		
		given()
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log()
		.all();
	}

}
