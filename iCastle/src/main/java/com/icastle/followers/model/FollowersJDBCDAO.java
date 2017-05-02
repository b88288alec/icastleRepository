package com.icastle.followers.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FollowersJDBCDAO implements FollowersDAO_interface{
	
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=iCastle";
	String userid = "sa";
	String passwd = "sa123456";
	
	private static final String INSERT_STMT =
			"INSERT INTO Followers (name, bdate, tel, personId, email, country, addr, passport, memberId) VALUES (?,?,?,?,?,?,?,?,?)";
	
	private static final String UPDATE =
			"UPDATE Followers set name=?, bdate=?, tel=?, personId=?, email=?, country=?, addr=? ,passport=? where memberId = ?";
	
	private static final String DELETE =
			"DELETE FROM Followers where memberId = ?";
	
	private static final String GET_ALL_STMT =
			"SELECT name, bdate, tel, personId, email, country, addr, passport FROM Followers where memberId = ?";
	
	
	//新增同行人
	@Override
	public void insert(FollowersVO followersVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	//修改同行人資料
	@Override
	public void update(FollowersVO followersVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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


		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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

	//刪除同行人資料
	@Override
	public void delete(Integer memberId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, memberId);

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	//查詢同行人資料	
	@Override
	public List<FollowersVO> getAll(Integer memberId) {
		List<FollowersVO> list = new ArrayList<FollowersVO>();
		FollowersVO followersVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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


		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());

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
	