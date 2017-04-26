package com.icastle.rooms.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RoomsJNDIDAO implements RoomsDAO_interface {

	private static DataSource ds = null;
	static {
	     try {
	          Context context = new InitialContext();
	                 // "java:comp/env/" + 連線池名稱 (在context.xml)
	          ds = (DataSource) context.lookup("java:comp/env/jdbc/iCastleDB");
	     } catch (NamingException e) {
	          e.printStackTrace();
	     }
	}

	private final String INSERT_CMD = "insert into Rooms(roomTypeId, hotelId, roomDate, RoomTypeName, peopleNum, bookedNum, roomNumber, price,  breakfast, dinner, afternoonTea, bedAddable, pricePerPerson, remark) "
			+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String GET_ROOMS_BY_MONTH = "select * from Rooms where hotelId = ? and roomTypeId = ? and MONTH(roomDate) = ?";
	private final String UPDATE_CMD = "update Rooms set RoomTypeName = ?, roomNumber = ?, breakfast = ?, dinner = ?, afternoonTea = ?, bedAddable = ?, pricePerPerson = ?, remark = ? where roomId = ?";
	private final String GET_ORDER = "update Rooms set bookedNum = bookedNum+1 where roomId between ? and ?";
	private final String GET_PER_PRICE = "select roomDate,price from Rooms where roomId between ? and ? order by roomDate";
	private final String indexQueryGetRoom = "{call indexQueryGetRoom(?,?,?,?)}";
	private final String UPDATE_PRICE = "UPDATE Rooms SET price = ? WHERE roomId = ?";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	ResultSet rs = null;

	@Override
	public int insert(List<RoomsVO> roomList) {
		int insertCount = 0;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(INSERT_CMD);

			for (RoomsVO vo : roomList) {
				pstmt.setInt(1, vo.getRoomTypeId());
				pstmt.setInt(2, vo.getHotelId());
				pstmt.setDate(3, vo.getRoomDate());
				pstmt.setString(4, vo.getRoomTypeName());
				pstmt.setInt(5, vo.getPeopleNum());
				pstmt.setInt(6, vo.getBookedNum());
				pstmt.setInt(7, vo.getRoomNumber());
				pstmt.setInt(8, vo.getPrice());
				pstmt.setBoolean(9, vo.isBreakfast());
				pstmt.setBoolean(10, vo.isDinner());
				pstmt.setBoolean(11, vo.isAfternoonTea());
				pstmt.setBoolean(12, vo.isBedAddable());
				pstmt.setInt(13, vo.getPricePerPerson());
				pstmt.setString(14, vo.getRemark());

				int count = pstmt.executeUpdate();
				insertCount += count;
			}

			conn.commit();
			conn.setAutoCommit(true);
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
	public int updateDetail(List<RoomsVO> roomList) {
		int updateCount = 0;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(UPDATE_CMD);

			for (RoomsVO vo : roomList) {
				pstmt.setString(1, vo.getRoomTypeName());
				pstmt.setInt(2, vo.getRoomNumber());
				pstmt.setBoolean(3, vo.isBreakfast());
				pstmt.setBoolean(4, vo.isDinner());
				pstmt.setBoolean(5, vo.isAfternoonTea());
				pstmt.setBoolean(6, vo.isBedAddable());
				pstmt.setInt(7, vo.getPricePerPerson());
				pstmt.setString(8, vo.getRemark());
				pstmt.setInt(9, vo.getRoomId());

				int count = pstmt.executeUpdate();
				updateCount += count;
			}
			conn.commit();
			conn.setAutoCommit(true);
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
			conn = ds.getConnection();
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
				vo.setBookedNum(rs.getInt(7));
				vo.setRoomNumber(rs.getInt(8));
				vo.setPrice(rs.getInt(9));
				vo.setBreakfast(rs.getBoolean(10));
				vo.setDinner(rs.getBoolean(11));
				vo.setAfternoonTea(rs.getBoolean(12));
				vo.setBedAddable(rs.getBoolean(13));
				vo.setPricePerPerson(rs.getInt(14));
				vo.setRemark(rs.getString(15));

				list.add(vo);
			}
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
			conn = ds.getConnection();
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
				vo.setBookedNum(rs.getInt(7));
				vo.setRoomNumber(rs.getInt(8));
				vo.setPrice(rs.getInt(9));
				vo.setBreakfast(rs.getBoolean(10));
				vo.setDinner(rs.getBoolean(11));
				vo.setAfternoonTea(rs.getBoolean(12));
				vo.setBedAddable(rs.getBoolean(13));
				vo.setPricePerPerson(rs.getInt(14));
				vo.setRemark(rs.getString(15));

				list.add(vo);
			}
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
	public int getOrder(int roomId, int dayNum, int roomCount) {
		int updateCount = 0;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(GET_ORDER);
			int roomIdEnd = roomId + (dayNum - 1);
			
			pstmt.setInt(1, roomCount);
			pstmt.setInt(2,roomId);
			pstmt.setInt(3,roomIdEnd);
			int count = pstmt.executeUpdate();
			updateCount += count;
			conn.commit();
			conn.setAutoCommit(true);
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
	

	@Override
	public int updatePrice(List<RoomsVO> roomsList) {
		int updateCount = 0;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(UPDATE_PRICE);
			
			for(RoomsVO vo : roomsList){
				pstmt.setInt(1, vo.getPrice());
				pstmt.setInt(2, vo.getRoomId());
				int count = pstmt.executeUpdate();
				updateCount += count;
			}
			conn.commit();
			conn.setAutoCommit(true);
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

	public Map<String,Integer> getPerPrice(int roomId, int stayDayNum) {
		Map<String,Integer> perPrice = new TreeMap<String,Integer>();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(GET_PER_PRICE);
			int roomIdEnd = roomId + (stayDayNum - 1);
			
			pstmt.setInt(1, roomId);
			pstmt.setInt(2, roomIdEnd);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String date = rs.getString(1);
				Integer price = new Integer(rs.getInt(2));
				perPrice.put(date,price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		return perPrice;
	}
}
