package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ArticlePages database table.
 * 
 */
@Entity
@Table(name="ArticlePages")
public class ArticlePage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ArticleID")
	private int articleID;

	@Column(name="PageBody")
	private String pageBody;
	@Id
	@Column(name="PageID")
	private int pageID;

	@Column(name="PageNo")
	private int pageNo;

    public ArticlePage() {
    }

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public String getPageBody() {
		return this.pageBody;
	}

	public void setPageBody(String pageBody) {
		this.pageBody = pageBody;
	}

	public int getPageID() {
		return this.pageID;
	}

	public void setPageID(int pageID) {
		this.pageID = pageID;
	}

	public int getPageNo() {
		return this.pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}