package org.apache.commons.codec.po;

import java.io.Serializable;

public class News implements Serializable {
	private Integer newsId;
	private String newsTitle;
	private String newsContent;
	private String newsType;
	private String newsStyle;
	private String newsIssDate;
	private String newsRemarks;

	public News() {
	}

	public News(String newsTitle, String newsContent, String newsType,
			String newsStyle, String newsIssDate, String newsRemarks) {
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.newsType = newsType;
		this.newsStyle = newsStyle;
		this.newsIssDate = newsIssDate;
		this.newsRemarks = newsRemarks;
	}

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsType() {
		return this.newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	public String getNewsStyle() {
		return this.newsStyle;
	}

	public void setNewsStyle(String newsStyle) {
		this.newsStyle = newsStyle;
	}

	public String getNewsIssDate() {
		return this.newsIssDate;
	}

	public void setNewsIssDate(String newsIssDate) {
		this.newsIssDate = newsIssDate;
	}

	public String getNewsRemarks() {
		return this.newsRemarks;
	}

	public void setNewsRemarks(String newsRemarks) {
		this.newsRemarks = newsRemarks;
	}
}