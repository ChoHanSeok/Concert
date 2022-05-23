package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConnFactory;
import vo.ConCustomer;


public class ConCustomerDao implements IDao<ConCustomer, Integer>{

	@Override
	public synchronized boolean insert(ConCustomer vo) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		
		String sql = "INSERT INTO CONCUSTOMER (CUSTID, NAME, ADDRESS, PHONE)"
				+ "VALUES (?,?,?,?)";
		PreparedStatement pstmt = null;
		
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCustid());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3,vo.getAddress());
			pstmt.setString(4, vo.getPhone());
			int res = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
			return (res>=1)?true:false;
			
		
	}

	public synchronized ConCustomer select(Integer Key) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "SELECT * FROM CONCUSTOMER WHERE CUSTID = ?";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Key); //auto unboxing
		ResultSet rs = pstmt.executeQuery();
		ConCustomer vo = new ConCustomer(); //기본 생성자로객체 생성, setter를 통해 vo를 완성.
		rs.next();
		vo.setCustid(rs.getInt("CUSTID"));
		vo.setName(rs.getString("NAME"));
		vo.setAddress(rs.getString("ADDRESS"));
		vo.setPhone(rs.getString("PHONE"));

		return vo;
	}



	@Override
	public synchronized List<ConCustomer> selectAll() throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "SELECT * FROM CONCUSTOMER";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<ConCustomer> list = new ArrayList<>();
		
		
		while(rs.next()) {
			
			ConCustomer vo = new ConCustomer();  //기본 생성자로객체 생성, setter를 통해 vo를 완성.
			vo.setCustid(rs.getInt("CUSTID"));
			vo.setName(rs.getString("NAME"));
			vo.setAddress(rs.getString("ADDRESS"));
			vo.setPhone(rs.getString("PHONE"));

			list.add(vo);
		}

		return list;
	}

	@Override
	public boolean update(ConCustomer vo) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		
		String sql = "UPDATE CONCUSTOMER SET NAME = ?, "
			+ "ADDRESS = ?, PHONE = ? WHERE CUSTID = ?";
		PreparedStatement pstmt = null;
	
	
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,vo.getName());
		pstmt.setString(2, vo.getAddress());
		pstmt.setString(3, vo.getPhone());
		pstmt.setInt(4, vo.getCustid());
		int res = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		return (res>=1)?true:false;
		
	
}
	

	@Override
	public boolean delete(Integer Key) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "DELETE FROM CONCUSTOMER WHERE CUSTID=?";
		PreparedStatement pstmt = null;
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Key);
		int res = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		return (res>=1)?true:false;
			
		
	}


}
