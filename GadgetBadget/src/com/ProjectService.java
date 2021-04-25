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
							 @FormParam("projectBuy") String projectBuy,
							 @FormParam("projectCtg") String projectCtg) 
	{ 
		String output = projectObj.insertProject(projectCode, projectName, projectPrice, projectDesc, projectBuy, projectCtg); 
		return output; 
	}
}
