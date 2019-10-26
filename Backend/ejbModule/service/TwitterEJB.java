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

	public void sendTweet(TwitterEntity twitterEntity) {
		//post on twitter
		String OAuthConsumerKey = "dzAFOmJ5DMb9QlGdjprK8gEeY";
		String OAuthConsumerSecret = "pBpmoHaB1uMiM0es9TpQkRQ9ImfIsq4L8ABW0uDPXyAfBZfFq9";
		String OAuthAccessToken ="1182075984658468866-H5WK92bMcJET68a41lJnXGee3I04V5";
		String OAuthAccessTokenSecret = "rLUrxBkoPRhO8ImJ5zkk5G81vSWoPF6cjn2glwy6wIfra";

	       ConfigurationBuilder cb = new ConfigurationBuilder();
	       cb.setDebugEnabled(true)
	           .setOAuthConsumerKey(OAuthConsumerKey)
	           .setOAuthConsumerSecret(OAuthConsumerSecret)
	           .setOAuthAccessToken(OAuthAccessToken)
	           .setOAuthAccessTokenSecret(OAuthAccessTokenSecret);

	       try 
	       {
	          TwitterFactory factory = new TwitterFactory(cb.build());
	          Twitter twitter = factory.getInstance();
	          System.out.println(twitter.getScreenName());
//	          Status status = twitter.updateStatus(twitterEntity.getTweetBody());
	          
//	          System.out.println("Successfully updated the status to [" + status.getText() + "].");
	           }catch (Exception te) {
	              te.printStackTrace();
	              System.exit(-1);
	           }
		
		//post to DB
		if(twitterEntity.getTweetBody().isEmpty()) {
			System.out.println("nothing to post");
		}else {
			System.out.println("Message posted = " + twitterEntity.getTweetBody());
			em.persist(twitterEntity);
			System.out.println("=======================Tweet saved to DB=============");
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<TwitterEntity> findAll(){
		System.out.println("===============");
//		System.out.println(em.createQuery("SELECT tweetBody FROM tweets").getResultList());

//		List<TwitterEntity> userTweets = new ArrayList<>();
//		userTweets = em.createQuery("SELECT tweetBody FROM tweets").getResultList();
//		System.out.println(userTweets);
		return em.createQuery("SELECT tweetID,tweetBody, timeStamp FROM tweets").getResultList();

	}
	
	public List<String> getNames(){
		List<String> userTweets = new ArrayList<String>();
//		// Create JSON Array 
//		JSONArray languages = new JSONArray();
//		languages.add("Russian");
//		languages.add("English");
//		languages.add("French");

//		System.out.println(languages.toString());
		userTweets.add("Heroism");
		userTweets.add("Heroism ngwako");
		userTweets.add("Heroism Vho ngwako weee");
		userTweets.add("Mathekga H");
		for (int i=0; i< userTweets.size();i++) {
			System.out.println(userTweets.get(i));
		}
		System.out.println("get names function");
		return userTweets;
	}
}
//return em.createQuery("SELECT * FROM adh401tds.tweets;",TwitterEntity.class).getResultList();
//return (List<TwitterEntity>) em.createQuery("SELECT tweetBody FROM tweets");
//Date date = new Date();
//long time = date.getTime();
//
//Timestamp ts = new Timestamp(time);
//TwitterEntity m1 = new TwitterEntity();
//TwitterEntity m2 = new TwitterEntity();
//List<TwitterEntity> list = new ArrayList<>();
//list.add(m1);
//list.add(m2);
//return list;

/*
 * 		System.out.println(em.createQuery("SELECT tweetBody FROM tweets"));
		List<TwitterEntity> userTweets = new ArrayList<>();
		userTweets = em.createQuery("SELECT tweetID,propertyValue,timeStamp,tweetBody FROM tweets").getResultList();
		System.out.println(userTweets);
		for (int i=0; i< userTweets.size();i++) {
			System.out.println(userTweets.get(i));
		}
		System.out.println("=======================Tweet saved to DB=============");
 * */
//public static void postTweet() throws TwitterException{
//ConfigurationBuilder configurationbuilder = new ConfigurationBuilder();
//configurationbuilder.setDebugEnabled(true)
//.setOAuthConsumerKey("dzAFOmJ5DMb9QlGdjprK8gEeY")
//.setOAuthConsumerSecret("pBpmoHaB1uMiM0es9TpQkRQ9ImfIsq4L8ABW0uDPXyAfBZfFq9")
//.setOAuthAccessToken("1182075984658468866-H5WK92bMcJET68a41lJnXGee3I04V5")
//.setOAuthAccessTokenSecret("rLUrxBkoPRhO8ImJ5zkk5G81vSWoPF6cjn2glwy6wIfra");
//
//TwitterFactory tf = new TwitterFactory(configurationbuilder.build());
//twitter4j.Twitter twitter = tf.getInstance();
//
//List<Status> status = twitter.getHomeTimeline();
//for(Status s:status) {
//	System.out.println(s.getUser().getName()+ " "+ s.getText());
//}
//
//}