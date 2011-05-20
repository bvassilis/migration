package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RoundTypes database table.
 * 
 */
@Entity
@Table(name="RoundTypes")
public class RoundType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RoundTypeID")
	private int roundTypeID;

	@Column(name="RoundTypeName")
	private String roundTypeName;

	//bi-directional many-to-one association to Round
	@OneToMany(mappedBy="roundType")
	private List<Round> rounds;

    public RoundType() {
    }

	public int getRoundTypeID() {
		return this.roundTypeID;
	}

	public void setRoundTypeID(int roundTypeID) {
		this.roundTypeID = roundTypeID;
	}

	public String getRoundTypeName() {
		return this.roundTypeName;
	}

	public void setRoundTypeName(String roundTypeName) {
		this.roundTypeName = roundTypeName;
	}

	public List<Round> getRounds() {
		return this.rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}
	
}