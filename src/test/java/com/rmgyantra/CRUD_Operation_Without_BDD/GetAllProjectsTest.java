package com.rmgyantra.CRUD_Operation_Without_BDD;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProjectsTest {
	
	@Test
	public void getAllProjects()
	{
		Response response = RestAssured.get("http://localhost:8084/projects");
	    System.out.println(response.prettyPrint());
	    System.out.println(response.getContentType());
	    System.out.println(response.getStatusCode());
	    
	    ValidatableResponse Vres = response.then();
	    Vres.assertThat().statusCode(200);
	    Vres.assertThat().contentType("application/json");
	    Vres.log().all();
	}

}
