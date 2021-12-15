package com.rmgyantra.EndToEndScenario;

import static io.restassured.RestAssured.*;

import java.sql.ResultSet;

import org.testng.annotations.Test;

import com.rmgyantra.GenericUtilities.BaseApiClass;
import com.rmgyantra.GenericUtilities.EndPoints;
import com.rmgyantra.GenericUtilities.JSONUtility;
import com.rmgyantra.GenericUtilities.JavaUtility;
import com.rmgyantra.ProjectLibrary.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndScenarioTest extends BaseApiClass implements EndPoints
{
	@Test
	public void createProect() throws Throwable
	{
		JavaUtility jutil=new JavaUtility();
		
		PojoLibrary pl=new PojoLibrary("ramcharan","RRR" +jutil.getrandomNumber(), "On Going", 3);
		
	     baseURI="http://localhost";
	     port=8084;
		//creating project
		Response res = given()
		.contentType(ContentType.JSON)
		.body(pl)
		.post(createProj);
		
		JSONUtility jsutil= new JSONUtility();
		String pid = jsutil.jsonPathFinder("projectId", res);
		
		//getting project
		Response res1 = given()
		.pathParam("p_id",pid)
		.when()
		.get("http://localhost:8084/projects/{p_id}");
		
		//getting project name
		String pname = jsutil.jsonPathFinder("projectName", res1);
		System.out.println(pname);
		
		//validating with Database
		
	    ResultSet result = dutil.executingSqlQuery("select * from project");
		
		while(result.next())
		{
			 if(result.getString(4).equals(pname))
			 {
				 System.out.println("Project Name from JDBC"+" "+result.getString(4));
			 }
		}
		
		
		
    }
	
	
	
	
	

}
