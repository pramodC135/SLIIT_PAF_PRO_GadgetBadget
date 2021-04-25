package model;

import java.sql.*;

import util.DB_Connection;

public class Order {
	
	public String insertOrder(String orderCode, String customerID, String customerName, String customerEmail, String customerAddress, String orderTotalAmount) 
	 { 
		String output = ""; 
		
	 try
	 { 
		 
		 	DB_Connection obj_DB_Connection= new DB_Connection();
			Connection con = obj_DB_Connection.connect();
		 
		 if (con == null) 
	 	{
		 return "Error while connecting to the database for inserting."; 
	 	} 
	 
	 	// create a prepared statement
	 	String query = " insert into order (`orderID`,`orderCode`,`customerID`,`customerName`,`customerEmail`, `customerAddress`, `orderTotalAmount`)"+ " values (?, ?, ?, ?, ?, ?, ?)"; 
	 	PreparedStatement preparedStmt = con.prepareStatement(query);
	 
	 	// binding values
	 	preparedStmt.setInt(1, 0); 
	 	preparedStmt.setString(2, orderCode); 
	 	preparedStmt.setString(3, customerID); 
	 	preparedStmt.setString(5, customerName);
	 	preparedStmt.setString(5, customerEmail);
	 	preparedStmt.setString(5, customerAddress);
	 	preparedStmt.setDouble(4, Double.parseDouble(orderTotalAmount)); 
	 	
	 
	 	// execute the statement
	 	preparedStmt.execute(); 
	 	con.close(); 
	 	output = "Inserted successfully"; 
	 	} 
	 
	 	catch (Exception e) 
	 	{ 
	 		
	 		output = "Error while inserting the item."; 
	 		System.err.println(e.getMessage()); 
	 	}
	 
	 	return output; 
	 } 
	
	
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
							 "<th>Customer Name</th>" + 
							 "<th>Customer Email</th>" +
							 "<th>Customer Address</th>" +
							 "<th>Order Total Amount</th>" +
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
							 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
							 + "<td><form method='post' action='items.jsp'>"
							 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
							 + "<input name='itemID' type='hidden' value='" + orderID 
							 + "'>" + "</form></td></tr>"; 
					 } 
					 con.close(); 
					 // Complete the html table
					 output += "</table>"; 
			 } 
			 catch (Exception e) 
			 { 
					 output = "Error while reading the items."; 
					 System.err.println(e.getMessage()); 
			 } 
			 return output; 
	 }
	
	public String updateOrder(String ID, String code, String id, String name, String email, String address, String total)
	{ 
		String output = ""; 
		
		try
		{ 
				DB_Connection obj_DB_Connection= new DB_Connection();
				Connection con = obj_DB_Connection.connect();
				
			 if (con == null) 
			 {return "Error while connecting to the database for updating."; }
			 
			 // create a prepared statement
			 String query = "UPDATE order SET orderCode=?, customerID=?, customerName=?, customerEmail=?, customerAddress=?, orderTotalAmount=? WHERE orderID=?";
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
					 // binding values
					 preparedStmt.setString(1, code); 
					 preparedStmt.setString(2, id);
					 preparedStmt.setString(3, name);
					 preparedStmt.setString(4, email);
					 preparedStmt.setString(5, address);
					 preparedStmt.setString(6, total); 
					 preparedStmt.setInt(5, Integer.parseInt(ID));
					 
					 // execute the statement
					 preparedStmt.execute(); 
					 con.close(); 
			 
			 output = "Updated successfully"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while updating the order."; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	}
	
	public String deleteOrder(String orderID) 
	{ 
		String output = ""; 
		
		try
		{ 
				DB_Connection obj_DB_Connection= new DB_Connection();
				Connection con = obj_DB_Connection.connect();
			
			 if (con == null) 
			 {return "Error while connecting to the database for deleting."; } 
			 
			 // create a prepared statement
			 String query = "delete from orders where orderID=?";
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(orderID)); 
			 // execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 
			 output = "Deleted successfully"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while deleting the order."; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	}
	
}
