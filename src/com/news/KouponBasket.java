package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the KouponBasket database table.
 * 
 */
@Entity
public class KouponBasket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="KouponID")
	private int kouponID;

	private short AScore;

	@Column(name="Ateam")
	private String ateam;

	@Column(name="Code")
	private short code;

	@Column(name="Comp")
	private String comp;

	@Column(name="Cond")
	private String cond;

	private short HScore;

	@Column(name="Hteam")
	private String hteam;

	@Column(name="MatchDate")
	private Timestamp matchDate;

	@Column(name="PF")
	private BigDecimal pf;

	@Column(name="PG")
	private BigDecimal pg;

	//bi-directional many-to-one association to Article
    @ManyToOne
	@JoinColumn(name="ArticleID")
	private Article article;

    public KouponBasket() {
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

	public BigDecimal getPf() {
		return this.pf;
	}

	public void setPf(BigDecimal pf) {
		this.pf = pf;
	}

	public BigDecimal getPg() {
		return this.pg;
	}

	public void setPg(BigDecimal pg) {
		this.pg = pg;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
}