package org.apache.commons.codec.po;

import java.io.Serializable;

public class Newscomment implements Serializable {
	private Integer commentId;
	private String commentTitle;
	private String commentContent;
	private Integer newsId;
	private String commentDate;
	private String username;
	private String commentRemarks;
	private String newsType;

	public Newscomment() {
	}

	public Newscomment(String commentTitle, String commentContent,
			Integer newsId, String commentDate, String username,
			String commentRemarks, String newsType) {
		this.commentTitle = commentTitle;
		this.commentContent = commentContent;
		this.newsId = newsId;
		this.commentDate = commentDate;
		this.username = username;
		this.commentRemarks = commentRemarks;
		this.newsType = newsType;
	}

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getCommentTitle() {
		return this.commentTitle;
	}

	public void setCommentTitle(String commentTitle) {
		this.commentTitle = commentTitle;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCommentRemarks() {
		return this.commentRemarks;
	}

	public void setCommentRemarks(String commentRemarks) {
		this.commentRemarks = commentRemarks;
	}

	public String getNewsType() {
		return this.newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
}