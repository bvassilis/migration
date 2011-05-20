package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the VathExtras database table.
 * 
 */
@Entity
@Table(name="VathExtras")
public class VathExtra implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CompID")
	private int compID;

	@Column(name="Iso")
	private int iso;

	@Column(name="NullGames")
	private int nullGames;

	@Column(name="Points")
	private int points;

	@Column(name="SeasonID")
	private int seasonID;

	@Column(name="TeamID")
	private int teamID;

	@Column(name="VathExtraID")
	private int vathExtraID;

    public VathExtra() {
    }

	public int getCompID() {
		return this.compID;
	}

	public void setCompID(int compID) {
		this.compID = compID;
	}

	public int getIso() {
		return this.iso;
	}

	public void setIso(int iso) {
		this.iso = iso;
	}

	public int getNullGames() {
		return this.nullGames;
	}

	public void setNullGames(int nullGames) {
		this.nullGames = nullGames;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
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

	public int getVathExtraID() {
		return this.vathExtraID;
	}

	public void setVathExtraID(int vathExtraID) {
		this.vathExtraID = vathExtraID;
	}

}