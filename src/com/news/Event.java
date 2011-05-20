package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Events database table.
 * 
 */
@Entity
@Table(name="Events")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CompetitionID")
	private int competitionID;
	@Id
	@Column(name="EventID")
	private int eventID;

	@Column(name="EventName")
	private String eventName;

	@Column(name="EventName_en")
	private String eventName_en;

	@Column(name="EventName_url")
	private String eventName_url;

    public Event() {
    }

	public int getCompetitionID() {
		return this.competitionID;
	}

	public void setCompetitionID(int competitionID) {
		this.competitionID = competitionID;
	}

	public int getEventID() {
		return this.eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventName_en() {
		return this.eventName_en;
	}

	public void setEventName_en(String eventName_en) {
		this.eventName_en = eventName_en;
	}

	public String getEventName_url() {
		return this.eventName_url;
	}

	public void setEventName_url(String eventName_url) {
		this.eventName_url = eventName_url;
	}

}