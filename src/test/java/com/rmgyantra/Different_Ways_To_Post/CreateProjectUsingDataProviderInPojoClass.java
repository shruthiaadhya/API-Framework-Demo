package com.rmgyantra.Different_Ways_To_Post;



import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgyantra.ProjectLibrary.PojoLibrary;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectUsingDataProviderInPojoClass {
	
	@Test(dataProvider="providerData")
	public void postByPojoClass(String createdBy, String projectName, String status, int teamSize)
	{
		Random r = new Random();
		int randomNo = r.nextInt(1000);
		
		PojoLibrary pl=new PojoLibrary(createdBy, projectName+randomNo, status, teamSize);
		
		
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
	
	@DataProvider()
	public Object[][] providerData()
	{
		Object[][] arr=new Object[2][4];
		arr[0][0]="niki";
		arr[0][1]="Hospet0";
		arr[0][2]="created";
		arr[0][3]=3;
		
		arr[1][0]="nikibaby";
		arr[1][1]="Hospet1";
		arr[1][2]="On Going";
		arr[1][3]=5;
		
		return arr;
		
	}

}
