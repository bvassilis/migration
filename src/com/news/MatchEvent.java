package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MatchEvents database table.
 * 
 */
@Entity
@Table(name="MatchEvents")
public class MatchEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="EventDesc")
	private String eventDesc;

	@Column(name="EventMin")
	private int eventMin;
	@Id
	@Column(name="MatchEventID")
	private int matchEventID;

	@Column(name="MatchID")
	private int matchID;

	@Column(name="PlayByPlay")
	private String playByPlay;

	@Column(name="PlayerID")
	private int playerID;

	@Column(name="TeamID")
	private int teamID;

    public MatchEvent() {
    }

	public String getEventDesc() {
		return this.eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public int getEventMin() {
		return this.eventMin;
	}

	public void setEventMin(int eventMin) {
		this.eventMin = eventMin;
	}

	public int getMatchEventID() {
		return this.matchEventID;
	}

	public void setMatchEventID(int matchEventID) {
		this.matchEventID = matchEventID;
	}

	public int getMatchID() {
		return this.matchID;
	}

	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	public String getPlayByPlay() {
		return this.playByPlay;
	}

	public void setPlayByPlay(String playByPlay) {
		this.playByPlay = playByPlay;
	}

	public int getPlayerID() {
		return this.playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public int getTeamID() {
		return this.teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

}