package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DB_Connection;

public class Payment {
	
	//Retrieve payment details 
		public String readPayment() {
			
			String output = "";
			try {
				
				DB_Connection obj_DB_Connection= new DB_Connection();
				Connection con = obj_DB_Connection.connect();
				
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}
				// Prepare the html table to be displayed
				output = "<table border=\"1\"><tr> <th>App Code</th> <th>CardType</th> <th>Name</th> <th>CardNo</th> <th>Phone</th ><th>Exp_date</th> <th>Amount</th> </tr>";
				String query = "select * from payment";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				// iterate through the rows in the result set
				while (rs.next()) {
					String paymentID = Integer.toString(rs.getInt("paymentID"));
					String app_Code = rs.getString("app_Code");
					String cardType = rs.getString("cardType");
					String nameOnCard = rs.getString("nameOnCard");
					String cardno = Integer.toString(rs.getInt("cardno"));
					String phone = rs.getString("phone");
					String expdate = rs.getString("expdate");
					String amount = Double.toString(rs.getDouble("amount"));
					
					// Add into the html table
					output += "<tr><td>" + app_Code + "</td>";
					output += "<td>" + cardType + "</td>";
					output += "<td>" + nameOnCard + "</td>";
					output += "<td>" + cardno + "</td>";
					output += "<td>" + phone + "</td>";
					output += "<td>" + expdate + "</td>";
					output += "<td>" + amount + "</td>";
					
				}
				con.close();
				// Complete the html table
				output += "</table>";
			} catch (Exception e) {
				output = "Error while reading the card details.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
	
	//Insert new payment details
		public String insertPayment(String app_code, String ctype, String name, String cardno, String pho, String expdate, String amount) {
			String output = "";
			try {
				DB_Connection obj_DB_Connection= new DB_Connection();
				Connection con = obj_DB_Connection.connect();

				if (con == null) {
					return "Error while connecting to the database for inserting.";
				}
				// create a prepared statement
				String query = " insert into payment (`paymentID`,`app_Code`,`cardType`,`nameOnCard`,`cardno`,`phone`,`expdate`,`amount`)" + " values (?,?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, app_code);
				preparedStmt.setString(3, ctype);
				preparedStmt.setString(4, name);
				preparedStmt.setInt(5, Integer.parseInt(cardno));
				preparedStmt.setString(6, pho);
				preparedStmt.setString(7, expdate);
				preparedStmt.setDouble(8, Double.parseDouble(amount));
				

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Inserted successfully";
			} catch (Exception e) {
				output = "Error while inserting the card details.";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		
		//Update the status of payments
		public String updatePayment(String paymentID, String app_Code, String ctype, String name, String cardno, String pho, String expdate, String amount) {
			String output = "";
			try {
				DB_Connection obj_DB_Connection= new DB_Connection();
				Connection con = obj_DB_Connection.connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
				// create a prepared statement
				String query = "UPDATE payment SET app_Code=?,cardType=?,nameOnCard=?,cardno=?,phone=?,expdate=?,amount=? WHERE paymentID=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setString(1, app_Code);
				preparedStmt.setString(2, ctype);
				preparedStmt.setString(3, name);
				preparedStmt.setInt(4, Integer.parseInt(cardno));
				preparedStmt.setString(5, pho);
				preparedStmt.setString(6, expdate);
				preparedStmt.setDouble(7, Double.parseDouble(amount));
				preparedStmt.setInt(8, Integer.parseInt(paymentID));

				// execute the statement
				preparedStmt.execute();
				con.close();
				output = "Updated successfully";
			} catch (Exception e) {
				output = "Error while updating the card details.";
				System.err.println(e.getMessage());
			}
			return output;
		}

}
