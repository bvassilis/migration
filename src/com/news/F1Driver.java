package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the F1Drivers database table.
 * 
 */
@Entity
@Table(name="F1Drivers")
public class F1Driver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="DriverBioID")
	private int driverBioID;
	@Id
	@Column(name="DriverID")
	private int driverID;

	@Column(name="DriverName")
	private String driverName;

	@Column(name="DriverName_en")
	private String driverName_en;

	@Column(name="DriverPhoto")
	private String driverPhoto;

    public F1Driver() {
    }

	public int getDriverBioID() {
		return this.driverBioID;
	}

	public void setDriverBioID(int driverBioID) {
		this.driverBioID = driverBioID;
	}

	public int getDriverID() {
		return this.driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	public String getDriverName() {
		return this.driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverName_en() {
		return this.driverName_en;
	}

	public void setDriverName_en(String driverName_en) {
		this.driverName_en = driverName_en;
	}

	public String getDriverPhoto() {
		return this.driverPhoto;
	}

	public void setDriverPhoto(String driverPhoto) {
		this.driverPhoto = driverPhoto;
	}

}