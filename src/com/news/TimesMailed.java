package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TimesMailed database table.
 * 
 */
@Entity
public class TimesMailed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ArticleID")
	private int articleID;
	@Id
	@Column(name="TimesID")
	private int timesID;

	@Column(name="TimesMailed")
	private int timesMailed;

	@Column(name="Type")
	private String type;

    public TimesMailed() {
    }

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public int getTimesID() {
		return this.timesID;
	}

	public void setTimesID(int timesID) {
		this.timesID = timesID;
	}

	public int getTimesMailed() {
		return this.timesMailed;
	}

	public void setTimesMailed(int timesMailed) {
		this.timesMailed = timesMailed;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}