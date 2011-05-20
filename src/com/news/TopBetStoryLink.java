package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TopBetStoryLinks database table.
 * 
 */
@Entity
@Table(name="TopBetStoryLinks")
public class TopBetStoryLink implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ArticleID")
	private int articleID;

    public TopBetStoryLink() {
    }

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

}