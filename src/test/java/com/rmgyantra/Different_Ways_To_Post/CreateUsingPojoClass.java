package com.rmgyantra.Different_Ways_To_Post;

import org.testng.annotations.Test;

import com.rmgyantra.ProjectLibrary.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateUsingPojoClass 
{

	@Test
	public void postByPojoClass()
	{
		Random r = new Random();
		int randomNo = r.nextInt(1000);
		
		PojoLibrary pl=new PojoLibrary("Rana", "Pretty Print"+randomNo, "Completed", 3);
		
		given()
		.contentType(ContentType.JSON)
		.body(pl)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log()
		.all();
	}
}
