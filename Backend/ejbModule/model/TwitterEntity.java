package model;

import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="tweets")
public class TwitterEntity {

	@Id
	@GeneratedValue(generator = "tweets_seq")
	@SequenceGenerator(initialValue = 0001,name="tweets_seq")
	private int tweetID;
	private String tweetBody;
	private Timestamp timeStamp;
	
	public int getTweetID() {
		return tweetID;
	}
	public void setTweetID(short tweetID) {
		this.tweetID = tweetID;
	}
	public String getTweetBody() {
		return tweetBody;
	}
	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		Date date = new Date();
		long time = date.getTime();
		
		Timestamp ts = new Timestamp(time);
		this.timeStamp = ts;
	}
	
}
