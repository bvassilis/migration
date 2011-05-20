package com.news;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Articles database table.
 * 
 */
@Entity
@Table(name="Articles")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ArticleID")
	private int articleID;

	@Column(name="ArticleAuthor")
	private String articleAuthor;

	@Column(name="ArticleBody")
	private String articleBody;

	@Column(name="ArticleDate")
	private Timestamp articleDate;

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

	@Column(name="SubSectionID")
	private int subSectionID;

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

	//bi-directional many-to-one association to Koupon
	@OneToMany(mappedBy="article")
	private List<Koupon> koupons;

	//bi-directional many-to-one association to KouponBasket
	@OneToMany(mappedBy="article")
	private List<KouponBasket> kouponBaskets;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="article")
	private List<Match> matches;

    public Article() {
    }

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
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

	public int getSubSectionID() {
		return this.subSectionID;
	}

	public void setSubSectionID(int subSectionID) {
		this.subSectionID = subSectionID;
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

	public List<Koupon> getKoupons() {
		return this.koupons;
	}

	public void setKoupons(List<Koupon> koupons) {
		this.koupons = koupons;
	}
	
	public List<KouponBasket> getKouponBaskets() {
		return this.kouponBaskets;
	}

	public void setKouponBaskets(List<KouponBasket> kouponBaskets) {
		this.kouponBaskets = kouponBaskets;
	}
	
	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
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