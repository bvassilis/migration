package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Matches database table.
 * 
 */
@Entity
@Table(name="Matches")
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int matchid;

	@Column(name="Attendance")
	private int attendance;

	@Column(name="AwayScore")
	private short awayScore;

	@Column(name="EventID")
	private int eventID;

	@Column(name="ExtraAScore")
	private int extraAScore;

	@Column(name="ExtraHScore")
	private int extraHScore;

	@Column(name="HomeScore")
	private short homeScore;

	@Column(name="IsLive")
	private boolean isLive;

	@Column(name="MatchDate")
	private Timestamp matchDate;

	@Column(name="MatchStatus")
	private String matchStatus;

	@Column(name="PenAScore")
	private int penAScore;

	@Column(name="PenHScore")
	private int penHScore;

	@Column(name="RoundLeg")
	private short roundLeg;

	@Column(name="StadiumID")
	private int stadiumID;

	//bi-directional many-to-one association to Article
    @ManyToOne
	@JoinColumn(name="ArticleID")
	private Article article;

	//bi-directional many-to-one association to Competition
    @ManyToOne
	@JoinColumn(name="CompetitionID")
	private Competition competition;

	//bi-directional many-to-one association to Round
    @ManyToOne
	@JoinColumn(name="RoundID")
	private Round round;

	//bi-directional many-to-one association to Season
    @ManyToOne
	@JoinColumn(name="SeasonID")
	private Season season;

	//bi-directional many-to-one association to Team
    @ManyToOne
	@JoinColumn(name="HomeTeamID")
	private Team team1;

	//bi-directional many-to-one association to Team
    @ManyToOne
	@JoinColumn(name="AwayTeamID")
	private Team team2;

    public Match() {
    }

	public int getMatchid() {
		return this.matchid;
	}

	public void setMatchid(int matchid) {
		this.matchid = matchid;
	}

	public int getAttendance() {
		return this.attendance;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public short getAwayScore() {
		return this.awayScore;
	}

	public void setAwayScore(short awayScore) {
		this.awayScore = awayScore;
	}

	public int getEventID() {
		return this.eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public int getExtraAScore() {
		return this.extraAScore;
	}

	public void setExtraAScore(int extraAScore) {
		this.extraAScore = extraAScore;
	}

	public int getExtraHScore() {
		return this.extraHScore;
	}

	public void setExtraHScore(int extraHScore) {
		this.extraHScore = extraHScore;
	}

	public short getHomeScore() {
		return this.homeScore;
	}

	public void setHomeScore(short homeScore) {
		this.homeScore = homeScore;
	}

	public boolean getIsLive() {
		return this.isLive;
	}

	public void setIsLive(boolean isLive) {
		this.isLive = isLive;
	}

	public Timestamp getMatchDate() {
		return this.matchDate;
	}

	public void setMatchDate(Timestamp matchDate) {
		this.matchDate = matchDate;
	}

	public String getMatchStatus() {
		return this.matchStatus;
	}

	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}

	public int getPenAScore() {
		return this.penAScore;
	}

	public void setPenAScore(int penAScore) {
		this.penAScore = penAScore;
	}

	public int getPenHScore() {
		return this.penHScore;
	}

	public void setPenHScore(int penHScore) {
		this.penHScore = penHScore;
	}

	public short getRoundLeg() {
		return this.roundLeg;
	}

	public void setRoundLeg(short roundLeg) {
		this.roundLeg = roundLeg;
	}

	public int getStadiumID() {
		return this.stadiumID;
	}

	public void setStadiumID(int stadiumID) {
		this.stadiumID = stadiumID;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}
	
	public Round getRound() {
		return this.round;
	}

	public void setRound(Round round) {
		this.round = round;
	}
	
	public Season getSeason() {
		return this.season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
	
	public Team getTeam1() {
		return this.team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}
	
	public Team getTeam2() {
		return this.team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}
	
}