package com;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*;



//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;

@Path("/Orders")
public class OrderService {
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readOrders() 
	{ 
		return orderObj.readOrders(); 
	}

}