package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Project {
	
	public Connection connect()
	{
	 Connection con = null;

	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");
	 con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/myproject", "root", "");
	 //For testing
	// System.out.print("Successfully connected");
	 }
	 catch(Exception e)
	 {
	 e.printStackTrace();
	 }

	 return con;
	}
	//Read
	public String readProject()
	{ 
	 String output = ""; 
	try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 { 
	 return "Error while connecting to the database for reading."; 
	 } 
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>Project code</th>" +
			 "<th>Project Name</th>" +
			 "<th>Project Description</th>" +
			 "<th>Start Date</th>" +
			 "<th>End Date</th>" +
			 "<th>Update</th><th>Remove</th></tr>";
	 String query = "select * from project"; 
	 Statement stmt = con.createStatement(); 
	 ResultSet rs = stmt.executeQuery(query); 
	 // iterate through the rows in the result set
	 while (rs.next()) 
	 { 
	 String projectID = Integer.toString(rs.getInt("projectID")); 
	 String projectCode = rs.getString("projectCode"); 
	 String projectName = rs.getString("projectName"); 
	 String projectDesc = rs.getString("projectDesc");
	 String projectstartdate = rs.getString("projectstartdate");
	 String projectenddate = rs.getString("projectenddate");
	// Add into the html table
	 output += "<tr><td><input id='hidProjectIDUpdate'name='hidProjectIDUpdate'type='hidden' value='" + projectID
				+ "'>" + projectCode + "</td>";
		output += "<td>" + projectName + "</td>";
		output += "<td>" + projectDesc + "</td>";
		output += "<td>" + projectstartdate + "</td>";
		output += "<td>" + projectenddate + "</td>";
		// buttons
		output += "<td><input name='btnUpdate'type='button' value='Update'class='btnUpdate btn btn-secondary'></td>"
				+ "<td><input name='btnRemove'type='button' value='Remove'class='btnRemove btn btn-danger'data-projectid='"
				+ projectID + "'>" + "</td></tr>";
	 } 
	 con.close(); 
	 // Complete the html table
	 output += "</table>"; 
	 } 
	catch (Exception e) 
	 { 
	 output = "Error while reading the projects."; 
	 System.err.println(e.getMessage()); 
	 } 
	return output; 
	}

    //insert
	public String insertProject(String code, String projectname, String desc, String startdate, String enddate) 
			 { 
			 String output = ""; 
			 try
			 { 
			 Connection con = connect(); 
			 if (con == null) 
			 { 
			 return "Error while connecting  to the database for inserting."; 
			 } 
			 // create a prepared statement
			 String query = " insert into project(`projectCode`,`projectName`,`projectDesc`,`projectstartdate`,`projectenddate`,`projectID`)"
			+ " values (?, ?, ?, ?, ?, ?)";
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 // binding values
			 preparedStmt.setString(1, code);
			 preparedStmt.setString(2, projectname);
			 preparedStmt.setString(3, desc);
			 preparedStmt.setString(4, startdate);
			 preparedStmt.setString(5, enddate);
			 preparedStmt.setInt(6, 0);
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 String newProjects = readProject(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
					 newProjects + "\"}"; 
			 } 
			 catch (Exception e) 
			 { 
			 output = "{\"status\":\"error\", \"data\": \"Error while inserting the project.\"}"; 
			 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 }
	         
	          //Update
			public String updateProject(String ID, String code, String projectname, String desc, String startdate, String enddate) 
			 { 
			 String output = ""; 
			 try
			 { 
			 Connection con = connect(); 
			 if (con == null) 
			 { 
			 return "Error while connecting to the database for updating."; 
			 } 
			 // create a prepared statement
			 String query = "UPDATE project SET projectCode=?,projectName=?,projectDesc=?,projectstartdate=?,projectenddate=? WHERE projectID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 // binding values
			 preparedStmt.setString(1, code);
			 preparedStmt.setString(2, projectname);
			 preparedStmt.setString(3, desc);
			 preparedStmt.setString(4, startdate);
			 preparedStmt.setString(5, enddate);
			 preparedStmt.setInt(6, Integer.parseInt(ID));
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 String newProjects = readProject(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
					 newProjects + "\"}"; 
			 } 
			 catch (Exception e) 
			 { 
			 output = "{\"status\":\"error\", \"data\": \"Error while updating the project.\"}"; 
			 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 } 
			
			
			//Delete
			public String deleteProject(String projectID) 
			 { 
			 String output = ""; 
			 try
			 { 
			 Connection con = connect(); 
			 if (con == null) 
			 { 
			 return "Error while connecting to the database for deleting."; 
			 } 
			 // create a prepared statement
			 String query = "delete from project where projectID=?"; 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(projectID)); 
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 String newProjects = readProject(); 
			 output = "{\"status\":\"success\", \"data\": \"" + 
					 newProjects + "\"}"; 
			 } 
			 catch (Exception e) 
			 { 
			 output = "{\"status\":\"error\", \"data\": \"Error while deleting the project.\"}"; 
			 System.err.println(e.getMessage()); 
			 } 
			 return output; 
			 } 


}
