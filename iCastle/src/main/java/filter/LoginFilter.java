package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.hotels.model.HotelVO;
import com.icastle.members.model.MembersVO;


public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		if(req instanceof HttpServletRequest && res instanceof HttpServletResponse){
			request = (HttpServletRequest)req;
			response = (HttpServletResponse)res;
		}
		String requestURI = request.getRequestURI();
		String queryString = request.getQueryString();
		String[] sub = requestURI.split("/");
		HttpSession session = request.getSession();
		HotelVO hotel = (HotelVO)session.getAttribute("HotelLoginOK");
		MembersVO manager = (MembersVO)session.getAttribute("ManagerLoginOK");
		MembersVO member = (MembersVO)session.getAttribute("MemberLoginOK");
		
			if(sub[2].equals("hotelcenter") && hotel == null){
				response.sendRedirect(request.getContextPath()+"/hotel/loginhotel.jsp");
				System.out.println(requestURI);
				session.setAttribute("requestURI", requestURI);
				session.setAttribute("queryString", queryString);
				return;
			}else if((sub[2].equals("orders") || sub[1].equals("members") )&& member == null){
				response.sendRedirect(request.getContextPath()+"/members/loginMembers.jsp");
//				System.out.println(requestURI);
				session.setAttribute("requestURI", requestURI);
				session.setAttribute("queryString", queryString);
				return;
			}
			
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
