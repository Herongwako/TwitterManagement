package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.TwitterEntity;
import service.TwitterEJB;

@Path("/MyRestService")
@ApplicationPath("/resources")
@ApplicationScoped
public class RestService extends Application{

	//http://localhost:8080/RestExample/resources/MyRestService/sayHello
	//http://localhost:8080/Frontend/resources/MyRestService/tweets
	@EJB
	TwitterEJB twitterservice;
	@GET
	@Path("/sayHello")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getHelloMsg() {
		List<String> arrayList = new ArrayList<>();
		arrayList = twitterservice.getNames();
		return arrayList;
	}
	@GET
	@Path("/echo")
	public Response getEchoMsg(@QueryParam("message") String msg) {
		return Response.ok("Your message was : " + msg).build();
	}
	@GET
	@Path("/tweets")
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<TwitterEntity> getAllTweets(){
		System.out.println("Post man");
		System.out.println(twitterservice.findAll());
//		String json = Gson().tojson(twitterservice.findAll());
		return twitterservice.findAll();
	}
	
}
