package com.dlsdlworld.web.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.dlsdlworld.web.Entities.Member;

public class MemberDao {
	
	private ArrayList<String> DataBaseIdPwUrl(){
		
		ArrayList<String> databaseInfo = new ArrayList<>();
		String dbId = "c##tester";
		String dbPw = "1234";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		
		databaseInfo.add(dbUrl);
		databaseInfo.add(dbId);
		databaseInfo.add(dbPw);
		
		return databaseInfo;
	
	}
	
	public void findDriver() {
		
		try {	
		Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public Connection connectionSet() {
		Connection con = null;
		ArrayList<String> inputInfo = new ArrayList<>();
		MemberDao member = new MemberDao();
		inputInfo = member.DataBaseIdPwUrl();
		try {
			con = DriverManager.getConnection(inputInfo.get(0),inputInfo.get(1),inputInfo.get(2));			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void insert(Member member) {
		MemberDao md = new MemberDao();
		md.findDriver();
		Connection con = md.connectionSet();
		PreparedStatement ps = null;
		String sql = "insert into member (num, userid , userpw, usernick, regdate) values (\"MEMBER_SEQ\".nextval, ?,?,?,sysdate)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getUserId());
			ps.setString(2, member.getUserPw());
			ps.setString(3,member.getUserNick());
			ps.executeUpdate();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Member member, String beforeUserId) {
		MemberDao md = new MemberDao();
		md.findDriver();
		Connection con = md.connectionSet();
		PreparedStatement ps = null;
		String sql = "update member set userid=?,userpw=?,usernick=? where userid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getUserId());
			ps.setString(2, member.getUserPw());
			ps.setString(3,member.getUserNick());
			ps.setString(4, beforeUserId);
			ps.executeUpdate();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String deleteUserId) {
		MemberDao md = new MemberDao();
		md.findDriver();
		Connection con = md.connectionSet();
		PreparedStatement ps = null;
		String sql = "delete from member where userid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setNString(1, deleteUserId);
			ps.executeUpdate();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getIdInfo(String inputUserId) {
		ArrayList<String> tmp = new ArrayList<>(); 
		MemberDao md = new MemberDao();
		md.findDriver();
		Connection con = md.connectionSet();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member where userid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setNString(1, inputUserId);
			rs = ps.executeQuery();
			if(rs.next()) {
				tmp.add(String.valueOf(rs.getInt(1)));
				tmp.add(rs.getString(2));
				tmp.add(rs.getString(3));
				tmp.add(rs.getString(4));
				tmp.add(rs.getString(5));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return tmp;
	}
	
	public boolean idCheck(String checkUserId) {
		boolean check = false;
		MemberDao md = new MemberDao();
		md.findDriver();
		Connection con = md.connectionSet();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select userid from member where userid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setNString(1, checkUserId);
			rs = ps.executeQuery();
			if(rs.next()) {
				String tmp = rs.getString(1);
				if(tmp.equals(checkUserId)) {
					check = true;
					return check;					
				}
			} 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean pwCheck(String checkUserId,String checkUserPw) {
		boolean check = false;
		MemberDao md = new MemberDao();
		md.findDriver();
		Connection con = md.connectionSet();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select userpw from member where userid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setNString(1, checkUserId);
			rs = ps.executeQuery();
			if(rs.next()) {
				String tmp = rs.getString(1);
				if(tmp.equals(checkUserPw)) {
					check = true;
					return check;					
				}
			} 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	
	
	
	
}
