package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Ratings database table.
 * 
 */
@Entity
@Table(name="Ratings")
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ArticleID")
	private int articleID;
	@Id
	@Column(name="RatingID")
	private int ratingID;

	private long ratings;

	private long ratingsSum;

	@Column(name="Type")
	private String type;

    public Rating() {
    }

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public int getRatingID() {
		return this.ratingID;
	}

	public void setRatingID(int ratingID) {
		this.ratingID = ratingID;
	}

	public long getRatings() {
		return this.ratings;
	}

	public void setRatings(long ratings) {
		this.ratings = ratings;
	}

	public long getRatingsSum() {
		return this.ratingsSum;
	}

	public void setRatingsSum(long ratingsSum) {
		this.ratingsSum = ratingsSum;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}