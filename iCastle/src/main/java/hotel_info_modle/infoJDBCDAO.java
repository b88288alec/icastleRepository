package hotel_info_modle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class infoJDBCDAO implements infoDAO_interface {
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;DatabaseName=DB01";
	String userid = "sa";
	String password = "sa123456";
	
	private static final String INSERT_STMT =
			"INSERT INTO HotelInfo (hotelId,registerName,tel,transport,website,hotelProfile,checkin,checkout,GuestPolicies,cancelPolicies"
			+ ",roomWifi,hallWifi,internet,mineralWater,toiletUtensils,hairDryer,tv,gameRoom,gym,spa,swimPool) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_STMT =
			"SELECT * FROM HotelInfo H JOIN HOTELS S ON H.hotelId = S.hotelId WHERE H.hotelId = ?";
	private static final String UPDATE =
			"UPDATE HotelInfo set registerName = ? ,tel = ? ,transport = ? ,website = ? ,hotelProfile = ? ,checkin = ? ,"
			+ "checkout = ? ,GuestPolicies = ? ,cancelPolicies = ? ,roomWifi = ? ,hallWifi = ? ,internet = ? ,mineralWater = ? ,"
			+ "toiletUtensils = ? ,hairDryer = ? ,tv = ? ,gameRoom = ? ,gym = ? ,spa = ? ,swimPool = ? ";
	//沒有hotelId的UPDATE
	
	
	@Override
	public void insert(infoVO infoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public void update(infoVO infoVO) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void select(infoVO infoVO) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public infoVO findByPrimaryKey(Integer hotelId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<infoVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
