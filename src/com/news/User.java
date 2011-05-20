package com.news;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="AnnualIncome")
	private String annualIncome;

	@Column(name="Banned")
	private boolean banned;

	@Column(name="Birthdate")
	private Timestamp birthdate;

	@Column(name="CarBrand")
	private String carBrand;

	@Column(name="Education")
	private String education;

	@Column(name="Email")
	private String email;

	@Column(name="EmailConfirmed")
	private boolean emailConfirmed;

	@Column(name="FavTeam")
	private String favTeam;

	@Column(name="InternetProvider")
	private String internetProvider;

	private boolean isAdmin;

	@Column(name="JobDescription")
	private String jobDescription;

	@Column(name="Mobile")
	private String mobile;

	@Column(name="Name")
	private String name;

	@Column(name="Password")
	private String password;

	@Column(name="PhoneCompany")
	private String phoneCompany;

	@Column(name="Platform")
	private String platform;

	@Column(name="PreferredBank")
	private String preferredBank;

	@Column(name="RegisteredFor")
	private String registeredFor;

	@Column(name="ResidenceCountry")
	private String residenceCountry;

	@Column(name="Sex")
	private boolean sex;

	@Column(name="Surname")
	private String surname;
	@Id
	@Column(name="UserID")
	private int userID;

	@Column(name="UserName")
	private String userName;

	@Column(name="Warned")
	private boolean warned;

	@Column(name="WebBrowser")
	private String webBrowser;

	@Column(name="Xmas2006Cont")
	private boolean xmas2006Cont;

    public User() {
    }

	public String getAnnualIncome() {
		return this.annualIncome;
	}

	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}

	public boolean getBanned() {
		return this.banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	public Timestamp getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Timestamp birthdate) {
		this.birthdate = birthdate;
	}

	public String getCarBrand() {
		return this.carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getFavTeam() {
		return this.favTeam;
	}

	public void setFavTeam(String favTeam) {
		this.favTeam = favTeam;
	}

	public String getInternetProvider() {
		return this.internetProvider;
	}

	public void setInternetProvider(String internetProvider) {
		this.internetProvider = internetProvider;
	}

	public boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getJobDescription() {
		return this.jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneCompany() {
		return this.phoneCompany;
	}

	public void setPhoneCompany(String phoneCompany) {
		this.phoneCompany = phoneCompany;
	}

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPreferredBank() {
		return this.preferredBank;
	}

	public void setPreferredBank(String preferredBank) {
		this.preferredBank = preferredBank;
	}

	public String getRegisteredFor() {
		return this.registeredFor;
	}

	public void setRegisteredFor(String registeredFor) {
		this.registeredFor = registeredFor;
	}

	public String getResidenceCountry() {
		return this.residenceCountry;
	}

	public void setResidenceCountry(String residenceCountry) {
		this.residenceCountry = residenceCountry;
	}

	public boolean getSex() {
		return this.sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean getWarned() {
		return this.warned;
	}

	public void setWarned(boolean warned) {
		this.warned = warned;
	}

	public String getWebBrowser() {
		return this.webBrowser;
	}

	public void setWebBrowser(String webBrowser) {
		this.webBrowser = webBrowser;
	}

	public boolean getXmas2006Cont() {
		return this.xmas2006Cont;
	}

	public void setXmas2006Cont(boolean xmas2006Cont) {
		this.xmas2006Cont = xmas2006Cont;
	}

}