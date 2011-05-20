package com.news;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Rounds database table.
 * 
 */
@Entity
@Table(name="Rounds")
public class Round implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RoundID")
	private int roundID;

	@Column(name="RoundName")
	private String roundName;

	@Column(name="RoundName_EN")
	private String roundName_EN;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="round")
	private List<Match> matches;

	//bi-directional many-to-one association to RoundType
    @ManyToOne
	@JoinColumn(name="RoundTypeID")
	private RoundType roundType;

    public Round() {
    }

	public int getRoundID() {
		return this.roundID;
	}

	public void setRoundID(int roundID) {
		this.roundID = roundID;
	}

	public String getRoundName() {
		return this.roundName;
	}

	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}

	public String getRoundName_EN() {
		return this.roundName_EN;
	}

	public void setRoundName_EN(String roundName_EN) {
		this.roundName_EN = roundName_EN;
	}

	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	
	public RoundType getRoundType() {
		return this.roundType;
	}

	public void setRoundType(RoundType roundType) {
		this.roundType = roundType;
	}
	
}