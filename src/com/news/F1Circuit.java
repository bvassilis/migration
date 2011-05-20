package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the F1Circuits database table.
 * 
 */
@Entity
@Table(name="F1Circuits")
public class F1Circuit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ArticleID")
	private int articleID;
	@Id
	@Column(name="CircuitID")
	private int circuitID;

	@Column(name="CircuitLength")
	private int circuitLength;

	@Column(name="CircuitName")
	private String circuitName;

	@Column(name="CircuitName_en")
	private String circuitName_en;

	@Column(name="CircuitPhoto")
	private String circuitPhoto;

	@Column(name="CircuitRecord")
	private double circuitRecord;

	@Column(name="RecordConstructorID")
	private int recordConstructorID;

	@Column(name="RecordDriverID")
	private int recordDriverID;

    public F1Circuit() {
    }

	public int getArticleID() {
		return this.articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public int getCircuitID() {
		return this.circuitID;
	}

	public void setCircuitID(int circuitID) {
		this.circuitID = circuitID;
	}

	public int getCircuitLength() {
		return this.circuitLength;
	}

	public void setCircuitLength(int circuitLength) {
		this.circuitLength = circuitLength;
	}

	public String getCircuitName() {
		return this.circuitName;
	}

	public void setCircuitName(String circuitName) {
		this.circuitName = circuitName;
	}

	public String getCircuitName_en() {
		return this.circuitName_en;
	}

	public void setCircuitName_en(String circuitName_en) {
		this.circuitName_en = circuitName_en;
	}

	public String getCircuitPhoto() {
		return this.circuitPhoto;
	}

	public void setCircuitPhoto(String circuitPhoto) {
		this.circuitPhoto = circuitPhoto;
	}

	public double getCircuitRecord() {
		return this.circuitRecord;
	}

	public void setCircuitRecord(double circuitRecord) {
		this.circuitRecord = circuitRecord;
	}

	public int getRecordConstructorID() {
		return this.recordConstructorID;
	}

	public void setRecordConstructorID(int recordConstructorID) {
		this.recordConstructorID = recordConstructorID;
	}

	public int getRecordDriverID() {
		return this.recordDriverID;
	}

	public void setRecordDriverID(int recordDriverID) {
		this.recordDriverID = recordDriverID;
	}

}