package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SubSectionTags database table.
 * 
 */
@Entity
@Table(name="SubSectionTags")
public class SubSectionTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SubSectionTagID")
	private int subSectionTagID;

	@Column(name="SubSectionTagName")
	private String subSectionTagName;

	@Column(name="SubSectionTagName_en")
	private String subSectionTagName_en;

	@Column(name="SubSectionTagName_Url")
	private String subSectionTagName_Url;

	//bi-directional many-to-one association to SubSection
    @ManyToOne
	@JoinColumn(name="SubSectionID")
	private SubSection subSection;

    public SubSectionTag() {
    }

	public int getSubSectionTagID() {
		return this.subSectionTagID;
	}

	public void setSubSectionTagID(int subSectionTagID) {
		this.subSectionTagID = subSectionTagID;
	}

	public String getSubSectionTagName() {
		return this.subSectionTagName;
	}

	public void setSubSectionTagName(String subSectionTagName) {
		this.subSectionTagName = subSectionTagName;
	}

	public String getSubSectionTagName_en() {
		return this.subSectionTagName_en;
	}

	public void setSubSectionTagName_en(String subSectionTagName_en) {
		this.subSectionTagName_en = subSectionTagName_en;
	}

	public String getSubSectionTagName_Url() {
		return this.subSectionTagName_Url;
	}

	public void setSubSectionTagName_Url(String subSectionTagName_Url) {
		this.subSectionTagName_Url = subSectionTagName_Url;
	}

	public SubSection getSubSection() {
		return this.subSection;
	}

	public void setSubSection(SubSection subSection) {
		this.subSection = subSection;
	}
	
}