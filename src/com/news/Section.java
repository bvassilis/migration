package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Sections database table.
 * 
 */
@Entity
@Table(name="Sections")
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SectionID")
	private int sectionID;

	@Column(name="SectionName")
	private String sectionName;

	//bi-directional many-to-one association to SubSection
	@OneToMany(mappedBy="section")
	private List<SubSection> subSections;

    public Section() {
    }

	public int getSectionID() {
		return this.sectionID;
	}

	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}

	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public List<SubSection> getSubSections() {
		return this.subSections;
	}

	public void setSubSections(List<SubSection> subSections) {
		this.subSections = subSections;
	}
	
}