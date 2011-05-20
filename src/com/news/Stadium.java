package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Stadiums database table.
 * 
 */
@Entity
@Table(name="Stadiums")
public class Stadium implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ArticleID")
	private int articleID;
	@Id
	@Column(name="StadiumID")
	private int stadiumID;

	@Column(name="StadiumName")
	private String stadiumName;

	@Column(name="StadiumName_en")
	private String stadiumName_en;

	@Column(name="StadiumPlaceID")
	private int stadiumPlaceID;

    public Stadium() {
    }

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public int getStadiumID() {
		return this.stadiumID;
	}

	public void setStadiumID(int stadiumID) {
		this.stadiumID = stadiumID;
	}

	public String getStadiumName() {
		return this.stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public String getStadiumName_en() {
		return this.stadiumName_en;
	}

	public void setStadiumName_en(String stadiumName_en) {
		this.stadiumName_en = stadiumName_en;
	}

	public int getStadiumPlaceID() {
		return this.stadiumPlaceID;
	}

	public void setStadiumPlaceID(int stadiumPlaceID) {
		this.stadiumPlaceID = stadiumPlaceID;
	}

}