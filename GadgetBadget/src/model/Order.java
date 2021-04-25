package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import util.DB_Connection;

public class Order {
	
	
	public String readOrders() 
	{ 
		String output = ""; 
		
		try
		{ 
			
			DB_Connection obj_DB_Connection= new DB_Connection();
			Connection con = obj_DB_Connection.connect();
			
			if (con == null) 
			{return "Error while connecting to the database for reading."; }
			
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Order Code</th><th>Customer ID</th>" +
					"<th>Customer Name</th>" + "<th>Customer Email</th>" +
					"<th>Customer Address</th>" + "<th>Order Total Amount</th>" +
					"<th>Update</th><th>Remove</th></tr>"; 
 
			String query = "select * from order"; 
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) 
			{ 
				 String orderID = Integer.toString(rs.getInt("orderID")); 
				 String orderCode = rs.getString("orderCode"); 
				 String customerID = rs.getString("customerID");
				 String customerName = rs.getString("customerName");
				 String customerEmail = rs.getString("customerEmail");
				 String customerAddress = rs.getString("customerAddress");
				 String orderTotalAmount = Double.toString(rs.getDouble("orderTotalAmount")); 
				 
				 
				 // Add into the html table
				 output += "<tr><td>" + orderCode + "</td>"; 
				 output += "<td>" + customerID + "</td>"; 
				 output += "<td>" + customerName + "</td>"; 
				 output += "<td>" + customerEmail + "</td>";
				 output += "<td>" + customerAddress + "</td>"; 
				 output += "<td>" + orderTotalAmount + "</td>"; 
				 
				 // buttons
				 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
						 	+ "<td><form method='post' action='orders.jsp'>"
						 	+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
						 	+ "<input name='orderID' type='hidden' value='" + orderID 
						 	+ "'>" + "</form></td></tr>"; 
			}
			
			con.close();
			
			// Complete the html table
			output += "</table>"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while reading the orders."; 
			System.err.println(e.getMessage()); 
		}
		
		return output; 
	}
	
	
	public String insertOrder(String code, String id, String name, String email, String address, String total) 
	{ 
		String output = ""; 
		
		try
		{ 
			Connection con = connect();
			
			if (con == null) 
			{return "Error while connecting to the database for inserting."; }
			
			// create a prepared statement
			String query = " insert into orders (`orderID`,`orderCode`,`customerID`,`customerName`,`customerEmail`,`customerAddress`,`orderTotalAmount`)"
							+ " values (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			 // binding values
			 preparedStmt.setInt(1, 0); 
			 preparedStmt.setString(2, code); 
			 preparedStmt.setString(3, id);
			 preparedStmt.setString(4, name);  
			 preparedStmt.setString(5, email);
			 preparedStmt.setString(6, address);
			 preparedStmt.setDouble(7, Double.parseDouble(total));
			 
			 // execute the statement3
			 preparedStmt.execute(); 
			 con.close();
			 
			 output = "Inserted successfully"; 
		} 
		catch (Exception e) 
		{ 
			 output = "Error while inserting the order."; 
			 System.err.println(e.getMessage()); 
		} 
		return output; 
	}

}
