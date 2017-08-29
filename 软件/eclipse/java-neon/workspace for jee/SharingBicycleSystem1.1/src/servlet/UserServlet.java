package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import been.User;
import dao.UserDao;
import util.Connect;
import util.JdbcUtils;

public class UserServlet extends HttpServlet{
	UserDao userDao = new UserDao();

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
			String userId = req.getParameter("userId");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String name = req.getParameter("name");
			String cardNumber = req.getParameter("cardNumber");
			String score = req.getParameter("socre");
			String phone = req.getParameter("phone");
			String status = req.getParameter("status");
			String blance = req.getParameter("blance");
			User user = new User(userId, username, password, name, cardNumber, score, phone, status, blance);
			HttpSession session = req.getSession();
			boolean result = false;
			try {
				result =  userDao.userAdd(user);
			} catch (Exception e) {
				String msg = "骑行用户添加失败";
				req.setAttribute("msg", msg);
//				req.getRequestDispatcher("login.jsp").forward(req, resp);
				return;	
			}
			if(result){
				String msg = "骑行用户添加成功";
				req.setAttribute("msg", msg);
//				req.getRequestDispatcher("login.jsp").forward(req, resp);
				return;	
			}else{
				String msg = "骑行用户添加失败";
				req.setAttribute("msg", msg);
//				req.getRequestDispatcher("login.jsp").forward(req, resp);
				return;	
			}
		} else if ("delete".equals(doWhat)) {
			String delIds = req.getParameter("delIds");
			try {
				userDao.userDelete(delIds);
			} catch (Exception e) {
				String msg = "骑行用户删除失败";
				req.setAttribute("msg", msg);
//				req.getRequestDispatcher("login.jsp").forward(req, resp);
				return;	
			}
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
