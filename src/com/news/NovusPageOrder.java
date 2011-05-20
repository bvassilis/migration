package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the NovusPageOrder database table.
 * 
 */
@Entity
public class NovusPageOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="ArticleID")
	private int articleID;

	@Column(name="ArticlePhoto")
	private String articlePhoto;

	@Column(name="ArticleTitle")
	private String articleTitle;

	@Column(name="HomeOrder")
	private int homeOrder;
	@Id
	@Column(name="HomeOrderID")
	private int homeOrderID;

    public NovusPageOrder() {
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

	public int getHomeOrder() {
		return this.homeOrder;
	}

	public void setHomeOrder(int homeOrder) {
		this.homeOrder = homeOrder;
	}

	public int getHomeOrderID() {
		return this.homeOrderID;
	}

	public void setHomeOrderID(int homeOrderID) {
		this.homeOrderID = homeOrderID;
	}

}