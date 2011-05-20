package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Tags database table.
 * 
 */
@Entity
@Table(name="Tags")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="TagID")
	private int tagID;

	@Column(name="TagName")
	private String tagName;

	@Column(name="TagValue")
	private String tagValue;

    public Tag() {
    }

	public int getTagID() {
		return this.tagID;
	}

	public void setTagID(int tagID) {
		this.tagID = tagID;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagValue() {
		return this.tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}

}