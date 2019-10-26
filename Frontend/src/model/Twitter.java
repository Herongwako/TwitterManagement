package model;

import java.sql.Timestamp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.annotation.XmlRootElement;

@ManagedBean(name = "twitter")
@SessionScoped
@XmlRootElement
public class Twitter {

	private String tweetBody;
	private Timestamp timeStamp;
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTweetBody() {
		return tweetBody;
	}
	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}
	public TwitterEntity getEntity() {
		TwitterEntity twitterentity = new TwitterEntity();
		twitterentity.setTweetBody(tweetBody);
		twitterentity.setTimeStamp(timeStamp);
		return twitterentity;
	}

}
