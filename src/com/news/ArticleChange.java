package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ArticleChanges database table.
 * 
 */
@Entity
@Table(name="ArticleChanges")
public class ArticleChange implements Serializable {
	private static final long serialVersionUID = 1L;

	private String articleDate;
	@Id
	private int articleID;

	private int articlesChangeID;

	private boolean pending;

	private String placeName;

	private String subSectionFile;

	private String subSectionTagFile;

	@Column(name="Tags")
	private String tags;

    public ArticleChange() {
    }

	public String getArticleDate() {
		return this.articleDate;
	}

	public void setArticleDate(String articleDate) {
		this.articleDate = articleDate;
	}

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public int getArticlesChangeID() {
		return this.articlesChangeID;
	}

	public void setArticlesChangeID(int articlesChangeID) {
		this.articlesChangeID = articlesChangeID;
	}

	public boolean getPending() {
		return this.pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	public String getPlaceName() {
		return this.placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getSubSectionFile() {
		return this.subSectionFile;
	}

	public void setSubSectionFile(String subSectionFile) {
		this.subSectionFile = subSectionFile;
	}

	public String getSubSectionTagFile() {
		return this.subSectionTagFile;
	}

	public void setSubSectionTagFile(String subSectionTagFile) {
		this.subSectionTagFile = subSectionTagFile;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}