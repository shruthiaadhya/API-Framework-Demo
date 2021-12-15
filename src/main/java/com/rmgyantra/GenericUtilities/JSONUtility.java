package com.rmgyantra.GenericUtilities;

import io.restassured.response.Response;

public class JSONUtility
{
   public String jsonPathFinder(String jsonpath, Response res)
   {
	String text = res.jsonPath().get(jsonpath);   
	return text;
   }
	
}
