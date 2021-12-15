package com.rmgyantra.ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {

	@Test
	public void staticResponseValidation()
	{
		String expdata="RMG-66";
		Response res = when().get("http://localhost:8084/projects");
		
		res.then().assertThat().statusCode(200);
		
		String acdata = res.jsonPath().get("[0].projectName");
		System.out.println(acdata);
		Assert.assertEquals(acdata, expdata);
		
	}
}
