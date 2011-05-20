package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Teams database table.
 * 
 */
@Entity
@Table(name="Teams")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TeamID")
	private int teamID;

	@Column(name="IsNationalTeam")
	private boolean isNationalTeam;

	@Column(name="PlaysOutsideCountry")
	private boolean playsOutsideCountry;

	@Column(name="TeamName")
	private String teamName;

	@Column(name="TeamName_EN")
	private String teamName_EN;

	@Column(name="TeamName_url")
	private String teamName_url;

	@Column(name="TeamShortName")
	private String teamShortName;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="team1")
	private List<Match> matches1;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="team2")
	private List<Match> matches2;

	//bi-directional many-to-one association to Place
    @ManyToOne
	@JoinColumn(name="PlaceID")
	private Place place;

    public Team() {
    }

	public int getTeamID() {
		return this.teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	public boolean getIsNationalTeam() {
		return this.isNationalTeam;
	}

	public void setIsNationalTeam(boolean isNationalTeam) {
		this.isNationalTeam = isNationalTeam;
	}

	public boolean getPlaysOutsideCountry() {
		return this.playsOutsideCountry;
	}

	public void setPlaysOutsideCountry(boolean playsOutsideCountry) {
		this.playsOutsideCountry = playsOutsideCountry;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamName_EN() {
		return this.teamName_EN;
	}

	public void setTeamName_EN(String teamName_EN) {
		this.teamName_EN = teamName_EN;
	}

	public String getTeamName_url() {
		return this.teamName_url;
	}

	public void setTeamName_url(String teamName_url) {
		this.teamName_url = teamName_url;
	}

	public String getTeamShortName() {
		return this.teamShortName;
	}

	public void setTeamShortName(String teamShortName) {
		this.teamShortName = teamShortName;
	}

	public List<Match> getMatches1() {
		return this.matches1;
	}

	public void setMatches1(List<Match> matches1) {
		this.matches1 = matches1;
	}
	
	public List<Match> getMatches2() {
		return this.matches2;
	}

	public void setMatches2(List<Match> matches2) {
		this.matches2 = matches2;
	}
	
	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
}