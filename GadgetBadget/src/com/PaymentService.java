package com;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*;

import model.Payment;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;

@Path("/Payments")
public class PaymentService {
	
	Payment PayObj = new Payment();
	
	//method to read a payment details
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readPayment() 
	 { 
	 return PayObj.readPayment(); 
	 }
	
	//method to insert a payment details
			@POST
			@Path("/")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.TEXT_PLAIN)
			public String insertPayment(@FormParam("app_Code") String app_Code, @FormParam("cardType") String cardType,
					@FormParam("nameOnCard") String nameOnCard, @FormParam("cardno") String cardno,
					@FormParam("phone") String phone, @FormParam("expdate") String expdate, @FormParam("amount") String amount) 
			{
					String output = PayObj.insertPayment(app_Code, cardType, nameOnCard, cardno, phone, expdate, amount);
					return output;
			}
			
			
			//method to update the status details	
			@PUT
			@Path("/")
			@Consumes(MediaType.APPLICATION_JSON)
			@Produces(MediaType.TEXT_PLAIN)
			public String updatePayment(String payData) {

				//Convert the input string to a JSON object
				JsonObject PaymentObj = new JsonParser().parse(payData).getAsJsonObject();

				//Read the values from the JSON object
				String paymentID = PaymentObj.get("paymentID").getAsString();
				String app_Code = PaymentObj.get("app_Code").getAsString();
				String cardType = PaymentObj.get("cardType").getAsString();
				String nameOnCard = PaymentObj.get("nameOnCard").getAsString();
				String cardno = PaymentObj.get("cardno").getAsString();
				String phone = PaymentObj.get("phone").getAsString();
				String expdate = PaymentObj.get("expdate").getAsString();
				String amount = PaymentObj.get("amount").getAsString();
				String status = PaymentObj.get("status").getAsString();

				String output = PayObj.updatePayment(paymentID, app_Code, cardType, nameOnCard, cardno, phone, expdate, amount,
						status);
				return output;
			}

}
