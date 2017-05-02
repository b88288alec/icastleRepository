package com.icastle.followers.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FollowersJNDIDAO implements FollowersDAO_interface{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT =
			"INSERT INTO Followers (name, bdate, tel, personId, email, country, addr, passport, memberId) VALUES (?,?,?,?,?,?,?,?,?)";
	
	private static final String UPDATE =
			"UPDATE Followers set name=?, bdate=?, tel=?, personId=?, email=?, country=?, addr=? ,passport=? where memberId = ?";
	
	private static final String DELETE =
			"DELETE FROM Followers where memberId = ?";
	
	private static final String GET_ALL_STMT =
			"SELECT name, bdate, tel, personId, email, country, addr, passport FROM Followers where memberId = ?";

	@Override
	public void insert(FollowersVO followersVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, followersVO.getName());
			pstmt.setDate(2, followersVO.getBdate());
			pstmt.setString(3, followersVO.getTel());
			pstmt.setString(4, followersVO.getPersonId());
			pstmt.setString(5, followersVO.getEmail());
			pstmt.setString(6, followersVO.getCountry());
			pstmt.setString(7, followersVO.getAddr());
			pstmt.setString(8, followersVO.getPassport());
			pstmt.setInt(9, followersVO.getMemberId());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
		
	

	@Override
	public void update(FollowersVO followersVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, followersVO.getName());
			pstmt.setDate(2, followersVO.getBdate());
			pstmt.setString(3, followersVO.getTel());
			pstmt.setString(4, followersVO.getPersonId());
			pstmt.setString(5, followersVO.getEmail());
			pstmt.setString(6, followersVO.getCountry());
			pstmt.setString(7, followersVO.getAddr());
			pstmt.setString(8, followersVO.getPassport());
            pstmt.setInt(9, followersVO.getMemberId());
			pstmt.executeUpdate();	


		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer memberId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, memberId);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	
	}
	@Override
	public List<FollowersVO> getAll(Integer memberId) {
		List<FollowersVO> list = new ArrayList<FollowersVO>();
		FollowersVO followersVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
		
			pstmt.setInt(1, memberId);

			rs = pstmt.executeQuery();
			

			while (rs.next()) {
				followersVO = new FollowersVO();
				
				followersVO.setName(rs.getString("name"));
				followersVO.setBdate(rs.getDate("bdate"));
				followersVO.setTel(rs.getString("tel"));
				followersVO.setPersonId(rs.getString("personId"));
				followersVO.setEmail(rs.getString("email"));
				followersVO.setCountry(rs.getString("country"));
				followersVO.setAddr(rs.getString("addr"));
				followersVO.setPassport(rs.getString("passport"));

				list.add(followersVO);
			}


		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	
	
	
}
