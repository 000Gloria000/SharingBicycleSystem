package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import been.Admin;
import dao.AdminDao;
import util.Connect;
import util.JdbcUtils;

public class AdminServlet extends HttpServlet{
	AdminDao adminDao = new AdminDao();
	
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
				
		Connect con = JdbcUtils.getInstance();

		// 根据获取的doWhat参数，判断业务类型，调用对应的方法处理请求并响应
		if ("add".equals(doWhat)) {
			
		} else if ("delete".equals(doWhat)) {
			
		} else if ("modify".equals(doWhat)) {
			
		} else if ("list".equals(doWhat)) {
			
		} else if ("detail".equals(doWhat)) {
			
		} else if ("toModify".equals(doWhat)) {
			
		} else if("login".equals(doWhat)){
//			获取用户名密码
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			Admin admin = new Admin(username, password);
			HttpSession session = req.getSession();
			List<Object> result = null;
			try {
//				result = adminDao.login(admin);
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				String msg = "用户名密码查询错误";
//				req.setAttribute("msg", msg);
//				req.getRequestDispatcher("login.jsp").forward(req, resp);
//				return;			
				}
			if (result!=null) {
//				查询正确，骑行用户信息验证成功
//				User userinfo = list.get(0);
//				session.setAttribute("userinfo", userinfo);
//				req.getRequestDispatcher("index.jsp").forward(req,resp);
//				return;
			} else {
//				查询正确，骑行用户信息验证失败
//				String msg = "密码错误";
//				req.setAttribute("msg", msg);
//				req.getRequestDispatcher("login.jsp").forward(req, resp);
//				return;
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
