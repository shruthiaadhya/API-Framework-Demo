package com.rmgyantra.ResponseValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationTest 
{
	@Test
	public void dynamicResponseValidation()
	{
		String expdata="Hospet11752";
		Response res = when().get("http://localhost:8084/projects");
	    res.then().assertThat().statusCode(200);
	    
	   List<String> listdata = res.jsonPath().get("projectName");
	   for(String acdata:listdata)
	   {
		   if(acdata.equals(expdata))
		   {
			   System.out.println(acdata+" is Present");
			   break;
		   }
	   }
	}
	
}
