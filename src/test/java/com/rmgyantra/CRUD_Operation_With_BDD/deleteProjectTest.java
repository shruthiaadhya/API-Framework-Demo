package com.rmgyantra.CRUD_Operation_With_BDD;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class deleteProjectTest {

	@Test
	public void delete()
	{
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_1002")
		.then()
		.assertThat()
		.statusCode(204);
	}
}
