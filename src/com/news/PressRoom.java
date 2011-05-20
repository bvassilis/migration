package com.news;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the PressRoom database table.
 * 
 */
@Entity
public class PressRoom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="NewsPaperID")
	private int newsPaperID;

	@Column(name="PressAuthor")
	private String pressAuthor;

	@Column(name="PressBody")
	private String pressBody;

	@Column(name="PressDate")
	private Timestamp pressDate;
	@Id
	@Column(name="PressID")
	private int pressID;

	@Column(name="PressTitle")
	private String pressTitle;

    public PressRoom() {
    }

	public int getNewsPaperID() {
		return this.newsPaperID;
	}

	public void setNewsPaperID(int newsPaperID) {
		this.newsPaperID = newsPaperID;
	}

	public String getPressAuthor() {
		return this.pressAuthor;
	}

	public void setPressAuthor(String pressAuthor) {
		this.pressAuthor = pressAuthor;
	}

	public String getPressBody() {
		return this.pressBody;
	}

	public void setPressBody(String pressBody) {
		this.pressBody = pressBody;
	}

	public Timestamp getPressDate() {
		return this.pressDate;
	}

	public void setPressDate(Timestamp pressDate) {
		this.pressDate = pressDate;
	}

	public int getPressID() {
		return this.pressID;
	}

	public void setPressID(int pressID) {
		this.pressID = pressID;
	}

	public String getPressTitle() {
		return this.pressTitle;
	}

	public void setPressTitle(String pressTitle) {
		this.pressTitle = pressTitle;
	}

}