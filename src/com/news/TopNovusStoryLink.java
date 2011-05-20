package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TopNovusStoryLinks database table.
 * 
 */
@Entity
@Table(name="TopNovusStoryLinks")
public class TopNovusStoryLink implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ArticleID")
	private int articleID;

    public TopNovusStoryLink() {
    }

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

}