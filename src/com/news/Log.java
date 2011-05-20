package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Log database table.
 * 
 */
@Entity
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LogItemID")
	private int logItemID;

	@Column(name="LogDateTime")
	private Timestamp logDateTime;

	@Column(name="LogDescription")
	private String logDescription;

	@Column(name="LogKeyColumn")
	private int logKeyColumn;

	@Column(name="LogSourceIP")
	private String logSourceIP;

	@Column(name="LogType")
	private int logType;

	@Column(name="LogUser")
	private String logUser;

    public Log() {
    }

	public int getLogItemID() {
		return this.logItemID;
	}

	public void setLogItemID(int logItemID) {
		this.logItemID = logItemID;
	}

	public Timestamp getLogDateTime() {
		return this.logDateTime;
	}

	public void setLogDateTime(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	public String getLogDescription() {
		return this.logDescription;
	}

	public void setLogDescription(String logDescription) {
		this.logDescription = logDescription;
	}

	public int getLogKeyColumn() {
		return this.logKeyColumn;
	}

	public void setLogKeyColumn(int logKeyColumn) {
		this.logKeyColumn = logKeyColumn;
	}

	public String getLogSourceIP() {
		return this.logSourceIP;
	}

	public void setLogSourceIP(String logSourceIP) {
		this.logSourceIP = logSourceIP;
	}

	public int getLogType() {
		return this.logType;
	}

	public void setLogType(int logType) {
		this.logType = logType;
	}

	public String getLogUser() {
		return this.logUser;
	}

	public void setLogUser(String logUser) {
		this.logUser = logUser;
	}

}