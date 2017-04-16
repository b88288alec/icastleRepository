package com.icastle.rooms.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomsJDBCDAO implements RoomsDAO_interface {

	private final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String url = "jdbc:sqlserver://localhost:1433;DatabaseName=iCastle";
	private final String user = "sa";
	// private final String password = "sa123456";
	private final String password = "Alec88288";

	private final String INSERT_CMD = "insert into Rooms(roomTypeId, hotelId, roomDate, RoomTypeName, peopleNum, remaining, roomNumber, price, discount, offerName, breakfast, lunch, afternoonTea, bedAddable, pricePerPerson, remark) "
			+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String GET_ROOMS_BY_MONTH = "select * from Rooms where hotelId = ? and roomTypeId = ? and MONTH(roomDate) = ?";
	private final String UPDATE_CMD = "update Rooms set RoomTypeName = ?, roomNumber = ?, discount = ?, offerName = ?, breakfast = ?, lunch = ?, afternoonTea = ?, bedAddable = ?, pricePerPerson = ?, remark = ? where roomId = ?";
	private final String GET_ORDER = "update Rooms set remaining = remaining-1 where roomId = ?";
	private final String indexQueryGetRoom = "{call indexQueryGetRoom(?,?,?,?)}";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	ResultSet rs = null;

	@Override
	public int insert(List<RoomsVO> roomList) {
		int insertCount = 0;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(INSERT_CMD);

			for (RoomsVO vo : roomList) {
				pstmt.setInt(1, vo.getRoomTypeId());
				pstmt.setInt(2, vo.getHotelId());
				pstmt.setDate(3, vo.getRoomDate());
				pstmt.setString(4, vo.getRoomTypeName());
				pstmt.setInt(5, vo.getPeopleNum());
				pstmt.setInt(6, vo.getRemaining());
				pstmt.setInt(7, vo.getRoomNumber());
				pstmt.setInt(8, vo.getPrice());
				pstmt.setDouble(9, vo.getDiscount());
				pstmt.setString(10, vo.getOfferName());
				pstmt.setBoolean(11, vo.isBreakfast());
				pstmt.setBoolean(12, vo.isLunch());
				pstmt.setBoolean(13, vo.isAfternoonTea());
				pstmt.setBoolean(14, vo.isBedAddable());
				pstmt.setInt(15, vo.getPricePerPerson());
				pstmt.setString(16, vo.getRemark());

				int count = pstmt.executeUpdate();
				insertCount += count;
			}

			conn.commit();
			conn.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if (!(pstmt == null)) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (!(conn == null)) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return insertCount;
	}

	@Override
	public int update(List<RoomsVO> roomList) {
		int updateCount = 0;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(UPDATE_CMD);

			for (RoomsVO vo : roomList) {
				pstmt.setString(1, vo.getRoomTypeName());
				pstmt.setInt(2, vo.getRoomNumber());
				pstmt.setDouble(3, vo.getDiscount());
				pstmt.setString(4, vo.getOfferName());
				pstmt.setBoolean(5, vo.isBreakfast());
				pstmt.setBoolean(6, vo.isLunch());
				pstmt.setBoolean(7, vo.isAfternoonTea());
				pstmt.setBoolean(8, vo.isBedAddable());
				pstmt.setInt(9, vo.getPricePerPerson());
				pstmt.setString(10, vo.getRemark());
				pstmt.setInt(11, vo.getRoomId());

				int count = pstmt.executeUpdate();
				updateCount += count;
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if (!(pstmt == null)) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (!(conn == null)) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return updateCount;
	}

	@Override
	public List<RoomsVO> getRoomsByMonth(int hotelId, int roomTypeId, int month) {
		List<RoomsVO> list = new ArrayList<RoomsVO>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(GET_ROOMS_BY_MONTH);
			pstmt.setInt(1, hotelId);
			pstmt.setInt(2, roomTypeId);
			pstmt.setInt(3, month);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RoomsVO vo = new RoomsVO();
				vo.setRoomId(rs.getInt(1));
				vo.setRoomTypeId(rs.getInt(2));
				vo.setHotelId(rs.getInt(3));
				vo.setRoomDate(rs.getDate(4));
				vo.setRoomTypeName(rs.getString(5));
				vo.setPeopleNum(rs.getInt(6));
				vo.setRemaining(rs.getInt(7));
				vo.setRoomNumber(rs.getInt(8));
				vo.setPrice(rs.getInt(9));
				vo.setDiscount(rs.getDouble(10));
				vo.setOfferName(rs.getString(11));
				vo.setBreakfast(rs.getBoolean(12));
				vo.setLunch(rs.getBoolean(13));
				vo.setAfternoonTea(rs.getBoolean(14));
				vo.setBedAddable(rs.getBoolean(15));
				vo.setPricePerPerson(rs.getInt(16));
				vo.setRemark(rs.getString(17));

				list.add(vo);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (!(rs == null)) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (!(pstmt == null)) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (!(conn == null)) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public List<RoomsVO> findRooms(int hotelId, int peopleNum, Date star, Date end) {
		List<RoomsVO> list = new ArrayList<RoomsVO>();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			cstmt = conn.prepareCall(indexQueryGetRoom);
			cstmt.setInt(1, hotelId);
			cstmt.setDate(2, star);
			cstmt.setDate(3, end);
			cstmt.setInt(4, peopleNum);
			rs = cstmt.executeQuery();
			
			while(rs.next()){
				RoomsVO vo = new RoomsVO();
				vo.setRoomId(rs.getInt(1));
				vo.setRoomTypeId(rs.getInt(2));
				vo.setHotelId(rs.getInt(3));
				vo.setRoomDate(rs.getDate(4));
				vo.setRoomTypeName(rs.getString(5));
				vo.setPeopleNum(rs.getInt(6));
				vo.setRemaining(rs.getInt(7));
				vo.setRoomNumber(rs.getInt(8));
				vo.setPrice(rs.getInt(9));
				vo.setDiscount(rs.getDouble(10));
				vo.setOfferName(rs.getString(11));
				vo.setBreakfast(rs.getBoolean(12));
				vo.setLunch(rs.getBoolean(13));
				vo.setAfternoonTea(rs.getBoolean(14));
				vo.setBedAddable(rs.getBoolean(15));
				vo.setPricePerPerson(rs.getInt(16));
				vo.setRemark(rs.getString(17));

				list.add(vo);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (!(rs == null)) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (!(cstmt == null)) {
				try {
					cstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (!(conn == null)) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public int getOrder(List<RoomsVO> roomsList) {
		int updateCount = 0;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(GET_ORDER);
			
			for (RoomsVO vo : roomsList){
				pstmt.setInt(1, vo.getRoomId());
				int count = pstmt.executeUpdate();
				updateCount += count;
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			if (!(pstmt == null)) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (!(conn == null)) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return updateCount;
	}

}
