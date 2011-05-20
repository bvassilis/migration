package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TimesRead database table.
 * 
 */
@Entity
public class TimesRead implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ArticleID")
	private int articleID;
	@Id
	@Column(name="TimesID")
	private int timesID;

	@Column(name="TimesRead")
	private int timesRead;

	@Column(name="Type")
	private String type;

    public TimesRead() {
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

	public int getTimesRead() {
		return this.timesRead;
	}

	public void setTimesRead(int timesRead) {
		this.timesRead = timesRead;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}