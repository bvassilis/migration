package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fgameSections database table.
 * 
 */
@Entity
@Table(name="fgameSections")
public class FgameSection implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int fgameSectionID;

	private String fgameSectionName;

	private String fgameSectionName_en;

    public FgameSection() {
    }

	public int getFgameSectionID() {
		return this.fgameSectionID;
	}

	public void setFgameSectionID(int fgameSectionID) {
		this.fgameSectionID = fgameSectionID;
	}

	public String getFgameSectionName() {
		return this.fgameSectionName;
	}

	public void setFgameSectionName(String fgameSectionName) {
		this.fgameSectionName = fgameSectionName;
	}

	public String getFgameSectionName_en() {
		return this.fgameSectionName_en;
	}

	public void setFgameSectionName_en(String fgameSectionName_en) {
		this.fgameSectionName_en = fgameSectionName_en;
	}

}