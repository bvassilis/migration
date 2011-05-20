package com.news;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the F1RaceSchedule database table.
 * 
 */
@Entity
public class F1RaceSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ArticleID")
	private int articleID;
	@Id
	@Column(name="RaceCircuitID")
	private int raceCircuitID;

	@Column(name="RaceDate")
	private Timestamp raceDate;

	@Column(name="RaceID")
	private int raceID;

	@Column(name="Season")
	private int season;

    public F1RaceSchedule() {
    }

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public int getRaceCircuitID() {
		return this.raceCircuitID;
	}

	public void setRaceCircuitID(int raceCircuitID) {
		this.raceCircuitID = raceCircuitID;
	}

	public Timestamp getRaceDate() {
		return this.raceDate;
	}

	public void setRaceDate(Timestamp raceDate) {
		this.raceDate = raceDate;
	}

	public int getRaceID() {
		return this.raceID;
	}

	public void setRaceID(int raceID) {
		this.raceID = raceID;
	}

	public int getSeason() {
		return this.season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

}