package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConnFactory;
import vo.Ticketing;




public class TicketingDao implements IDao <Ticketing, Integer>{

	@Override
	public synchronized boolean insert(Ticketing vo) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "INSERT INTO TICKETING(ORDERID, CUSTID, CONID, SALEPRICE)"
				+ "VALUES(?,?,?,?)"; //
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getOrderid());
		pstmt.setInt(2, vo.getCustid());
		pstmt.setInt(3, vo.getConid());
		pstmt.setInt(4, vo.getSaleprice());

		int res = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		

		return (res >= 1)? true:false;
		

	}

	@Override
	public synchronized Ticketing select(Integer Key) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "SELECT * FROM TICKETING WHERE ORDERID = ?";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Key);
		ResultSet rs = pstmt.executeQuery();
		Ticketing vo = new Ticketing();
		while(rs.next()) {
			vo.setOrderid(rs.getInt(1));
			vo.setCustid(rs.getInt(2));
			vo.setConid(rs.getInt(3));
			vo.setSaleprice(rs.getInt(4));
		}
		
		return vo;
	}

	@Override
	public synchronized List<Ticketing> selectAll() throws SQLException {Connection conn = ConnFactory.getConnection();
		String sql = "SELECT * FROM TICKETING";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Ticketing> list = new ArrayList<>();
		
		while(rs.next()) {
			Ticketing vo = new Ticketing();
			vo.setOrderid(rs.getInt(1));
			vo.setCustid(rs.getInt(2));
			vo.setConid(rs.getInt(3));
			vo.setSaleprice(rs.getInt(4));
			list.add(vo);
		}

	
	return list;
}


	@Override
	public boolean update(Ticketing vo) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "UPDATE TICKETING SET CUSTID = ?, "
				+ "CONID=?, SALEPRICE=? WHERE ORDERID = ?";
		
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getCustid());
		pstmt.setInt(2, vo.getConid());
		pstmt.setInt(3, vo.getSaleprice());
		pstmt.setInt(4, vo.getOrderid());
		int res = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
		return (res >= 1)? true:false;
		

	}
		
	@Override
	public boolean delete(Integer Key) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "DELETE FROM TICKETING WHERE ORDERId = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);		
		pstmt.setInt(1, Key);
		int res = pstmt.executeUpdate();
		pstmt.close();
		conn.close();

		return (res >= 1 )?true : false;
	}

	}


