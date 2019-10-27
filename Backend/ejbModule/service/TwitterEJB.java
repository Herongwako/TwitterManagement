package service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.TwitterEntity;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.*;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

@Stateless
@LocalBean
@ApplicationScoped
public class TwitterEJB {

	@PersistenceContext
	private EntityManager em;

	public TwitterEJB() {
	}
	public static ConfigurationBuilder configBuilder() {
		// making it easy to use the configuration builder
		String OAuthConsumerKey = "rflSmFmm5yQ96xWk0r9zLRnAq";
		String OAuthConsumerSecret = "h4FV2c2WxtIh7GQkBE2nWqfWQzTRo77Du4caAj5KxnwLSUAJFi";
		String OAuthAccessToken ="1182075984658468866-829vkgiRDn2pcaeHeS2kNw3j9PwRhX";
		String OAuthAccessTokenSecret = "kOl6ctiieF82GFs4m2mjcJ50V04FPg5kydPmJIq61vDXz";
		
	       ConfigurationBuilder cb = new ConfigurationBuilder();
	       cb.setDebugEnabled(true)
	           .setOAuthConsumerKey(OAuthConsumerKey)
	           .setOAuthConsumerSecret(OAuthConsumerSecret)
	           .setOAuthAccessToken(OAuthAccessToken)
	           .setOAuthAccessTokenSecret(OAuthAccessTokenSecret);
	       return cb;
	}
	public void sendDirectMessages(String message) 
			  throws TwitterException {
		
	    	TwitterFactory tf = new TwitterFactory(configBuilder().build());
	    	twitter4j.Twitter t4w =  tf.getInstance();
	    	
	    	DirectMessage msg = t4w.sendDirectMessage("@AdhLecturer",message);

//	    	DirectMessage msg = t4w.sendDirectMessage("@herongwako",message);
//	    	DirectMessage msg = t4w.sendDirectMessage("@209152100_ADH", message);
	       System.out.println("Message sent " + msg);
	}
	public void sendTweet(TwitterEntity twitterEntity) {
		//post on twitter
	
		//post to DB
		if(twitterEntity.getTweetBody().isEmpty()) {
			System.out.println("nothing to post");
		}else {
		       try 
		       {
		          TwitterFactory factory = new TwitterFactory(configBuilder().build());
		          Twitter twitter = factory.getInstance();
		          System.out.println(twitter.getScreenName());
		          //update status
		          Status status = twitter.updateStatus(twitterEntity.getTweetBody());
		          System.out.println("Successfully updated the status to [" + status.getText() + "].");
		           }catch (TwitterException te) {
		              te.printStackTrace();
		              System.exit(-1);
		       }
			System.out.println("Message posted = " + twitterEntity.getTweetBody());
			em.persist(twitterEntity);
			System.out.println("=======================Tweet saved to DB=============");
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<TwitterEntity> findAll(){
		return em.createQuery("SELECT tweetID,tweetBody, timeStamp FROM tweets").getResultList();

	}
}