package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the flashGames database table.
 * 
 */
@Entity
@Table(name="flashGames")
public class FlashGame implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fgameCode;

	private String fgameDesc;
	@Id
	private int fgameID;

	private String fgameName;

	private int fgameSection;

	private String fgameThumb;

    public FlashGame() {
    }

	public String getFgameCode() {
		return this.fgameCode;
	}

	public void setFgameCode(String fgameCode) {
		this.fgameCode = fgameCode;
	}

	public String getFgameDesc() {
		return this.fgameDesc;
	}

	public void setFgameDesc(String fgameDesc) {
		this.fgameDesc = fgameDesc;
	}

	public int getFgameID() {
		return this.fgameID;
	}

	public void setFgameID(int fgameID) {
		this.fgameID = fgameID;
	}

	public String getFgameName() {
		return this.fgameName;
	}

	public void setFgameName(String fgameName) {
		this.fgameName = fgameName;
	}

	public int getFgameSection() {
		return this.fgameSection;
	}

	public void setFgameSection(int fgameSection) {
		this.fgameSection = fgameSection;
	}

	public String getFgameThumb() {
		return this.fgameThumb;
	}

	public void setFgameThumb(String fgameThumb) {
		this.fgameThumb = fgameThumb;
	}

}