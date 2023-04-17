package prj.java.infomng.controller;

import java.sql.SQLException;

import prj.java.infomng.model.JoinMember;

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
	
	
	
	
	
	
}
