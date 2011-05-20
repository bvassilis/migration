package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the WC2006PageOrder database table.
 * 
 */
@Entity
public class WC2006PageOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ArticleID")
	private int articleID;

	@Column(name="ArticlePhoto")
	private String articlePhoto;

	@Column(name="ArticleTitle")
	private String articleTitle;

	private int WC2006Order;

	private int WC2006OrderID;

    public WC2006PageOrder() {
    }

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public String getArticlePhoto() {
		return this.articlePhoto;
	}

	public void setArticlePhoto(String articlePhoto) {
		this.articlePhoto = articlePhoto;
	}

	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public int getWC2006Order() {
		return this.WC2006Order;
	}

	public void setWC2006Order(int WC2006Order) {
		this.WC2006Order = WC2006Order;
	}

	public int getWC2006OrderID() {
		return this.WC2006OrderID;
	}

	public void setWC2006OrderID(int WC2006OrderID) {
		this.WC2006OrderID = WC2006OrderID;
	}

}