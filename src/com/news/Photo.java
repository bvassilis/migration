package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Photos database table.
 * 
 */
@Entity
@Table(name="Photos")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="Photo")
	private String photo;

	@Column(name="PhotoDesc")
	private String photoDesc;
	@Id
	@Column(name="PhotoID")
	private int photoID;
	//bi-directional many-to-one association to PhotoStory
    @ManyToOne
	@JoinColumn(name="PhotoStoryID", referencedColumnName="PhotoStoryID")
	private PhotoStory photoStory;

    public Photo() {
    }

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhotoDesc() {
		return this.photoDesc;
	}

	public void setPhotoDesc(String photoDesc) {
		this.photoDesc = photoDesc;
	}

	public int getPhotoID() {
		return this.photoID;
	}

	public void setPhotoID(int photoID) {
		this.photoID = photoID;
	}

	public PhotoStory getPhotoStory() {
		return photoStory;
	}

	public void setPhotoStory(PhotoStory photoStory) {
		this.photoStory = photoStory;
	}


}