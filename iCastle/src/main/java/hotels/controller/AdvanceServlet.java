package hotels.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hotels.model.ListVO;

@WebServlet("/view/hotel/Advance.do")
public class AdvanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdvanceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> errorMsgs = new HashMap<String, String>();
		request.setAttribute("errorMsgs", errorMsgs);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
				
		//接收參數
		request.setCharacterEncoding("UTF-8");
		String type = (String) request.getParameter("type");
		String start = (String) request.getParameter("start");
		String end = (String) request.getParameter("end");
		String peopleNumStr = (String) request.getParameter("peopleNum");
		String order = request.getParameter("order");
		Integer lowprice = Integer.parseInt(request.getParameter("lowprice"));
		Integer highprice = Integer.parseInt(request.getParameter("highprice"));
		Integer point = Integer.parseInt(request.getParameter("point"));
		Integer star = Integer.parseInt(request.getParameter("star"));
		
		//資料型態轉換(start和end)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.sql.Date startDate = null;
		try{
			startDate = new java.sql.Date(sdf.parse(start).getTime());
		} catch (ParseException e){
			errorMsgs.put("sdError", "請輸入正確日期");
		}
		
		java.sql.Date endDate = null;
		try{
			endDate = new java.sql.Date(sdf.parse(end).getTime());
		} catch (ParseException e){
			errorMsgs.put("edError", "請輸入正確日期");
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
