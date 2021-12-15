package com.rmgyantra.GenericUtilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseApiClass
{
	
	public DataBaseUtility dutil=new DataBaseUtility();
	
	@BeforeSuite
	public void connectToDB()
	{
		dutil.connectToDataBase();
	}
	
	@AfterSuite
	public void disconnectFromDB() throws Throwable
	{
		dutil.disConnectFromDataBase();
		
	}

}
