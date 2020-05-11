package blog.bean;

public class User {
	private String uname=" ";
	private String email=" ";
	private String upwd=" ";
	public User(String uname, String email, String upwd) {
		super();
		this.uname = uname;
		this.email = email;
		this.upwd = upwd;
	}	
	public User(String email, String upwd) {
		this.email = email;
		this.upwd = upwd;
	}
	public User() {
	
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

}
