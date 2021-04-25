package com;


//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 

//For JSON
import com.google.gson.*;

import model.Order;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Orders") 
public class OrderService
	{ 
			 Order orderObj = new Order();
			 
			 @GET
			 @Path("/") 
			 @Produces(MediaType.TEXT_HTML) 
			 public String readOrders() 
			 { 
				 return orderObj.readOrders();
			 } 
			 
			 @POST
			 @Path("/") 
			 @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
			 @Produces(MediaType.TEXT_PLAIN) 
			 public String insertItem(@FormParam("orderCode") String orderCode, 
									  @FormParam("customerID") String customerID, 
									  @FormParam("customerName") String customerName,
									  @FormParam("customerEmail") String customerEmail,
									  @FormParam("customerAddress") String customerAddress,
									  @FormParam("orderTotalAmount") String orderTotalAmount
									  ) 
			 { 
				 String output = orderObj.insertOrder(orderCode, customerID, customerName, customerEmail, customerAddress, orderTotalAmount ); 
				 return output; 
			 }
}