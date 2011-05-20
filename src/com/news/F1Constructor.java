package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the F1Constructors database table.
 * 
 */
@Entity
@Table(name="F1Constructors")
public class F1Constructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ArticleID")
	private int articleID;

	@Column(name="CarPhoto")
	private String carPhoto;
	@Id
	@Column(name="ConstructorID")
	private int constructorID;

	@Column(name="ConstructorName")
	private String constructorName;

	@Column(name="ConstructorName_en")
	private String constructorName_en;

    public F1Constructor() {
    }

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public String getCarPhoto() {
		return this.carPhoto;
	}

	public void setCarPhoto(String carPhoto) {
		this.carPhoto = carPhoto;
	}

	public int getConstructorID() {
		return this.constructorID;
	}

	public void setConstructorID(int constructorID) {
		this.constructorID = constructorID;
	}

	public String getConstructorName() {
		return this.constructorName;
	}

	public void setConstructorName(String constructorName) {
		this.constructorName = constructorName;
	}

	public String getConstructorName_en() {
		return this.constructorName_en;
	}

	public void setConstructorName_en(String constructorName_en) {
		this.constructorName_en = constructorName_en;
	}

}