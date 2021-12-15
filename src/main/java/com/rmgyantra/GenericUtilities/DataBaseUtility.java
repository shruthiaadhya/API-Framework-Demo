package com.rmgyantra.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
    Connection con=null;
	
	
	/**
	 * This method connects to database
	 */
	public void connectToDataBase()
	{
		
		try 
		{
			Driver dref=new Driver();
			DriverManager.registerDriver(dref);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * this method execute query and update query
	 * @param query
	 * @return 
	 * @throws Throwable
	 */
	public ResultSet executingSqlQuery(String query) throws Throwable
	{
        Statement stmt = con.createStatement();
	    ResultSet result = stmt.executeQuery(query);
	    return result;
	}
	
	/**
	 * this method disconnects from database
	 * @throws Throwable
	 */
	public void disConnectFromDataBase() throws Throwable
	{
		con.close();
	}

}
