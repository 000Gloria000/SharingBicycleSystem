package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Connect;

public class CyclingRecordServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		String doWhat = req.getParameter("doWhat");

		// pageIndex 当前所在页码
		String pageIndex = req.getParameter("pageIndex");

		// 如果页码为空，去首页
		if (pageIndex == null) {
			pageIndex = "1";
		}
				
		Connect con = Connect.getInstance();

		// 根据获取的doWhat参数，判断业务类型，调用对应的方法处理请求并响应
		if ("add".equals(doWhat)) {
			
		} else if ("delete".equals(doWhat)) {
			
		} else if ("modify".equals(doWhat)) {
			
		} else if ("list".equals(doWhat)) {
			
		} else if ("detail".equals(doWhat)) {
			
		} else if ("toModify".equals(doWhat)) {
			
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
