package controller;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import model.TwitterEntity;
import service.TwitterEJB;

@Path("/Service")
@ApplicationPath("/resources")
@ApplicationScoped
public class RestServiceController extends Application{

	//http://localhost:8080/Frontend/resources/Service/tweets
	@EJB
	TwitterEJB twitterservice;

	@GET
	@Path("/tweets")
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<TwitterEntity> getAllTweets(){
		System.out.println("Post man");
		System.out.println(twitterservice.findAll());
		return twitterservice.findAll();
	}
	
}
