package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FlashNews database table.
 * 
 */
@Entity
@Table(name="FlashNews")
public class FlashNew implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="FlashID")
	private int flashID;

	@Column(name="FlashLink")
	private String flashLink;

	@Column(name="FlashSection")
	private int flashSection;

	@Column(name="FlashText")
	private String flashText;

    public FlashNew() {
    }

	public int getFlashID() {
		return this.flashID;
	}

	public void setFlashID(int flashID) {
		this.flashID = flashID;
	}

	public String getFlashLink() {
		return this.flashLink;
	}

	public void setFlashLink(String flashLink) {
		this.flashLink = flashLink;
	}

	public int getFlashSection() {
		return this.flashSection;
	}

	public void setFlashSection(int flashSection) {
		this.flashSection = flashSection;
	}

	public String getFlashText() {
		return this.flashText;
	}

	public void setFlashText(String flashText) {
		this.flashText = flashText;
	}

}