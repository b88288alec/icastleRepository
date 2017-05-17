package com.icastle.members.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.icastle.hotels.model.HotelVO;

public class MembersJNDIDAO implements MembersDAO_interface {
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/iCastleDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT =
			"INSERT INTO Members (email,pw,name,gender,bdate,addr,tel,personId,country,passport) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT =
			"SELECT memberId,email,pw,name,gender,bdate,addr,tel,personId,country,passport,manager,suspension FROM Members order by email";
	private static final String GET_ONE_STMT =
			"SELECT memberId,email,pw,name,gender,bdate,addr,tel,personId,country,passport,manager,suspension FROM Members where email = ?";
//	private static final String DELETE =
//			"DELETE FROM Members where email = ?";
	private static final String UPDATE =
			"UPDATE Members set email=?, pw=?, name=?, gender=?, bdate=?, addr=?, tel=?, personId=?, country=?, passport=? where memberId = ?";
	private static final String LOGIN = 
			"SELECT * FROM Members WHERE email = ? AND pw = ?";
	private static final String LINELOGIN =
			"SELECT * FROM Members WHERE name = ? AND pw = ?";
	private static final String FINDBYEMAIL = 
			"SELECT email FROM Members where email = ?";
	
	private static final String SEARCHBYNAME = 
			"SELECT memberId,email,pw,name,gender,bdate,addr,tel,personId,country,passport,manager,suspension FROM Members where name like ?";
	private static final String SUSPENSION = 
			"update Members set suspension = ? where memberid = ?";
	private static final String SETMANAGER = 
			"update Members set manager = ? where memberid = ?";
	private static final String SEARCHMANAGER = 
			"SELECT memberId,email,pw,name,gender,bdate,addr,tel,personId,country,passport,manager,suspension FROM Members where manager=1";
	
	@Override
	public void insert(MembersVO membersVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
	
	try {

		con = ds.getConnection();
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
public void update(MembersVO membersVO) {

	Connection con = null;
	PreparedStatement pstmt = null;

	try {

		con = ds.getConnection();
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

	

	
//@Override
//public void delete(String email) {
//	
//	
//	Connection con = null;
//	PreparedStatement pstmt = null;
//
//	try {
//
//		con = ds.getConnection();
//		pstmt = con.prepareStatement(DELETE);
//
//		pstmt.setString(1, email);
//
//		pstmt.executeUpdate();
//
//	} catch (SQLException se) {
//		throw new RuntimeException("A database error occured. "
//				+ se.getMessage());
//		// Clean up JDBC resources
//	} finally {
//		if (pstmt != null) {
//			try {
//				pstmt.close();
//			} catch (SQLException se) {
//				se.printStackTrace(System.err);
//			}
//		}
//		if (con != null) {
//			try {
//				con.close();
//			} catch (Exception e) {
//				e.printStackTrace(System.err);
//			}
//		}
//	}
//
//}
	

	
	

@Override
public MembersVO findByPrimaryKey(String email) {
	
	
	MembersVO membersVO = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {

		con = ds.getConnection();
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
			membersVO.setManager(rs.getBoolean("manager"));
			membersVO.setSuspension(rs.getBoolean("suspension"));
	
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
	return membersVO;
}
	
	
	


@Override
public List<MembersVO> getAll() {
	List<MembersVO> list = new ArrayList<MembersVO>();
	MembersVO membersVO = null;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {

		con = ds.getConnection();
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
			membersVO.setManager(rs.getBoolean("manager"));
			membersVO.setSuspension(rs.getBoolean("suspension"));
		
			
			list.add(membersVO);
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



@Override
public MembersVO login(String email, String pw) {
	MembersVO membersVO = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {

		con = ds.getConnection();
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
			membersVO.setManager(rs.getBoolean("manager"));
			membersVO.setSuspension(rs.getBoolean("suspension"));
	
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
	return membersVO;
}



@Override
public MembersVO lineLogin(String name, String pw) {

	MembersVO membersVO = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {

		con = ds.getConnection();
		pstmt = con.prepareStatement(LINELOGIN);

		pstmt.setString(1, name);
		pstmt.setString(2, pw);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			membersVO = new MembersVO();
			membersVO.setMemberId(rs.getInt("memberId"));
		    membersVO.setPw(rs.getString("pw"));
			membersVO.setName(rs.getString("name"));
		
	
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
	return membersVO;
}



@Override
public MembersVO findByEmail(String email) {
	MembersVO membersVO = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {

		con = ds.getConnection();
		pstmt = con.prepareStatement(FINDBYEMAIL);

		pstmt.setString(1, email);

		rs = pstmt.executeQuery();
		

		while (rs.next()) {
			membersVO = new MembersVO();
			membersVO.setEmail(rs.getString("email"));
			
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
	return membersVO;
}



@Override
public List<MembersVO> search_by_name(String name) {

	List<MembersVO> result = new LinkedList<MembersVO>();
	Connection conn = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;
	
	try{
		conn = ds.getConnection();
		pstat = conn.prepareStatement(SEARCHBYNAME);
		pstat.setString(1, name);
		
		rs = pstat.executeQuery();
		while(rs.next()){
			MembersVO membersVO = new MembersVO();
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
			membersVO.setManager(rs.getBoolean("manager"));
			membersVO.setSuspension(rs.getBoolean("suspension"));
			
			result.add(membersVO);
		}
		
	}catch(SQLException e){
		throw new RuntimeException("A database error occured. "
				+ e.getMessage());
		// Clean up JDBC resources
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstat != null) {
			try {
				pstat.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
	
	return result;
}



@Override
public void suspension(Integer memberId, Boolean suspension) {
	
	Connection conn = null;
	PreparedStatement pstat = null;
	
	try{
		conn = ds.getConnection();
		pstat = conn.prepareStatement(SUSPENSION);
		pstat.setBoolean(1, suspension);
		pstat.setInt(2, memberId);

		pstat.executeUpdate();
		
	}catch(SQLException e){
		throw new RuntimeException("A database error occured. "
				+ e.getMessage());
		// Clean up JDBC resources
	} finally {
		if (pstat != null) {
			try {
				pstat.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
	
}



@Override
public void setManager(Integer memberId, Boolean manager) {

	Connection conn = null;
	PreparedStatement pstat = null;
	
	try{
		conn = ds.getConnection();
		pstat = conn.prepareStatement(SETMANAGER);
		pstat.setBoolean(1, manager);
		pstat.setInt(2, memberId);

		pstat.executeUpdate();
		
	}catch(SQLException e){
		throw new RuntimeException("A database error occured. "
				+ e.getMessage());
		// Clean up JDBC resources
	} finally {
		if (pstat != null) {
			try {
				pstat.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
	
}



@Override
public List<MembersVO> search_manager() {
	List<MembersVO> result = new LinkedList<MembersVO>();
	Connection conn = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;
	
	try{
		conn = ds.getConnection();
		pstat = conn.prepareStatement(SEARCHMANAGER);
		
		rs = pstat.executeQuery();
		while(rs.next()){
			MembersVO membersVO = new MembersVO();
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
			membersVO.setManager(rs.getBoolean("manager"));
			membersVO.setSuspension(rs.getBoolean("suspension"));
			
			result.add(membersVO);
		}
		
	}catch(SQLException e){
		throw new RuntimeException("A database error occured. "
				+ e.getMessage());
		// Clean up JDBC resources
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstat != null) {
			try {
				pstat.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
	
	return result;
}
	


}
