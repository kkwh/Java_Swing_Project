package prj.java.infomng.model;

import java.io.Serializable;

public class StudentInfoManage implements Serializable{
	
	public interface Entity {
		String TBL_NAME = "STUDENTINFOMANAGE";
		String COL_CID = "CID"; // PK
		String COL_NAME = "NAME";
		String COL_GENDER = "GENDER";	
		String COL_PHONE = "PHONE";
		String COL_EMAIL = "EMAIL";
		String COL_BIRTH = "BIRTH";
		String COL_MAJOR = "MAJOR";
		String COL_STUDENTID = "STUDENTID";
		String COL_AVGGRADEPOINT = "AVGGRADEPOINT";	
	}
	
	private int cid; 
	private String name;
	private String gender;
	private String phone;
	private String email;
	private String birth;
	private String major;
	private String studentId;
	private String avgGradePoint;
	
	public StudentInfoManage() {}

	public StudentInfoManage(int cid, String name, String gender, String phone, String email, String birth,
			String major, String studentId, String avgGradePoint) {
		this.cid = cid;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.birth = birth;
		this.major = major;
		this.studentId = studentId;
		this.avgGradePoint = avgGradePoint;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getBirht() {
		return birth;
	}

	public void setBirht(String birht) {
		this.birth = birht;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getstudentId() {
		return studentId;
	}

	public void setstudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getAvgGradePoint() {
		return avgGradePoint;
	}

	public void setAvgGradePoint(String avgGradePoint) {
		this.avgGradePoint = avgGradePoint;
	}
	
	public int getCid() {
		return cid;
	}

	@Override
	public String toString() {
		return "StudentInfoManage(cid=" + cid + ", name=" + name + ", gender=" + gender + ", phone=" + phone
				+ ", email=" + email + ", birth=" + birth + ", major=" + major + ", studentId=" + studentId + ", avgGradePoint="
				+ avgGradePoint+ ")";
	}
	
	
	
	
	
	
}
