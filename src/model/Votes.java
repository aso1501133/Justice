package model;
public class Votes {
	private String bento_id = "";
	private String user_id = "";
	private String comment = "";
	public String getBento_id() {
		return bento_id;
	}
	public void setBento_id(String bento_id) {
		this.bento_id = bento_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id= user_id;
	}
}
