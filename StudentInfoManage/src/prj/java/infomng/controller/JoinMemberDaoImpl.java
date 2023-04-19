package prj.java.infomng.controller;

import static prj.java.infomng.oracle.OracleConnect.*;
import static prj.java.infomng.model.JoinMember.Entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;
import prj.java.infomng.model.JoinMember;
import prj.java.infomng.model.StudentInfoManage;

public class JoinMemberDaoImpl implements JoinMemberDao{
	
	private static JoinMemberDaoImpl instance = null;
	private JoinMemberDaoImpl () {}
	public static JoinMemberDaoImpl getInstance() {
		if(instance == null) {
			instance = new JoinMemberDaoImpl();
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
	
	@Override
	public void memberCreate(JoinMember member) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			
			String sql = String.format("insert into %s (%s, %s, %s, %s, %s, %s) values(?, ?, ?, ?, ?, ?)",
					TBL_NAME, COL_NAME, COL_ID, COL_PW, COL_BIRTH, COL_PHONE, COL_EMAIL);
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getId());
			stmt.setString(3, member.getPw());
			stmt.setString(4, member.getBirth());
			stmt.setString(5, member.getPhone());
			stmt.setString(6, member.getEmail());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

	@Override
	public boolean idCheck(String id) {
		boolean result = true;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = String.format("SELECT * FROM %s WHERE %s = ?", TBL_NAME, COL_ID);
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				if(id.equals(rs.getString(COL_ID))) return false;
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
		
		return result;
	}

	@Override
	public boolean loginCheck(String id, String pw) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = String.format("select * from %s where %s = ? and %s = ?", TBL_NAME, COL_ID, COL_PW );
			stmt = conn.prepareStatement(sql);		
			
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				if(id.equals(rs.getString(COL_ID)) && pw.equals(rs.getString(COL_PW))) result = true;
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
			
		return result;
	}
	
	@Override
	public int loginCheckNum(String id, String pw) { // cid를 반환
		int result = -1;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = String.format("select * from %s where %s = ? and %s = ?", TBL_NAME, COL_ID, COL_PW );
			stmt = conn.prepareStatement(sql);		
			
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				if(id.equals(rs.getString(COL_ID)) && pw.equals(rs.getString(COL_PW))) result = rs.getInt(COL_CID);
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
			
		return result;
	}
	
	@Override
	public JoinMember haveMyInfo(int cid) {
		 JoinMember info = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = String.format("select * from %s where %s = ?", TBL_NAME, COL_CID);
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cid);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				int cidId = rs.getInt(COL_CID);
				String name = rs.getString(COL_NAME);
				String id = rs.getString(COL_ID);
				String pw = rs.getString(COL_PW);
				String birth = rs.getString(COL_BIRTH);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				
				info = new JoinMember(cidId, name, id, pw, birth, phone, email);
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
		
		return info;
	}
	
	@Override
	public void withdrawMember(int cid) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			String sql = String.format("delete from %s where %s = ?", TBL_NAME, COL_CID);
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cid);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	@Override
	public void updateMyInfo(int cid, JoinMember member) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			String sql = String.format("update %s set %s = ?, %s = ?, %s = ?, %s = ? where %s = ?",
										TBL_NAME, COL_NAME, COL_BIRTH, COL_PHONE, COL_EMAIL, COL_CID);
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getBirth());
			stmt.setString(3, member.getPhone());
			stmt.setString(4, member.getEmail());
			stmt.setInt(5, cid);
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
