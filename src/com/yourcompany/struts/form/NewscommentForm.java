package com.yourcompany.struts.form;

import org.apache.struts.action.ActionForm;

public class NewscommentForm extends ActionForm {
	private Integer commentId;
	private String commentTitle;
	private String commentContent;
	private Integer newsId;
	private String commentDate;
	private String username;
	private String commentRemarks;
	private String newsType;

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