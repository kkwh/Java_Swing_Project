package prj.java.infomng.model;

import java.io.Serializable;

public class JoinMember implements Serializable {

	public interface Entity {
		String TBL_NAME = "SIGNUPINFO";
		String COL_CID = "CID"; // PK
		String COL_NAME = "NAME";
		String COL_ID = "ID";	
		String COL_PW = "PW";
		String COL_BIRTH = "BIRTH";
		String COL_PHONE = "PHONE";
		String COL_EMAIL = "EMAIL";
	}
	
	private int cid;
	private String name;
	private String id;
	private String pw;
	private String birth;
	private String phone;
	private String email;
	
	public JoinMember() {}

	public JoinMember(int cid, String name, String id, String pw, String birth, String phone, String email) {
		this.cid = cid;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getCid() {
		return cid;
	}

	@Override
	public String toString() {
		return "JoinMember(cid=" + cid + ", name=" + name + ", id=" + id + ", pw=" + pw + ", birth=" + birth
				+ ", phone=" + phone + ", email=" + email+ ")";
	}
	
	
	
	
	
	
	
	
}
