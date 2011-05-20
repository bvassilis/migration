package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Seasons database table.
 * 
 */
@Entity
@Table(name="Seasons")
public class Season implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SeasonID")
	private int seasonID;

	@Column(name="SeasonStartYear")
	private int seasonStartYear;

	@Column(name="TwoYearSpread")
	private boolean twoYearSpread;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="season")
	private List<Match> matches;

    public Season() {
    }

	public int getSeasonID() {
		return this.seasonID;
	}

	public void setSeasonID(int seasonID) {
		this.seasonID = seasonID;
	}

	public int getSeasonStartYear() {
		return this.seasonStartYear;
	}

	public void setSeasonStartYear(int seasonStartYear) {
		this.seasonStartYear = seasonStartYear;
	}

	public boolean getTwoYearSpread() {
		return this.twoYearSpread;
	}

	public void setTwoYearSpread(boolean twoYearSpread) {
		this.twoYearSpread = twoYearSpread;
	}

	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	
}