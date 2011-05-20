package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Competitions database table.
 * 
 */
@Entity
@Table(name="Competitions")
public class Competition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CompetitionID")
	private int competitionID;

	@Column(name="CompetitionIcon")
	private String competitionIcon;

	@Column(name="CompetitionName")
	private String competitionName;

	@Column(name="CompetitionName_EN")
	private String competitionName_EN;

	@Column(name="CompetitionName_url")
	private String competitionName_url;

	@Column(name="CompetitionShortName")
	private String competitionShortName;

	@Column(name="ProgramUpdate")
	private Timestamp programUpdate;

	@Column(name="TableUpdate")
	private Timestamp tableUpdate;

	@Column(name="TwoYearSpread")
	private boolean twoYearSpread;

	@Column(name="UniRounds")
	private boolean uniRounds;

	//bi-directional many-to-one association to Place
    @ManyToOne
	@JoinColumn(name="PlaceID")
	private Place place;

	//bi-directional many-to-one association to Sport
    @ManyToOne
	@JoinColumn(name="SportID")
	private Sport sport;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="competition")
	private List<Match> matches;

    public Competition() {
    }

	public int getCompetitionID() {
		return this.competitionID;
	}

	public void setCompetitionID(int competitionID) {
		this.competitionID = competitionID;
	}

	public String getCompetitionIcon() {
		return this.competitionIcon;
	}

	public void setCompetitionIcon(String competitionIcon) {
		this.competitionIcon = competitionIcon;
	}

	public String getCompetitionName() {
		return this.competitionName;
	}

	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}

	public String getCompetitionName_EN() {
		return this.competitionName_EN;
	}

	public void setCompetitionName_EN(String competitionName_EN) {
		this.competitionName_EN = competitionName_EN;
	}

	public String getCompetitionName_url() {
		return this.competitionName_url;
	}

	public void setCompetitionName_url(String competitionName_url) {
		this.competitionName_url = competitionName_url;
	}

	public String getCompetitionShortName() {
		return this.competitionShortName;
	}

	public void setCompetitionShortName(String competitionShortName) {
		this.competitionShortName = competitionShortName;
	}

	public Timestamp getProgramUpdate() {
		return this.programUpdate;
	}

	public void setProgramUpdate(Timestamp programUpdate) {
		this.programUpdate = programUpdate;
	}

	public Timestamp getTableUpdate() {
		return this.tableUpdate;
	}

	public void setTableUpdate(Timestamp tableUpdate) {
		this.tableUpdate = tableUpdate;
	}

	public boolean getTwoYearSpread() {
		return this.twoYearSpread;
	}

	public void setTwoYearSpread(boolean twoYearSpread) {
		this.twoYearSpread = twoYearSpread;
	}

	public boolean getUniRounds() {
		return this.uniRounds;
	}

	public void setUniRounds(boolean uniRounds) {
		this.uniRounds = uniRounds;
	}

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	
}