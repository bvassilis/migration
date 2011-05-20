package com.news;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the videos database table.
 * 
 */
@Entity
@Table(name="videos")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	private String videoCode;

	private Timestamp videoDate;

	private String videoDesc;
	@Id
	private int videoID;

	private String videoName;

	//bi-directional many-to-one association to SubSection
    @ManyToOne
	@JoinColumn(name="videoSection", referencedColumnName="SectionID")
	private SubSection subSection;

	private String videoThumb;

    public Video() {
    }

	public String getVideoCode() {
		return this.videoCode;
	}

	public void setVideoCode(String videoCode) {
		this.videoCode = videoCode;
	}

	public Timestamp getVideoDate() {
		return this.videoDate;
	}

	public void setVideoDate(Timestamp videoDate) {
		this.videoDate = videoDate;
	}

	public String getVideoDesc() {
		return this.videoDesc;
	}

	public void setVideoDesc(String videoDesc) {
		this.videoDesc = videoDesc;
	}

	public int getVideoID() {
		return this.videoID;
	}

	public void setVideoID(int videoID) {
		this.videoID = videoID;
	}

	public String getVideoName() {
		return this.videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoThumb() {
		return this.videoThumb;
	}

	public void setVideoThumb(String videoThumb) {
		this.videoThumb = videoThumb;
	}

	public SubSection getSubSection() {
		return subSection;
	}

	public void setSubSection(SubSection subSection) {
		this.subSection = subSection;
	}

}