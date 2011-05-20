package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ip2country database table.
 * 
 */
@Entity
@Table(name="ip2country")
public class Ip2country implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="cou_2")
	private String cou2;

	@Column(name="cou_3")
	private String cou3;

	@Column(name="cou_name")
	private String couName;

	@Column(name="ip_from")
	private long ipFrom;

	@Column(name="ip_to")
	private long ipTo;

    public Ip2country() {
    }

	public String getCou2() {
		return this.cou2;
	}

	public void setCou2(String cou2) {
		this.cou2 = cou2;
	}

	public String getCou3() {
		return this.cou3;
	}

	public void setCou3(String cou3) {
		this.cou3 = cou3;
	}

	public String getCouName() {
		return this.couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	public long getIpFrom() {
		return this.ipFrom;
	}

	public void setIpFrom(long ipFrom) {
		this.ipFrom = ipFrom;
	}

	public long getIpTo() {
		return this.ipTo;
	}

	public void setIpTo(long ipTo) {
		this.ipTo = ipTo;
	}

}