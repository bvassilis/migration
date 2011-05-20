package com.news;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Time;


/**
 * The persistent class for the SportTV database table.
 * 
 */
@Entity
public class SportTV implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="IsSelection")
	private boolean isSelection;

	@Column(name="SportChannel")
	private String sportChannel;

	@Column(name="SportEvent")
	private String sportEvent;
	@Id
	@Column(name="SportID")
	private int sportID;

	@Column(name="SportTime")
	private Time sportTime;

    public SportTV() {
    }

	public boolean getIsSelection() {
		return this.isSelection;
	}

	public void setIsSelection(boolean isSelection) {
		this.isSelection = isSelection;
	}

	public String getSportChannel() {
		return this.sportChannel;
	}

	public void setSportChannel(String sportChannel) {
		this.sportChannel = sportChannel;
	}

	public String getSportEvent() {
		return this.sportEvent;
	}

	public void setSportEvent(String sportEvent) {
		this.sportEvent = sportEvent;
	}

	public int getSportID() {
		return this.sportID;
	}

	public void setSportID(int sportID) {
		this.sportID = sportID;
	}

	public Time getSportTime() {
		return this.sportTime;
	}

	public void setSportTime(Time sportTime) {
		this.sportTime = sportTime;
	}

}