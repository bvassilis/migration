package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Japan2006PageOrder database table.
 * 
 */
@Entity
public class Japan2006PageOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ArticleID")
	private int articleID;

	@Column(name="ArticlePhoto")
	private String articlePhoto;

	@Column(name="ArticleTitle")
	private String articleTitle;

	@Column(name="Japan2006Order")
	private int japan2006Order;
	@Id
	@Column(name="Japan2006OrderID")
	private int japan2006OrderID;

    public Japan2006PageOrder() {
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

	public int getJapan2006Order() {
		return this.japan2006Order;
	}

	public void setJapan2006Order(int japan2006Order) {
		this.japan2006Order = japan2006Order;
	}

	public int getJapan2006OrderID() {
		return this.japan2006OrderID;
	}

	public void setJapan2006OrderID(int japan2006OrderID) {
		this.japan2006OrderID = japan2006OrderID;
	}

}