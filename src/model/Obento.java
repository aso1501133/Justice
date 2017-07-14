package model;

public class Obento {
	private String bento_id = "";
	private String bento_name = "";
	private String user_id = "";
	private String image = "";
	private int votes  = 0;
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public String getBento_id() {
		return bento_id;
	}
	public void setBento_id(String bento_id) {
		this.bento_id = bento_id;
	}
	public String getBento_name() {
		return bento_name;
	}
	public void setBento_name(String bento_name) {
		this.bento_name = bento_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
