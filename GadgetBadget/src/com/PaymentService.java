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

public class PaymentService {
	
	Payment PayObj = new Payment();
	
	//method to insert a payment details
			@POST
			@Path("/")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.TEXT_PLAIN)
			public String insertPaymentDetails(@FormParam("app_code") String app_Id, @FormParam("cardType") String cardType,
					@FormParam("nameOnCard") String nameOnCard, @FormParam("cardno") String cardno,
					@FormParam("phone") String phone, @FormParam("expdate") String expdate, @FormParam("amount") String amount,
					@FormParam("status") String status) {
					String output = PayObj.insertPayment(app_Id, cardType, nameOnCard, cardno, phone, expdate, amount,
						status);
				return output;
			}

}
