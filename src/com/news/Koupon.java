package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the Koupon database table.
 * 
 */
@Entity
public class Koupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="KouponID")
	private int kouponID;

	private short AScore;

	@Column(name="ASS")
	private BigDecimal ass;

	@Column(name="Ateam")
	private String ateam;

	@Column(name="Code")
	private short code;

	@Column(name="Comp")
	private String comp;

	@Column(name="Cond")
	private String cond;

	@Column(name="DEU")
	private BigDecimal deu;

	@Column(name="DRAW")
	private BigDecimal draw;

	private short HAScore;

	private short HHScore;

	private short HScore;

	@Column(name="Hteam")
	private String hteam;

	@Column(name="MatchDate")
	private Timestamp matchDate;

	//bi-directional many-to-one association to Article
    @ManyToOne
	@JoinColumn(name="ArticleID")
	private Article article;

    public Koupon() {
    }

	public int getKouponID() {
		return this.kouponID;
	}

	public void setKouponID(int kouponID) {
		this.kouponID = kouponID;
	}

	public short getAScore() {
		return this.AScore;
	}

	public void setAScore(short AScore) {
		this.AScore = AScore;
	}

	public BigDecimal getAss() {
		return this.ass;
	}

	public void setAss(BigDecimal ass) {
		this.ass = ass;
	}

	public String getAteam() {
		return this.ateam;
	}

	public void setAteam(String ateam) {
		this.ateam = ateam;
	}

	public short getCode() {
		return this.code;
	}

	public void setCode(short code) {
		this.code = code;
	}

	public String getComp() {
		return this.comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public String getCond() {
		return this.cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public BigDecimal getDeu() {
		return this.deu;
	}

	public void setDeu(BigDecimal deu) {
		this.deu = deu;
	}

	public BigDecimal getDraw() {
		return this.draw;
	}

	public void setDraw(BigDecimal draw) {
		this.draw = draw;
	}

	public short getHAScore() {
		return this.HAScore;
	}

	public void setHAScore(short HAScore) {
		this.HAScore = HAScore;
	}

	public short getHHScore() {
		return this.HHScore;
	}

	public void setHHScore(short HHScore) {
		this.HHScore = HHScore;
	}

	public short getHScore() {
		return this.HScore;
	}

	public void setHScore(short HScore) {
		this.HScore = HScore;
	}

	public String getHteam() {
		return this.hteam;
	}

	public void setHteam(String hteam) {
		this.hteam = hteam;
	}

	public Timestamp getMatchDate() {
		return this.matchDate;
	}

	public void setMatchDate(Timestamp matchDate) {
		this.matchDate = matchDate;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
}