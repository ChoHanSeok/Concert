package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConnFactory;
import vo.Concert;




public class ConcertDao implements IDao<Concert, Integer>{

	@Override
	public synchronized boolean insert(Concert vo) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		
		String sql = "INSERT INTO CONCERT (CONID, CONNAME, CONHOST, PRICE)"
				+ "VALUES (?,?,?,?)";
		PreparedStatement pstmt = null;
		
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getConid());
			pstmt.setString(2, vo.getConname());
			pstmt.setString(3,vo.getConhost());
			pstmt.setInt(4, vo.getPrice());
			int res = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
			return (res>=1)?true:false;
			
		
	}

	@Override
	public synchronized Concert select(Integer Key) throws SQLException{
		Connection conn = ConnFactory.getConnection();
		String sql = "SELECT * FROM CONCERT WHERE CONID = ?";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Key); //auto unboxing
		ResultSet rs = pstmt.executeQuery();
		Concert vo = new Concert(); //기본 생성자로객체 생성, setter를 통해 vo를 완성.
		rs.next();
		vo.setConid(rs.getInt("CONID"));
		vo.setConname(rs.getString("CONNAME"));
		vo.setConhost(rs.getString("CONHOST"));
		vo.setPrice(rs.getInt("PRICE"));

		return vo;
	}

	@Override
	public synchronized List<Concert> selectAll() throws SQLException{
		Connection conn = ConnFactory.getConnection();
		String sql = "SELECT * FROM CONCERT";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Concert> list = new ArrayList<>();
		
		
		while(rs.next()) {
			
			Concert vo = new Concert(); //기본 생성자로객체 생성, setter를 통해 vo를 완성.
			vo.setConid(rs.getInt("CONID"));
			vo.setConname(rs.getString("CONNAME"));
			vo.setConhost(rs.getString("CONHOST"));
			vo.setPrice(rs.getInt("PRICE"));
			
			list.add(vo);
		}

		return list;
	}



	@Override
	public boolean update(Concert vo) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		
		String sql = "UPDATE CONCERT SET CONNAME = ?, "
				+ "CONHOST = ?, PRICE = ? WHERE CONID = ?";
		PreparedStatement pstmt = null;
		
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getConname());
			pstmt.setString(2,vo.getConhost());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setInt(4, vo.getConid());
			int res = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
			return (res>=1)?true:false;
			
		
	}
		
		

	@Override
	public boolean delete(Integer Key) throws SQLException{
		Connection conn = ConnFactory.getConnection();
		String sql = "DELETE FROM CONCERT WHERE CONID=?";
		PreparedStatement pstmt = null;
		
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Key);
			int res = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
			return (res>=1)?true:false;
			
		
	}

}
