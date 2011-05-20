package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SubSections database table.
 * 
 */
@Entity
@Table(name="SubSections")
public class SubSection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SubSectionID")
	private int subSectionID;

	@Column(name="SubSectionName")
	private String subSectionName;

	@Column(name="SubSectionName_EN")
	private String subSectionName_EN;

	@Column(name="SubSectionName_url")
	private String subSectionName_url;

	@Column(name="SubSectionURL")
	private String subSectionURL;

	//bi-directional many-to-one association to SubSectionTag
	@OneToMany(mappedBy="subSection")
	private List<SubSectionTag> subSectionTags;

	//bi-directional many-to-one association to Section
    @ManyToOne
	@JoinColumn(name="SectionID")
	private Section section;

    public SubSection() {
    }

	public int getSubSectionID() {
		return this.subSectionID;
	}

	public void setSubSectionID(int subSectionID) {
		this.subSectionID = subSectionID;
	}

	public String getSubSectionName() {
		return this.subSectionName;
	}

	public void setSubSectionName(String subSectionName) {
		this.subSectionName = subSectionName;
	}

	public String getSubSectionName_EN() {
		return this.subSectionName_EN;
	}

	public void setSubSectionName_EN(String subSectionName_EN) {
		this.subSectionName_EN = subSectionName_EN;
	}

	public String getSubSectionName_url() {
		return this.subSectionName_url;
	}

	public void setSubSectionName_url(String subSectionName_url) {
		this.subSectionName_url = subSectionName_url;
	}

	public String getSubSectionURL() {
		return this.subSectionURL;
	}

	public void setSubSectionURL(String subSectionURL) {
		this.subSectionURL = subSectionURL;
	}

	public List<SubSectionTag> getSubSectionTags() {
		return this.subSectionTags;
	}

	public void setSubSectionTags(List<SubSectionTag> subSectionTags) {
		this.subSectionTags = subSectionTags;
	}
	
	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
}