package com.project.bean;

public class GoodsBean {
	private int id;
	private String name;
	private int price;
	private String type;
	private int commentNum;
	private CommentBean comment;
	
	
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public CommentBean getComment() {
		return comment;
	}
	public void setComment(CommentBean comment) {
		this.comment = comment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "GoodsBean [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + ", commentNum="
				+ commentNum + ", comment=" + comment + "]";
	}
	
}
