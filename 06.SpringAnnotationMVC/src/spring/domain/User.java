package spring.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/*
 * FileName : User.java  
 * �� User �� ������ ���� Value Object (�����ΰ�ü,�����Ͻ���ü)
 * �� USERS TABLE �� 1���� ROW �� ������ ���´�.  
*/ 
public class User implements Serializable {

	///Field
    private String userId; 			// ȸ�� ID 
    private String userName;		// ȸ�� �̸� 
    private String password;     // ��й�ȣ 
    private Integer age;    			// ���� :: Integer wrapper class ��� :: ���� �뵵 Ȯ��  
    private int grade;    				// ��� :: int primitive ��� :: :: ���� �뵵 Ȯ�� 
    private Timestamp regDate	; // �������� 
    //private Timestamp regDate	= new Timestamp(new Date().getTime()); // ��������
    private boolean active; 
    
    ///Constructor
    public User() {
	}
    public User (	String userId, String userName,String password, 
    							Integer age, int grade ) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.age = age;
		this.grade = grade;
	}    

	///Method (getter/setter)
	public String getUserId(){
		return this.userId;
	}
	public void setUserId( String userId ){
	   this.userId= userId;
	}
	public String getPassword(){
	   return this.password;
	}
	public void setPassword( String password ){
	   this.password= password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public java.sql.Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(java.sql.Timestamp regDate) {
		this.regDate = regDate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}
	@Override
	public String toString() {
		return "User [userid=" + userId + ", userName=" + userName + ", password="
				+ password + ", age=" + age + ", grade=" + grade+ ", active=" + active
				+ ", regDate=" + regDate + "]";
	}
}//end of class