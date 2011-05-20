package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the NewsPapers database table.
 * 
 */
@Entity
@Table(name="NewsPapers")
public class NewsPaper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="NewsPaperCode")
	private String newsPaperCode;
	@Id
	@Column(name="NewsPaperID")
	private int newsPaperID;

	@Column(name="NewsPaperIndex")
	private short newsPaperIndex;

	@Column(name="NewsPaperName")
	private String newsPaperName;

	@Column(name="NewsSubSectionID")
	private int newsSubSectionID;

	@Column(name="NewsTeamID")
	private int newsTeamID;

    public NewsPaper() {
    }

	public String getNewsPaperCode() {
		return this.newsPaperCode;
	}

	public void setNewsPaperCode(String newsPaperCode) {
		this.newsPaperCode = newsPaperCode;
	}

	public int getNewsPaperID() {
		return this.newsPaperID;
	}

	public void setNewsPaperID(int newsPaperID) {
		this.newsPaperID = newsPaperID;
	}

	public short getNewsPaperIndex() {
		return this.newsPaperIndex;
	}

	public void setNewsPaperIndex(short newsPaperIndex) {
		this.newsPaperIndex = newsPaperIndex;
	}

	public String getNewsPaperName() {
		return this.newsPaperName;
	}

	public void setNewsPaperName(String newsPaperName) {
		this.newsPaperName = newsPaperName;
	}

	public int getNewsSubSectionID() {
		return this.newsSubSectionID;
	}

	public void setNewsSubSectionID(int newsSubSectionID) {
		this.newsSubSectionID = newsSubSectionID;
	}

	public int getNewsTeamID() {
		return this.newsTeamID;
	}

	public void setNewsTeamID(int newsTeamID) {
		this.newsTeamID = newsTeamID;
	}

}