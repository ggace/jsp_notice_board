package com.min.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.min.controller.HTTPUtil;
import com.min.vo.CommentVo;
import com.min.vo.ViewVo;
import com.min.vo.memberVo;

public class ViewDao {
	private static ViewDao dao = new ViewDao();
	DataSource dataSource = null;
	private ViewDao() {
		try {
			Context init;
			init = new InitialContext();
			dataSource = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	
	
	public static ViewDao GetInstance() {
		
		
		
		return dao;
	}
	
	public void Close(Connection conn, PreparedStatement ps, ResultSet rs ) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Close(conn, ps);
	}
	
	public void Close(Connection conn, PreparedStatement ps ) {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public Connection connect() {
		Connection conn = null;
		
		String dbURL = "jdbc:mysql://localhost:3306/boards?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";;
		String dbID  = "root";
		String dbPW  = "1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPW);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conn;

	}
	
	public void InsertView(ViewVo view) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO VIEW(TITLE, CONTENT, DAY, USERID)";
		sql += "VALUES(?, ?, SYSDATE(), ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, view.getTitle());
			pstmt.setString(2, view.getContent());
			pstmt.setInt(3, view.getUserid());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Close(conn, pstmt);
		}
	}
	
	public void UpdateView(int id, ViewVo view) {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "UPDATE VIEW SET TITLE=?, CONTENT=? WHERE id=?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, view.getTitle());
			pstmt.setString(2, view.getContent());
			pstmt.setInt(3, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Close(conn, pstmt);
		}
		
	}
	
	public void DeleteView(int id) {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "DELETE FROM VIEW WHERE ID=?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Close(conn, pstmt);
		}
	}
	
	public ArrayList<ViewVo> GetAllView() {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "SELECT * FROM VIEW";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ViewVo> list = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<ViewVo>();
			
			while(rs.next()) {
				ViewVo view = new ViewVo();
				view.setId(rs.getInt(1));
				view.setTitle(rs.getString(2));
				view.setContent(rs.getString(3));
				view.setDay(rs.getDate(4));
				view.setCount(rs.getInt(5));
				view.setUserid(rs.getInt(6));
				
				list.add(view);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public ArrayList<ViewVo> ShowDetailView(int id) {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "SELECT * FROM VIEW WHERE ID=?";
		String sql2 = "UPDATE VIEW SET COUNT = COUNT+1 WHERE ID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ViewVo> list = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<ViewVo>();
			
			while(rs.next()) {
				ViewVo view = new ViewVo();
				view.setId(rs.getInt(1));
				view.setTitle(rs.getString(2));
				view.setContent(rs.getString(3));
				view.setDay(rs.getDate(4));
				view.setCount(rs.getInt(5));
				view.setUserid(rs.getInt(6));
				
				list.add(view);
			}
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	
	
	
	
	public ArrayList<ViewVo> ViewSearch(String type, String item) {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		String sql = " SELECT * FROM VIEW ";
		
		if(type.equals("tc")) {
			sql += " WHERE TITLE LIKE ? OR CONTENT LIKE ? ";
		}
		else if(type.equals("t")) {
			sql += " WHERE TITLE LIKE ? ";
		}
		else if(type.equals("c")) {
			sql += " WHERE CONTENT LIKE ? ";
		}
		
		
		
		ResultSet rs =null; 
		PreparedStatement pstmt = null;
		ArrayList<ViewVo> list = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + item + "%");
			
			if(type.equals("tc")) {
				pstmt.setString(2, "%" + item + "%");
			}
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<ViewVo>();
			
			while(rs.next()) {
				ViewVo view = new ViewVo();
				view.setId(rs.getInt(1));
				view.setTitle(rs.getString(2));
				view.setContent(rs.getString(3));
				view.setDay(rs.getDate(4));
				view.setCount(rs.getInt(5));
				view.setUserid(rs.getInt(6));
				
				list.add(view);
			}
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public void commentInsert(String id, String content,String userid) {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "INSERT INTO COMMENT(CONTENT, DAY, VIEWID, USERID)";
		sql += " VALUES(?, SYSDATE(), ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, Integer.parseInt(id));
			pstmt.setInt(3, Integer.parseInt(userid));
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Close(conn, pstmt);
		}
		
		
	}
	
	public ArrayList<CommentVo> commentGetAll(String id) {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "SELECT * FROM COMMENT WHERE VIEWID = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<CommentVo> list = new ArrayList<CommentVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommentVo comment = new CommentVo();
				
				
				
				comment.setId(rs.getInt("id"));
				comment.setContent(rs.getString("content"));
				comment.setDay(rs.getDate("day"));
				comment.setViewid(rs.getInt("viewid"));
				comment.setUserid(rs.getInt("userid"));
				
				list.add(comment);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Close(conn, pstmt, rs);
			
		}
		
		return list;
	}
	
	public void commentDelete(String id) {
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM COMMENT WHERE ID = ?";
		
		System.out.println(id);
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(id));
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Close(conn, pstmt);
		}
	}
	
	public int memberInsert(memberVo member) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			return 1;
		}
		PreparedStatement pstmt = null;
		
		String sql = " INSERT INTO MEMBER(USERID, USERPW, NAME, MAIL, CONTENT) ";
		sql += " VALUES(?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getUserpw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMail());
			pstmt.setString(5, member.getContent());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
		finally {
			Close(conn, pstmt);
		}
		
		return 0;
	}
	
	public ArrayList<memberVo> login(memberVo member){
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "SELECT * FROM member WHERE userid = ? AND userpw=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<memberVo> list = new ArrayList<memberVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getUserpw());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				memberVo user = new memberVo();
				
				
				
				user.setId(rs.getInt("id"));
				user.setUserid(rs.getString("userid"));
				user.setUserpw(rs.getString("userpw"));
				user.setName(rs.getString("name"));
				user.setMail(rs.getString("mail"));
				user.setContent(rs.getString("content"));
				
				list.add(user);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Close(conn, pstmt, rs);
			
		}
		
		return list;
	}
	
	
}
