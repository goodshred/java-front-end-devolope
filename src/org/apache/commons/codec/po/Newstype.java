package org.apache.commons.codec.po;

import java.io.Serializable;

public class Newstype implements Serializable {
	private Integer newsTypeId;
	private String newsTypeName;
	private String newsTypeDateTime;
	private String newsTypeRemarks;

	public Newstype() {
	}

	public Newstype(String newsTypeName, String newsTypeDateTime,
			String newsTypeRemarks) {
		this.newsTypeName = newsTypeName;
		this.newsTypeDateTime = newsTypeDateTime;
		this.newsTypeRemarks = newsTypeRemarks;
	}

	public Integer getNewsTypeId() {
		return this.newsTypeId;
	}

	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}

	public String getNewsTypeName() {
		return this.newsTypeName;
	}

	public void setNewsTypeName(String newsTypeName) {
		this.newsTypeName = newsTypeName;
	}

	public String getNewsTypeDateTime() {
		return this.newsTypeDateTime;
	}

	public void setNewsTypeDateTime(String newsTypeDateTime) {
		this.newsTypeDateTime = newsTypeDateTime;
	}

	public String getNewsTypeRemarks() {
		return this.newsTypeRemarks;
	}

	public void setNewsTypeRemarks(String newsTypeRemarks) {
		this.newsTypeRemarks = newsTypeRemarks;
	}
}