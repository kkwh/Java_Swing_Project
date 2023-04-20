package prj.java.infomng.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import oracle.jdbc.OracleDriver;
import prj.java.infomng.model.StudentInfoManage;

import static prj.java.infomng.oracle.OracleConnect.*;
import static prj.java.infomng.model.StudentInfoManage.Entity.*;

public class StudentInfoManageDaoImpl implements StudentInfoManageDao{
	
	
	
	// singleton
	private static StudentInfoManageDaoImpl instance = null;
	private StudentInfoManageDaoImpl() {}
	public static StudentInfoManageDaoImpl getInstance() {
		if(instance == null) {
			instance = new StudentInfoManageDaoImpl();
		}
		return instance;
	}
	
	private Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return conn;
	}
	
	private void closeResources(Connection conn, Statement stmt) throws SQLException {
		stmt.close();
		conn.close();
	}
	
	private void closeResources(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		rs.close();
		closeResources(conn, stmt);
	}
	
	private static final String SQL_SELECT_ALL = 
			"select * from " + TBL_NAME + " order by " + COL_CID;
	
	@Override
	public List<StudentInfoManage> read() {
		ArrayList<StudentInfoManage> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int cid = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String gender = rs.getString(COL_GENDER);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				String birth = rs.getString(COL_BIRTH);
				String major = rs.getString(COL_MAJOR);
				String studentId = rs.getString(COL_STUDENTID);
				String avgGradePoint = rs.getString(COL_AVGGRADEPOINT);
				
				StudentInfoManage studentInfoManage = new StudentInfoManage(cid, name, gender, phone, email, birth, major, studentId, avgGradePoint);
				list.add(studentInfoManage);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	private static final String SQL_SELECT_BY_ID =
			"select * from " + TBL_NAME + " where " + COL_CID + " = ?";
	
	@Override
	public StudentInfoManage read(int cid) {
		StudentInfoManage studentInfoManage = null; 
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, cid);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) { 
				int id = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String gender = rs.getString(COL_GENDER);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				String birth = rs.getString(COL_BIRTH);
				String major = rs.getString(COL_MAJOR);
				String studentId = rs.getString(COL_STUDENTID);
				String avgGradePoint = rs.getString(COL_AVGGRADEPOINT);
				
				studentInfoManage = new StudentInfoManage(cid, name, gender, phone, email, birth, major,
						studentId, avgGradePoint);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return studentInfoManage;
	}
	
	private static final String SQL_SELECT_BY_KEYWORD = 
			"select * from STUDENTINFOMANAGE"
			+ " where lower(NAME) like lower(?) "
			+ " or lower(GENDER) like lower(?) "
			+ " or lower(PHONE) like lower(?) "
			+ " or lower(EMAIL) like lower(?) "
			+ " or lower(BIRTH) like lower(?) "
			+ " or lower(MAJOR) like lower(?) "
			+ " or lower(STUDENTID) like lower(?) "
			+ " or lower(AVGGRADEPOINT) like lower(?) "
			+ " order by CID";
	
	@Override
	public List<StudentInfoManage> read(String Keyword) {
		ArrayList<StudentInfoManage> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_KEYWORD);
			String key = "%" + Keyword + "%";
			
			stmt.setString(1, key);
			stmt.setString(2, key);
			stmt.setString(3, key);
			stmt.setString(4, key);
			stmt.setString(5, key);
			stmt.setString(6, key);
			stmt.setString(7, key);
			stmt.setString(8, key);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int cid = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String gender = rs.getString(COL_GENDER);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				String birth = rs.getString(COL_BIRTH);
				String major = rs.getString(COL_MAJOR);
				String studentId = rs.getString(COL_STUDENTID);
				String avgGradePoint = rs.getString(COL_AVGGRADEPOINT);
				
				StudentInfoManage info = new StudentInfoManage(cid, name, gender, phone, email, birth, major, studentId, avgGradePoint);
				list.add(info);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	private static final String SQL_INSERT =
			String.format("insert into %s (%s, %s, %s, %s, %s, %s, %s, %s) values (?, ?, ?, ?, ?, ?, ?, ?)",
					TBL_NAME, COL_NAME, COL_GENDER, COL_PHONE, COL_EMAIL, 
					COL_BIRTH, COL_MAJOR, COL_STUDENTID, COL_AVGGRADEPOINT);
	
	@Override
	public int create(StudentInfoManage info) throws SQLException {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			
			stmt.setString(1, info.getName());
			stmt.setString(2, info.getGender());
			stmt.setString(3, info.getPhone());
			stmt.setString(4, info.getEmail());
			stmt.setString(5, info.getBirth());
			stmt.setString(6, info.getMajor());
			stmt.setString(7, info.getstudentId());
			stmt.setString(8, info.getAvgGradePoint());
			
			row = stmt.executeUpdate();
			
		} catch (SQLIntegrityConstraintViolationException e) {			
			throw e;
			
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}
	
	private static final String SQL_UPDATE =
			String.format("update %s set %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? where %s = ?",
					TBL_NAME, COL_NAME, COL_GENDER, COL_PHONE, COL_EMAIL, 
					COL_BIRTH, COL_MAJOR, COL_STUDENTID, COL_AVGGRADEPOINT, COL_CID);
	
	@Override
	public int update(StudentInfoManage info) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			
			stmt.setString(1, info.getName());
			stmt.setString(2, info.getGender());
			stmt.setString(3, info.getPhone());
			stmt.setString(4, info.getEmail());
			stmt.setString(5, info.getBirth());
			stmt.setString(6, info.getMajor());
			stmt.setString(7, info.getstudentId());
			stmt.setString(8, info.getAvgGradePoint());
			stmt.setInt(9, info.getCid());
			
			row = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	private static final String SQL_DELETE = 
			String.format("delete from %s where %s = ?",
					TBL_NAME, COL_CID);
	
	@Override
	public int delete(int cid) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			
			stmt.setInt(1, cid);
			
			row = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}

}
