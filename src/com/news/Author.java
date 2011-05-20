package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Authors database table.
 * 
 */
@Entity
@Table(name="Authors")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="AuthorID")
	private int authorID;

	@Column(name="AuthorName")
	private String authorName;

	@Column(name="BlogID")
	private int blogID;

	@Column(name="Photo")
	private String photo;

	@Column(name="Profile")
	private String profile;

    public Author() {
    }

	public int getAuthorID() {
		return this.authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getBlogID() {
		return this.blogID;
	}

	public void setBlogID(int blogID) {
		this.blogID = blogID;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}