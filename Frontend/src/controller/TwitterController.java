package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Twitter;
import service.TwitterEJB;
import twitter4j.TwitterException;

@ManagedBean(name = "twittercontroller")
@SessionScoped
public class TwitterController {

	@EJB
	TwitterEJB twitterservice;
	
	@ManagedProperty(value="#{twitter}")
	private Twitter twitter;
	// calls the bean at the back end
	public void sendTweet() {
//		System.out.println("Tweet sent");
		twitterservice.sendTweet(twitter.getEntity());
	}
	public void sendDM() {
//		twitterservice.sendDirectMessages(twitter.getEntity().getTweetBody());
		try {
			System.out.println("you clicked send direct message");
			twitterservice.sendDirectMessages(twitter.getEntity().getTweetBody());
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("An error occured " + e);
		}
	}
	public Twitter getTwitter() {
		return twitter;
	}
	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}
}
