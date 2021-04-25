package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DB_Connection;

public class Payment {
	
	//Insert new payment details
		public String insertPayment(String app_code, String ctype, String name, String cardno, String pho, String expdate,
				String amount, String status) {
			String output = "";
			try {
				DB_Connection obj_DB_Connection= new DB_Connection();
				Connection con = obj_DB_Connection.connect();

				if (con == null) {
					return "Error while connecting to the database for inserting.";
				}
				// create a prepared statement
				String query = " insert into payment (`paymentID`,`app_Code`,`cardType`,`nameOnCard`,`cardno`,`phone`,`expdate`,`amount`)"
						+ " values (?,?, ?, ?, ?, ?, ?, ?)";
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

}
