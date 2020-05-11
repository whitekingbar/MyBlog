package blog.bean;

public class articleBean {
	private int  typeId=-1;
	private String email="";
	private String title="";
	private String content="";
	private String descrip="";
	private int visible=1;
	public int getVisible() {
		return visible;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}
	public int getTypeId() {
		return typeId;
	}
	public articleBean(int typeId, String email, String title, String content, String descrip, int visible) {
		super();
		this.typeId = typeId;
		this.email = email;
		this.title = title;
		this.content = content;
		this.visible=visible;
		this.descrip = descrip;
	}
	public articleBean() {
		// TODO Auto-generated constructor stub
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	
	
}
