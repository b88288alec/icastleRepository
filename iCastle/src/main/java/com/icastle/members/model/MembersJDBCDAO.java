package com.icastle.members.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembersJDBCDAO implements MembersDAO_interface{

	
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=iCastle";
	String userid = "sa";
	String passwd = "sa123456";
	
	
	private static final String INSERT_STMT =
			"INSERT INTO Members (email,pw,name,gender,bdate,addr,tel,personId,country,passport) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT =
			"SELECT memberId,email,pw,name,gender,bdate,addr,tel,personId,country,passport FROM Members order by email";
	private static final String GET_ONE_STMT =
			"SELECT memberId,email,pw,name,gender,bdate,addr,tel,personId,country,passport FROM Members where email = ?";
//	private static final String DELETE =
//			"DELETE FROM Members where email = ?";
	private static final String UPDATE =
			"UPDATE Members set email=?, pw=?, name=?, gender=?, bdate=?, addr=?, tel=?, personId=?, country=?, passport=? where memberId = ?";
	private static final String LOGIN = 
			"SELECT * FROM Members WHERE email = ? AND pw = ?";
	
	
//  新增會員
	@Override
	public void insert(MembersVO membersVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, membersVO.getEmail());
			pstmt.setString(2, membersVO.getPw());
			pstmt.setString(3, membersVO.getName());
			pstmt.setString(4, membersVO.getGender());
			pstmt.setDate(5, membersVO.getBdate());
			pstmt.setString(6, membersVO.getAddr());
			pstmt.setString(7, membersVO.getTel());
			pstmt.setString(8, membersVO.getPersonId());
			pstmt.setString(9, membersVO.getCountry());
			pstmt.setString(10, membersVO.getPassport());
			
		
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
		

//  更新會員
	@Override
	public void update(MembersVO membersVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, membersVO.getEmail());
			pstmt.setString(2, membersVO.getPw());
			pstmt.setString(3, membersVO.getName());
			pstmt.setString(4, membersVO.getGender());
			pstmt.setDate(5, membersVO.getBdate());
			pstmt.setString(6, membersVO.getAddr());
			pstmt.setString(7, membersVO.getTel());
			pstmt.setString(8, membersVO.getPersonId());
			pstmt.setString(9, membersVO.getCountry());
			pstmt.setString(10, membersVO.getPassport());
			pstmt.setInt(11, membersVO.getMemberId());
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

		

//  刪除會員	
//	@Override
//	public void delete(String email) {
//		
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(DELETE);
//
//			pstmt.setString(1, email);
//
//			pstmt.executeUpdate();
//
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//
//	}
		
		

		
		
//  查詢會員一筆
	@Override
	public MembersVO findByPrimaryKey(String email) {
		
		
		MembersVO membersVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				membersVO = new MembersVO();
				membersVO.setMemberId(rs.getInt("memberId"));
				membersVO.setEmail(rs.getString("email"));
				membersVO.setPw(rs.getString("pw"));
				membersVO.setName(rs.getString("name"));
				membersVO.setGender(rs.getString("gender"));
				membersVO.setBdate(rs.getDate("bdate"));
				membersVO.setAddr(rs.getString("addr"));
				membersVO.setTel(rs.getString("tel"));
				membersVO.setPersonId(rs.getString("personId"));
				membersVO.setCountry(rs.getString("country"));
				membersVO.setPassport(rs.getString("passport"));
		
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
		return membersVO;
	}	
		
		
		

//  查詢會員多筆
	@Override
	public List<MembersVO> getAll() {
		List<MembersVO> list = new ArrayList<MembersVO>();
		MembersVO membersVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				membersVO = new MembersVO();
				membersVO.setMemberId(rs.getInt("memberId"));
				membersVO.setEmail(rs.getString("email"));
				membersVO.setPw(rs.getString("pw"));
				membersVO.setName(rs.getString("name"));
				membersVO.setGender(rs.getString("gender"));
				membersVO.setBdate(rs.getDate("bdate"));
				membersVO.setAddr(rs.getString("addr"));
				membersVO.setTel(rs.getString("tel"));
				membersVO.setPersonId(rs.getString("personId"));
				membersVO.setCountry(rs.getString("country"));
				membersVO.setPassport(rs.getString("passport"));
			
				
				list.add(membersVO);
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


	@Override
	public MembersVO login(String email, String pw) {
		
		MembersVO membersVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(LOGIN);

			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				membersVO = new MembersVO();
				membersVO.setMemberId(rs.getInt("memberId"));
				membersVO.setEmail(rs.getString("email"));
				membersVO.setPw(rs.getString("pw"));
				membersVO.setName(rs.getString("name"));
				membersVO.setGender(rs.getString("gender"));
				membersVO.setBdate(rs.getDate("bdate"));
				membersVO.setAddr(rs.getString("addr"));
				membersVO.setTel(rs.getString("tel"));
				membersVO.setPersonId(rs.getString("personId"));
				membersVO.setCountry(rs.getString("country"));
				membersVO.setPassport(rs.getString("passport"));
		
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
		return membersVO;
	}	


	
//	public static void main(String[] args) {
	
		
		
//		MembersJDBCDAO dao1 = new MembersJDBCDAO();
		
		
//		新增
//		MembersVO mem1 = new MembersVO();
//		mem1.setEmail("abc@yahoo.com.tw");
//		mem1.setPw("123");
//		mem1.setName("TAKA");
//		mem1.setGender("男");
//		mem1.setBdate(java.sql.Date.valueOf("2017-04-15"));
//		mem1.setAddr("台北市忠孝東路一段150號");
//		mem1.setTel("0977777777");
//		mem1.setPersonId("A123456789");
//		mem1.setCountry("台灣");
//		mem1.setPassport("789632145");
//		dao1.insert(mem1);
//		System.out.println("新增成功");

		
//		修改
//	    MembersVO mem2 = new MembersVO();
//	    mem2.setMemberId(4);
//	    mem2.setEmail("abc@yahoo.com.tw");
//	    mem2.setPw("123");
//	    mem2.setName("HYDE");
//	    mem2.setGender("男");
//	    mem2.setBdate(java.sql.Date.valueOf("2017-04-15"));
//	    mem2.setAddr("台北市忠孝東路一段150號");
//	    mem2.setTel("0977777777");
//	    mem2.setPersonId("A123456789");
//	    mem2.setCountry("台灣");
//	    mem2.setPassport("789632145");

		
//	    dao1.update(mem2);
//	    System.out.println("修改成功");
		
		
//      刪除
//		dao1.delete(2);
//		System.out.println("刪除成功");

		
//      查詢
//		MembersVO mem3 = dao1.findByPrimaryKey(1);
//		System.out.println(mem3.getMemberId() + ",");
//		System.out.println(mem3.getEmail() + ",");
//		System.out.println(mem3.getPw() + ",");
//		System.out.println(mem3.getName() + ",");
//		System.out.println(mem3.getGender() + ",");
//		System.out.println(mem3.getBdate() + ",");
//		System.out.println(mem3.getAddr()+ ",");
//		System.out.println(mem3.getTel()+ ",");
//		System.out.println(mem3.getPersonId()+ ",");
//		System.out.println(mem3.getCountry()+ ",");
//		System.out.println(mem3.getPassport());
//		System.out.println("---------------------");
		
		
//		查詢	
//		List<MembersVO> list = dao1.getAll();
//		for (MembersVO aMembers : list) {
//			System.out.println(aMembers.getMemberId() + ",");
//			System.out.println(aMembers.getEmail() + ",");
//			System.out.println(aMembers.getPw() + ",");
//			System.out.println(aMembers.getName() + ",");
//			System.out.println(aMembers.getGender() + ",");
//			System.out.println(aMembers.getBdate() + ",");
//			System.out.println(aMembers.getAddr() + ",");
//			System.out.println(aMembers.getTel() + ",");
//			System.out.println(aMembers.getPersonId() + ",");
//			System.out.println(aMembers.getCountry() + ",");
//			System.out.println(aMembers.getPassport());
//			System.out.println();
//		}
//	    
	    
//	}

}
