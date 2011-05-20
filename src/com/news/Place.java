package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Places database table.
 * 
 */
@Entity
@Table(name="Places")
public class Place implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PlaceID")
	private int placeID;

	@Column(name="ParentID")
	private int parentID;

	@Column(name="PlaceIcon")
	private String placeIcon;

	@Column(name="PlaceName")
	private String placeName;

	@Column(name="PlaceName_EN")
	private String placeName_EN;

	@Column(name="PlaceName_url")
	private String placeName_url;

	@Column(name="PlaceShortName")
	private String placeShortName;

	//bi-directional many-to-one association to Competition
	@OneToMany(mappedBy="place")
	private List<Competition> competitions;

	//bi-directional many-to-one association to Team
	@OneToMany(mappedBy="place")
	private List<Team> teams;

    public Place() {
    }

	public int getPlaceID() {
		return this.placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public int getParentID() {
		return this.parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public String getPlaceIcon() {
		return this.placeIcon;
	}

	public void setPlaceIcon(String placeIcon) {
		this.placeIcon = placeIcon;
	}

	public String getPlaceName() {
		return this.placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceName_EN() {
		return this.placeName_EN;
	}

	public void setPlaceName_EN(String placeName_EN) {
		this.placeName_EN = placeName_EN;
	}

	public String getPlaceName_url() {
		return this.placeName_url;
	}

	public void setPlaceName_url(String placeName_url) {
		this.placeName_url = placeName_url;
	}

	public String getPlaceShortName() {
		return this.placeShortName;
	}

	public void setPlaceShortName(String placeShortName) {
		this.placeShortName = placeShortName;
	}

	public List<Competition> getCompetitions() {
		return this.competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}
	
	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
}