package com;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*;

import model.User;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;

@Path("/Users")
public class UserService {
	
User userObj = new User();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readUsers()
	{
		return userObj.readUsers();
	}
	
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertUser(@FormParam("userCode") String userCode, 
							 @FormParam("username") String username, 
							 @FormParam("userPwd") String userPwd, 
							 @FormParam("userEmail") String userEmail,
							 @FormParam("userRole") String userRole,
							 @FormParam("userFname") String userFname,
							 @FormParam("userLname") String userLname,
							 @FormParam("userAddress") String userAddress,
							 @FormParam("userBod") String userBod)
							  
	{ 
			String output = userObj.insertUser(userCode, username, userPwd, userEmail, userRole, userFname, userLname, userAddress, userBod); 
			
			return output; 
	}
	
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateUser(String userData) 
	{ 
			//Convert the input string to a JSON object 
			 JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject(); 
			 
			//Read the values from the JSON object
			 String userID = userObject.get("userID").getAsString(); 
			 String userCode = userObject.get("userCode").getAsString(); 
			 String username = userObject.get("username").getAsString(); 
			 String userPwd = userObject.get("userPwd").getAsString();
			 String userEmail = userObject.get("userEmail").getAsString();
			 String userRole = userObject.get("userRole").getAsString();
			 String userFname = userObject.get("userFname").getAsString();
			 String userLname = userObject.get("userLname").getAsString();
			 String userAddress = userObject.get("userAddress").getAsString();
			 String userBod = userObject.get("userBod").getAsString();
			 
			 
			 String output = userObj.updateUser(userID, userCode, username, userPwd, userEmail, userRole, userFname, userLname, userAddress, userBod); 
			 
			 return output; 
	}
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteItem(String userData) 
	{ 
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(userData, "", Parser.xmlParser()); 
	 
	//Read the value from the element <itemID>
	 String userID = doc.select("userID").text(); 
	 String output = userObj.deleteUser(userID); 
	return output; 
	}

}
