package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Twitter;
import service.TwitterEJB;

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
	public Twitter getTwitter() {
		return twitter;
	}
	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}
}
