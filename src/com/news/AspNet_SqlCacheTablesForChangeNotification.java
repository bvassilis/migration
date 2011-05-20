package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the AspNet_SqlCacheTablesForChangeNotification database table.
 * 
 */
@Entity
public class AspNet_SqlCacheTablesForChangeNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tableName;

	private int changeId;

	private Timestamp notificationCreated;

    public AspNet_SqlCacheTablesForChangeNotification() {
    }

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getChangeId() {
		return this.changeId;
	}

	public void setChangeId(int changeId) {
		this.changeId = changeId;
	}

	public Timestamp getNotificationCreated() {
		return this.notificationCreated;
	}

	public void setNotificationCreated(Timestamp notificationCreated) {
		this.notificationCreated = notificationCreated;
	}

}