package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Sports database table.
 * 
 */
@Entity
@Table(name="Sports")
public class Sport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SportID")
	private int sportID;

	@Column(name="SportName")
	private String sportName;

	@Column(name="SportName_EN")
	private String sportName_EN;

	@Column(name="SportName_url")
	private String sportName_url;

	//bi-directional many-to-one association to Competition
	@OneToMany(mappedBy="sport")
	private List<Competition> competitions;

    public Sport() {
    }

	public int getSportID() {
		return this.sportID;
	}

	public void setSportID(int sportID) {
		this.sportID = sportID;
	}

	public String getSportName() {
		return this.sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public String getSportName_EN() {
		return this.sportName_EN;
	}

	public void setSportName_EN(String sportName_EN) {
		this.sportName_EN = sportName_EN;
	}

	public String getSportName_url() {
		return this.sportName_url;
	}

	public void setSportName_url(String sportName_url) {
		this.sportName_url = sportName_url;
	}

	public List<Competition> getCompetitions() {
		return this.competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}
	
}