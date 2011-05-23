package com.news;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the PhotoStories database table.
 * 
 */
@Entity
@Table(name="PhotoStories")
public class PhotoStory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="PhotoStoryID")
	private int photoStoryID;

	//bi-directional many-to-one association to SubSection
    @ManyToOne
	@JoinColumn(name="PhotoStorySubSectionID")
	private SubSection subSection;

	@Column(name="PhotoStoryTitle")
	private String photoStoryTitle;
	
	//bi-directional many-to-one association to Photo
	@OneToMany(mappedBy="photoStory")
	private List<Photo> photos;

    public PhotoStory() {
    }

	public int getPhotoStoryID() {
		return this.photoStoryID;
	}

	public void setPhotoStoryID(int photoStoryID) {
		this.photoStoryID = photoStoryID;
	}

	public String getPhotoStoryTitle() {
		return this.photoStoryTitle;
	}

	public void setPhotoStoryTitle(String photoStoryTitle) {
		this.photoStoryTitle = photoStoryTitle;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public SubSection getSubSection() {
		return subSection;
	}

	public void setSubSection(SubSection subSection) {
		this.subSection = subSection;
	}

}