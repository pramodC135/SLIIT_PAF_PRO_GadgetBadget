package com;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*;

import model.Project;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Projects")
public class ProjectService {
	
	Project projectObj = new Project(); 
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readProjects() 
	{
	  
		return projectObj.readProjects(); 
	}
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertProject(@FormParam("projectCode") String projectCode, 
							 @FormParam("projectName") String projectName, 
							 @FormParam("projectPrice") String projectPrice, 
							 @FormParam("projectDesc") String projectDesc,
							 @FormParam("projectBy") String projectBy,
							 @FormParam("projectCtg") String projectCtg) 
	{ 
		String output = projectObj.insertProject(projectCode, projectName, projectPrice, projectDesc, projectBy, projectCtg); 
		return output; 
	}
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateProject(String projectData) 
	{ 
		//Convert the input string to a JSON object 
		 JsonObject projectObject = new JsonParser().parse(projectData).getAsJsonObject(); 
		 
		//Read the values from the JSON object
		 String projectID = projectObject.get("projectID").getAsString(); 
		 String projectCode = projectObject.get("projectCode").getAsString(); 
		 String projectName = projectObject.get("projectName").getAsString(); 
		 String projectPrice = projectObject.get("projectPrice").getAsString(); 
		 String projectDesc = projectObject.get("projectDesc").getAsString();
		 String projectBuy = projectObject.get("projectBy").getAsString(); 
		 String projectCtg = projectObject.get("projectCtg").getAsString(); 
		 
		 String output = projectObj.updateProject(projectID, projectCode, projectName, projectPrice, projectDesc, projectBy, projectCtg); 
		 return output; 
	}
}
