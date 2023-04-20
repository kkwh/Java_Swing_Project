package prj.java.infomng.controller;

import java.sql.SQLException;

import prj.java.infomng.model.JoinMember;
import prj.java.infomng.model.StudentInfoManage;

public interface JoinMemberDao {
	
	/**
	 * 학생 정보관리 프로그램을 이용하기 위한 회원가입, insert.
	 * @param JoinMember 회원가입할 객체.
	 * @throws SQLException 
	 */
	void memberCreate(JoinMember member) throws SQLException;
	
	/**
	 * 회원가입 창에서 id가 중복되는지 체크.
	 * @param id 중복체크할 id.
	 * @return id가 중복되지 않으면 true, 중복되면 false.
	 */
	boolean idCheck(String id);
	
	/**
	 * 로그인할 id와 pw를 입력받아서 로그인 여부를 체크.
	 * @param id 로그인 시 입력할 id.
	 * @param pw 로그인 시 입력할 pw.
	 * @return 로그인에 성공하면 true, 실패하면 false를 리턴.
	 */
	boolean loginCheck(String id, String pw);
	
	/**
	 * 로그인할 id와 pw를 입력받아서 로그인 여부를 체크하고 cid를 반환.
	 * @param id 로그인 시 입력할 id.
	 * @param pw 로그인 시 입력할 pw.
	 * @return 로그인에 성공하면 cid, 실패하면 -1을 리턴.
	 */
	int loginCheckNum(String id, String pw);
	
	/**
	 * 회원의 cid를 입력받아서 해당 JoinMember 객체를 반환.
	 * @param cid 회원 정보의 cid.
	 * @return 입력받은 cid의 해당하는  JoinMember 객체를 리턴.
	 */
	 JoinMember haveMyInfo(int cid);
	 
	 /**
	  * 회원의 cid를 입력받아서 해당 회원의 정보를 db에서 삭제.
	  * @param cid 회원 정보의 cid.
	  */
	 void withdrawMember(int cid);
	
	 /**
	  * 회원의 cid와 JoinMember 객체를 입력받아서 해당 회원의 정보를 Update.
	  * @param cid 회원 정보의 cid.
	  * @param member 회원 정보가 들어있는 JoinMember 객체.
	  */
	 void updateMyInfo(int cid, JoinMember member);
	 
	 /**
	  * 회원의 cid와 변경하고자 하는 password를 입력받아서 해당 회원의 비밀번호를 Update.
	  * @param cid 회원 정보의 cid.
	  * @param password 회원이 변경하고자 하는 비밀번호.
	  */
	 void updateMyPw(int cid, String password);
	 
	 
	
	
	
	
	
}
