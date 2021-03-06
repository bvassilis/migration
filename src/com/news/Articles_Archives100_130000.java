package com.news;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the Articles_Archives100_130000 database table.
 * 
 */
@Entity
public class Articles_Archives100_130000 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ArticleAuthor")
	private String articleAuthor;

	@Column(name="ArticleBody")
	private String articleBody;

	@Column(name="ArticleDate")
	private Timestamp articleDate;
	@Id
	@Column(name="ArticleID")
	private int articleID;

	@Column(name="ArticlePhoto")
	private String articlePhoto;

	@Column(name="ArticleSummary")
	private String articleSummary;

	@Column(name="ArticleTitle")
	private String articleTitle;

	private String cats;

	//bi-directional many-to-one association to Place
    @ManyToOne
	@JoinColumn(name="CompetitionID")
	private Competition competition;

	@Column(name="EventID")
	private int eventID;

	private String imodeBody;

	private String imodeTitle;

	private String kouponLink;

	@Column(name="LastUpdate")
	private Timestamp lastUpdate;

	@Column(name="Links")
	private String links;

	private String path;

	private int photostoryid;

	//bi-directional many-to-one association to Place
    @ManyToOne
	@JoinColumn(name="PlaceID")
	private Place place;

	//bi-directional many-to-one association to Sport
    @ManyToOne
	@JoinColumn(name="SportID")
	private Sport sport;

	private String subpath;

	//bi-directional many-to-one association to SubSection
    @ManyToOne
	@JoinColumn(name="SubSectionID")
	private SubSection subSection;

	@Column(name="SubSectionTagID")
	private int subSectionTagID;

	private String tags;

	//bi-directional many-to-one association to Team
    @ManyToOne
	@JoinColumn(name="Team2ID")
	private Team team1;

	//bi-directional many-to-one association to Team
    @ManyToOne
	@JoinColumn(name="TeamID")
	private Team team2;

	@Column(name="TimesRead")
	private int timesRead;

    public Articles_Archives100_130000() {
    }

	public String getArticleAuthor() {
		return this.articleAuthor;
	}

	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}

	public String getArticleBody() {
		return this.articleBody;
	}

	public void setArticleBody(String articleBody) {
		this.articleBody = articleBody;
	}

	public Timestamp getArticleDate() {
		return this.articleDate;
	}

	public void setArticleDate(Timestamp articleDate) {
		this.articleDate = articleDate;
	}

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public String getArticlePhoto() {
		return this.articlePhoto;
	}

	public void setArticlePhoto(String articlePhoto) {
		this.articlePhoto = articlePhoto;
	}

	public String getArticleSummary() {
		return this.articleSummary;
	}

	public void setArticleSummary(String articleSummary) {
		this.articleSummary = articleSummary;
	}

	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getCats() {
		return this.cats;
	}

	public void setCats(String cats) {
		this.cats = cats;
	}

	public int getEventID() {
		return this.eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public String getImodeBody() {
		return this.imodeBody;
	}

	public void setImodeBody(String imodeBody) {
		this.imodeBody = imodeBody;
	}

	public String getImodeTitle() {
		return this.imodeTitle;
	}

	public void setImodeTitle(String imodeTitle) {
		this.imodeTitle = imodeTitle;
	}

	public String getKouponLink() {
		return this.kouponLink;
	}

	public void setKouponLink(String kouponLink) {
		this.kouponLink = kouponLink;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLinks() {
		return this.links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getPhotostoryid() {
		return this.photostoryid;
	}

	public void setPhotostoryid(int photostoryid) {
		this.photostoryid = photostoryid;
	}

	public String getSubpath() {
		return this.subpath;
	}

	public void setSubpath(String subpath) {
		this.subpath = subpath;
	}

	public int getSubSectionTagID() {
		return this.subSectionTagID;
	}

	public void setSubSectionTagID(int subSectionTagID) {
		this.subSectionTagID = subSectionTagID;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getTimesRead() {
		return this.timesRead;
	}

	public void setTimesRead(int timesRead) {
		this.timesRead = timesRead;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	public Article toArticle() {
		Article a = new Article();
		a.setArticleID(articleID);

		a.setArticleAuthor(articleAuthor);

		a.setArticleBody(articleBody);

		a.setArticleDate(articleDate);

		a.setArticlePhoto(articlePhoto);

		a.setArticleSummary(articleSummary);

		a.setArticleTitle(articleTitle);

		a.setCats(cats);

		a.setCompetition(competition);

		a.setEventID(eventID);

		a.setImodeBody(imodeBody);

		a.setImodeTitle(imodeTitle);

		a.setKouponLink(kouponLink);

		a.setLastUpdate(lastUpdate);

		a.setLinks(links);

		a.setPath(path);

		a.setPhotostoryid(photostoryid);

		a.setPlace(place);

		a.setSport(sport);

		a.setSubpath(subpath);

//		a.setSubSectionID(subSectionID);

		a.setTags(tags);

//		a.setTeam2ID(team2ID);
//
//		a.setTeamID(teamID);

		a.setTimesRead(timesRead);

		return a;
	}

	public SubSection getSubSection() {
		return subSection;
	}

	public void setSubSection(SubSection subSection) {
		this.subSection = subSection;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	
}