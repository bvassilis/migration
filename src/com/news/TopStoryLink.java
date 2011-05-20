package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TopStoryLinks database table.
 * 
 */
@Entity
@Table(name="TopStoryLinks")
public class TopStoryLink implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ArticleID")
	private int articleID;

    public TopStoryLink() {
    }

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

}