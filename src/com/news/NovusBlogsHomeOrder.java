package com.news;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the NovusBlogsHomeOrder database table.
 * 
 */
@Entity
public class NovusBlogsHomeOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	private int articleid;
	@Id
	@Column(name="NovusBlogsHomeID")
	private int novusBlogsHomeID;

	private int pageOrder;

	private String photo;

    public NovusBlogsHomeOrder() {
    }

	public int getArticleid() {
		return this.articleid;
	}

	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}

	public int getNovusBlogsHomeID() {
		return this.novusBlogsHomeID;
	}

	public void setNovusBlogsHomeID(int novusBlogsHomeID) {
		this.novusBlogsHomeID = novusBlogsHomeID;
	}

	public int getPageOrder() {
		return this.pageOrder;
	}

	public void setPageOrder(int pageOrder) {
		this.pageOrder = pageOrder;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}