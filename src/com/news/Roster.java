package com.news;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the Rosters database table.
 * 
 */
@Entity
@Table(name="Rosters")
public class Roster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="BirthDate")
	private Timestamp birthDate;

	@Column(name="ClubID")
	private int clubID;

	@Column(name="Height")
	private int height;

	@Column(name="IsInNational")
	private boolean isInNational;

	@Column(name="NationalCaps")
	private int nationalCaps;

	@Column(name="NationalGoals")
	private int nationalGoals;

	@Column(name="Nationality")
	private int nationality;
	@Id
	@Column(name="PlayerID")
	private int playerID;

	@Column(name="PlayerName")
	private String playerName;

	@Column(name="PlayerName_en")
	private String playerName_en;

	@Column(name="PlayerPos")
	private String playerPos;

	@Column(name="PlayerSurname")
	private String playerSurname;

	@Column(name="PlayerSurname_en")
	private String playerSurname_en;

    public Roster() {
    }

	public Timestamp getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public int getClubID() {
		return this.clubID;
	}

	public void setClubID(int clubID) {
		this.clubID = clubID;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean getIsInNational() {
		return this.isInNational;
	}

	public void setIsInNational(boolean isInNational) {
		this.isInNational = isInNational;
	}

	public int getNationalCaps() {
		return this.nationalCaps;
	}

	public void setNationalCaps(int nationalCaps) {
		this.nationalCaps = nationalCaps;
	}

	public int getNationalGoals() {
		return this.nationalGoals;
	}

	public void setNationalGoals(int nationalGoals) {
		this.nationalGoals = nationalGoals;
	}

	public int getNationality() {
		return this.nationality;
	}

	public void setNationality(int nationality) {
		this.nationality = nationality;
	}

	public int getPlayerID() {
		return this.playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName_en() {
		return this.playerName_en;
	}

	public void setPlayerName_en(String playerName_en) {
		this.playerName_en = playerName_en;
	}

	public String getPlayerPos() {
		return this.playerPos;
	}

	public void setPlayerPos(String playerPos) {
		this.playerPos = playerPos;
	}

	public String getPlayerSurname() {
		return this.playerSurname;
	}

	public void setPlayerSurname(String playerSurname) {
		this.playerSurname = playerSurname;
	}

	public String getPlayerSurname_en() {
		return this.playerSurname_en;
	}

	public void setPlayerSurname_en(String playerSurname_en) {
		this.playerSurname_en = playerSurname_en;
	}

}