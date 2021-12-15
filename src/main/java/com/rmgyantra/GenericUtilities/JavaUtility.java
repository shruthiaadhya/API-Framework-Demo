package com.rmgyantra.GenericUtilities;

import java.util.Random;

public class JavaUtility {
	
	
	public int getrandomNumber()
	{
		Random r=new Random();
		int randomNo= r.nextInt(2000);
		return randomNo;
		
	}
	
	

}
