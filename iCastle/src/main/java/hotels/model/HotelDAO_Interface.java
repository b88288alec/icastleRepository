package hotels.model;

import java.sql.Date;
import java.util.List;

public interface HotelDAO_Interface {
	
	public HotelVO addHotel(HotelVO hotelVO);
	public HotelVO updateHotel(HotelVO hotelVO);//部分欄位的修改
	public HotelVO updateState(int hotelId, int state);
	public HotelVO findByPrimaryKey(int hotelId);
	public List<ListVO> indexQuery(String zone, Date startDate, Date endDate, int peopleNum);
	public List<ListVO> advancedQuery(String zone, Date startDate, Date endDate, int peopleNum, String order, int lowprice, int highprice, double point, int star);
	
}
