package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the NewspaperSections database table.
 * 
 */
@Entity
@Table(name="NewspaperSections")
public class NewspaperSection implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="NewspaperSectionID")
	private int newspaperSectionID;

	@Column(name="NewspaperSectionName")
	private String newspaperSectionName;

    public NewspaperSection() {
    }

	public int getNewspaperSectionID() {
		return this.newspaperSectionID;
	}

	public void setNewspaperSectionID(int newspaperSectionID) {
		this.newspaperSectionID = newspaperSectionID;
	}

	public String getNewspaperSectionName() {
		return this.newspaperSectionName;
	}

	public void setNewspaperSectionName(String newspaperSectionName) {
		this.newspaperSectionName = newspaperSectionName;
	}

}