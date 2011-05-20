package com.news;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the dtproperties database table.
 * 
 */
@Embeddable
public class DtpropertyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	private String property;

    public DtpropertyPK() {
    }
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProperty() {
		return this.property;
	}
	public void setProperty(String property) {
		this.property = property;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DtpropertyPK)) {
			return false;
		}
		DtpropertyPK castOther = (DtpropertyPK)other;
		return 
			(this.id == castOther.id)
			&& this.property.equals(castOther.property);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.property.hashCode();
		
		return hash;
    }
}