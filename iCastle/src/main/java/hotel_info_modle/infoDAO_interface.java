package hotel_info_modle;

import java.util.List;

public interface infoDAO_interface  {
	public void insert(infoVO infoVO);
	public void update(infoVO infoVO);
	public infoVO findByHotelId(Integer hotelId);
	public List<infoVO> findByHotelIds(List<Integer> hotelId);
}
