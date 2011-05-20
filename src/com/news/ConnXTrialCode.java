package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the connXTrialCodes database table.
 * 
 */
@Entity
@Table(name="connXTrialCodes")
public class ConnXTrialCode implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;
	@Id
	private int codeid;

	private String email;

	private boolean valid;

    public ConnXTrialCode() {
    }

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCodeid() {
		return this.codeid;
	}

	public void setCodeid(int codeid) {
		this.codeid = codeid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getValid() {
		return this.valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}