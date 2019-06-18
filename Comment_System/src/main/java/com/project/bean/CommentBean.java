package com.project.bean;

public class CommentBean {
	private int id;
	private String content;
	private String time;
	private UserBean user;
	private GoodsBean goods;
	
	
	
	public GoodsBean getGoods() {
		return goods;
	}
	public void setGoods(GoodsBean goods) {
		this.goods = goods;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
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
	@Override
	public String toString() {
		return "CommentBean [id=" + id + ", content=" + content + ", time=" + time + ", user=" + user + ", goods="
				+ goods + "]";
	}
	
}
