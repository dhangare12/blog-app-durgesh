package com.codeWithdurgesh.blog.payloads;

public class CommentDto {

    private int id;
	
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
