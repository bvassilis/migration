package com.news;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the Ads database table.
 * 
 */
@Entity
@Table(name="Ads")
public class Ad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="AdBegin")
	private Timestamp adBegin;

	@Column(name="AdCode")
	private String adCode;

	@Column(name="AdEnd")
	private Timestamp adEnd;

	@Column(name="AdFC")
	private int adFC;
	@Id
	@Column(name="AdID")
	private int adID;

	@Column(name="AdName")
	private String adName;

	@Column(name="AdType")
	private String adType;

	private boolean IEOnly;

	@Column(name="IsPermanent")
	private boolean isPermanent;

	@Column(name="IsStable")
	private boolean isStable;

	private String keyword;

	private int priority;

    public Ad() {
    }

	public Timestamp getAdBegin() {
		return this.adBegin;
	}

	public void setAdBegin(Timestamp adBegin) {
		this.adBegin = adBegin;
	}

	public String getAdCode() {
		return this.adCode;
	}

	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}

	public Timestamp getAdEnd() {
		return this.adEnd;
	}

	public void setAdEnd(Timestamp adEnd) {
		this.adEnd = adEnd;
	}

	public int getAdFC() {
		return this.adFC;
	}

	public void setAdFC(int adFC) {
		this.adFC = adFC;
	}

	public int getAdID() {
		return this.adID;
	}

	public void setAdID(int adID) {
		this.adID = adID;
	}

	public String getAdName() {
		return this.adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAdType() {
		return this.adType;
	}

	public void setAdType(String adType) {
		this.adType = adType;
	}

	public boolean getIEOnly() {
		return this.IEOnly;
	}

	public void setIEOnly(boolean IEOnly) {
		this.IEOnly = IEOnly;
	}

	public boolean getIsPermanent() {
		return this.isPermanent;
	}

	public void setIsPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

	public boolean getIsStable() {
		return this.isStable;
	}

	public void setIsStable(boolean isStable) {
		this.isStable = isStable;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}