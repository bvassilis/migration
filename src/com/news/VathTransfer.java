package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the VathTransfers database table.
 * 
 */
@Entity
@Table(name="VathTransfers")
public class VathTransfer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VathTransferID")
	private int vathTransferID;

	@Column(name="Against")
	private int against;

	@Column(name="CompetitionID")
	private int competitionID;

	@Column(name="Matches")
	private int matches;

	@Column(name="Offense")
	private int offense;

	@Column(name="Points")
	private int points;

	@Column(name="RoundID")
	private int roundID;

	@Column(name="SeasonID")
	private int seasonID;

	@Column(name="TeamID")
	private int teamID;

    public VathTransfer() {
    }

	public int getVathTransferID() {
		return this.vathTransferID;
	}

	public void setVathTransferID(int vathTransferID) {
		this.vathTransferID = vathTransferID;
	}

	public int getAgainst() {
		return this.against;
	}

	public void setAgainst(int against) {
		this.against = against;
	}

	public int getCompetitionID() {
		return this.competitionID;
	}

	public void setCompetitionID(int competitionID) {
		this.competitionID = competitionID;
	}

	public int getMatches() {
		return this.matches;
	}

	public void setMatches(int matches) {
		this.matches = matches;
	}

	public int getOffense() {
		return this.offense;
	}

	public void setOffense(int offense) {
		this.offense = offense;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getRoundID() {
		return this.roundID;
	}

	public void setRoundID(int roundID) {
		this.roundID = roundID;
	}

	public int getSeasonID() {
		return this.seasonID;
	}

	public void setSeasonID(int seasonID) {
		this.seasonID = seasonID;
	}

	public int getTeamID() {
		return this.teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

}