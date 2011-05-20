package com.news;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Time;


/**
 * The persistent class for the ActiveKoupons database table.
 * 
 */
@Entity
@Table(name="ActiveKoupons")
public class ActiveKoupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="Ateam")
	private String ateam;

	private double code;

	private String comp;

	@Column(name="Date")
	private Time date;

	@Column(name="Expr1")
	private String expr1;

	@Column(name="Hteam")
	private String hteam;
	@Id
	private int link;

	private String sport;

	private String txt;

    public ActiveKoupon() {
    }

	public String getAteam() {
		return this.ateam;
	}

	public void setAteam(String ateam) {
		this.ateam = ateam;
	}

	public double getCode() {
		return this.code;
	}

	public void setCode(double code) {
		this.code = code;
	}

	public String getComp() {
		return this.comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public Time getDate() {
		return this.date;
	}

	public void setDate(Time date) {
		this.date = date;
	}

	public String getExpr1() {
		return this.expr1;
	}

	public void setExpr1(String expr1) {
		this.expr1 = expr1;
	}

	public String getHteam() {
		return this.hteam;
	}

	public void setHteam(String hteam) {
		this.hteam = hteam;
	}

	public int getLink() {
		return this.link;
	}

	public void setLink(int link) {
		this.link = link;
	}

	public String getSport() {
		return this.sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getTxt() {
		return this.txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

}