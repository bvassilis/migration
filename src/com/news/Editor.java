package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Editors database table.
 * 
 */
@Entity
@Table(name="Editors")
public class Editor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="EditorArticleID")
	private int editorArticleID;
	@Id
	@Column(name="EditorID")
	private int editorID;

	@Column(name="EditorPhoto")
	private String editorPhoto;

	@Column(name="EditorTitle")
	private String editorTitle;

	@Column(name="IsActive")
	private boolean isActive;

    public Editor() {
    }

	public int getEditorArticleID() {
		return this.editorArticleID;
	}

	public void setEditorArticleID(int editorArticleID) {
		this.editorArticleID = editorArticleID;
	}

	public int getEditorID() {
		return this.editorID;
	}

	public void setEditorID(int editorID) {
		this.editorID = editorID;
	}

	public String getEditorPhoto() {
		return this.editorPhoto;
	}

	public void setEditorPhoto(String editorPhoto) {
		this.editorPhoto = editorPhoto;
	}

	public String getEditorTitle() {
		return this.editorTitle;
	}

	public void setEditorTitle(String editorTitle) {
		this.editorTitle = editorTitle;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}