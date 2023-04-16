package prj.java.infomng.controller;

import java.util.List;

import prj.java.infomng.model.StudentInfoManage;

public interface StudentInfoManageDao {
	
	/**
	 * 학생 정보관리프로그램에 저장된 모든 내용을 검색.
	 * DB StudentInfoManage 테이블에 저장된 모든 정보를 검색.
	 * @return StudentInfoManage 타입을 원소로 갖는 List.
	 */
	List<StudentInfoManage> read();
	
	/**
	 * DB StudentInfoManage 테이블에서 해당 primary key로 검색.
	 * @param cid 검색할 primary key.
	 * @return cid가 존재하면 StudentInfoManage 타입 객체를 리턴. cid가 없으면 null을 리턴.
	 */
	StudentInfoManage read(int cid);
	
	/**
	 * 주어진 검색어가 포함된 내용들을
	 * DB StudentInfoManage 테이블에서 검색해서 리스트를 리턴. 검색어는 대/소문자 구분이 없음.
	 * 
	 * @param  검색할 단어.
	 * @return 검색 결과 리스트.
	 */
	List<StudentInfoManage> read(String Searchedword);
	
	/**
	 * 연락처 정보를 DB의 StudentInfoManage 테이블에 insert.
	 * @param StudentInfoManage 저장할 정보를 가지고 있는 객체.
	 * @return DB 테이블에 삽입된 행의 개수.
	 */
	int create(StudentInfoManage info);
	
	/**
	 * primary key에 해당하는 학생 정보관리프로그램 정보를 수정(update).
	 * @param StudentInfoManage 수정할 연락처의 PK(cid)와 정보들을 저장한 객체.
	 * @return DB 테이블에서 업데이트된 행의 개수.
	 */
	int update(StudentInfoManage info);
	
	/**
	 * Primary key(cid)에 해당하는 학생 정보관리프로그램 정보를 DB 테이블에서 삭제.
	 * @param cid 삭제할 학생 정보관리프로그램의 PK.
	 * @return 삭제된 행의 개수.
	 */
	int delete(int cid);
	
}
