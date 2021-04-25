package model;

import java.sql.*;

import util.DB_Connection;

public class Project {
	
	public String readProjects(){ 
		
		 String output = ""; 
		 
		 try{ 
			 
			 	DB_Connection obj_DB_Connection= new DB_Connection();
				Connection con = obj_DB_Connection.connect();

		 if (con == null){ 
			 
			 return "Error while connecting to the database for reading."; 
		 } 
		 
				 // Prepare the html table to be displayed
				 output = "<table border='1'><tr><th>Project Code</th>" 
						 +"<th>Project Name</th><th>Project Price</th>"
						 + "<th>Project Description</th>" 
						 + "<th>Project By</th>"
						 + "<th>Project Category</th>" 
						 + "<th>Update</th><th>Remove</th></tr>"; 
				 
				 	String query = "select * from projects"; 
				 	Statement stmt = con.createStatement(); 
				 	ResultSet rs = stmt.executeQuery(query); 
				 
				 	// iterate through the rows in the result set
				 	while (rs.next()){ 
					 
				 		String projectID = Integer.toString(rs.getInt("projectID")); 
				 		String projectCode = rs.getString("projectCode"); 
				 		String projectName = rs.getString("projectName"); 
				 		String projectPrice = Double.toString(rs.getDouble("projectPrice")); 
				 		String projectDesc = rs.getString("projectDesc"); 
				 		String projectBy = rs.getString("projectBy"); 
				 		String projectCtg = rs.getString("projectCtg"); 
				 
				 		// Add a row into the html table
				 		output += "<tr><td>" + projectCode + "</td>"; 
				 		output += "<td>" + projectName + "</td>"; 
				 		output += "<td>" + projectPrice + "</td>"; 
				 		output += "<td>" + projectDesc + "</td>";
				 		output += "<td>" + projectBy + "</td>";
				 		output += "<td>" + projectCtg + "</td>";
				 
				 		// buttons
				 		output += "<td><input name='btnUpdate' " 
				 				+ " type='button' value='Update'></td>"
				 				+ "<td><form method='post' action=''>"
				 				+ "<input name='btnRemove' " 
				 				+ " type='submit' value='Remove'>"
				 				+ "<input name='projectID' type='hidden' " 
				 				+ " value='" + projectID + "'>" + "</form></td></tr>"; 
				 	} 
				 	con.close(); 
				 	// Complete the html table
				 	output += "</table>"; 
				 	} 
				 
					catch (Exception e) { 
					
						output = "Error while reading the projects."; 
						System.err.println(e.getMessage()); 
					} 
				 
				 	return output; 
	}
	
	

}
