package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import been.User;
import dao.UserDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.Connect;
import util.JdbcUtils;
import util.JsonUtil;
import util.ResponseUtil;

public class UserLoginServlet extends HttpServlet{
	UserDao userDao = new UserDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		Connect con = JdbcUtils.getInstance();
		
//		获取用户名密码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new User(username, password);
		List<Map<String, String>> resultUser = null;
		JSONObject result=new JSONObject();

		try {
			resultUser = userDao.login(user);
//			JSONArray jsonArray=JsonUtil.formatMapToJsonArray(resultUser);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.put("message", "failed");
		}
		if (resultUser!=null) {
			result.put("status", 0);
			result.put("message", "success");
//			JSONArray jsonArray=JsonUtil.formatMapToJsonArray(resultUser);

//			result.put("data", );
		} else {
//			查询正确，骑行用户信息验证失败
			result.put("message", "failed");
		}
		ResponseUtil.write(resp, result);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}
