package com.news;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the Comments database table.
 * 
 */
@Entity
@Table(name="Comments")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ArticleID")
	private int articleID;

	@Column(name="CommentBody")
	private String commentBody;

	@Column(name="CommentDate")
	private Timestamp commentDate;
	@Id
	@Column(name="CommentID")
	private int commentID;

	@Column(name="Offensive")
	private boolean offensive;

	@Column(name="UserID")
	private int userID;

    public Comment() {
    }

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public String getCommentBody() {
		return this.commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public Timestamp getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	public int getCommentID() {
		return this.commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public boolean getOffensive() {
		return this.offensive;
	}

	public void setOffensive(boolean offensive) {
		this.offensive = offensive;
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}