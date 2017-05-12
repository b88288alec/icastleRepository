package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icastle.hotels.model.HotelVO;

@WebFilter( urlPatterns = { "/index.jsp" } )
public class IndexFilter implements Filter {
    public IndexFilter() {
    }
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		if (req instanceof HttpServletRequest && res instanceof HttpServletResponse) {
			request = (HttpServletRequest) req;
			response = (HttpServletResponse) res;
		}
		
		//取得session scope屬性物件
		HttpSession session = request.getSession();
		List<HotelVO> hotels = (List<HotelVO>)session.getAttribute("hotels");
		
		//如果沒有查詢過hotels
		if (hotels == null){	
			System.out.println("HI");
			RequestDispatcher rd = request.getRequestDispatcher("Index.do");
			rd.forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
