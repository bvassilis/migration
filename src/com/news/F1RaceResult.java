package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the F1RaceResults database table.
 * 
 */
@Entity
@Table(name="F1RaceResults")
public class F1RaceResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ConstructorID")
	private int constructorID;

	@Column(name="DriverID")
	private int driverID;

	@Column(name="GPID")
	private int gpid;

	@Column(name="Points")
	private int points;

	@Column(name="PolePos")
	private int polePos;

	@Column(name="Pos")
	private int pos;

	@Column(name="RaceTime")
	private double raceTime;
	@Id
	@Column(name="ResultID")
	private int resultID;

    public F1RaceResult() {
    }

	public int getConstructorID() {
		return this.constructorID;
	}

	public void setConstructorID(int constructorID) {
		this.constructorID = constructorID;
	}

	public int getDriverID() {
		return this.driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	public int getGpid() {
		return this.gpid;
	}

	public void setGpid(int gpid) {
		this.gpid = gpid;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPolePos() {
		return this.polePos;
	}

	public void setPolePos(int polePos) {
		this.polePos = polePos;
	}

	public int getPos() {
		return this.pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public double getRaceTime() {
		return this.raceTime;
	}

	public void setRaceTime(double raceTime) {
		this.raceTime = raceTime;
	}

	public int getResultID() {
		return this.resultID;
	}

	public void setResultID(int resultID) {
		this.resultID = resultID;
	}

}