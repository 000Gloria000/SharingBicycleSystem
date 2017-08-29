package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import been.Admin;
import been.User;
import dao.AdminDao;
import dao.UserDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.Connect;
import util.JdbcUtils;
import util.JsonUtil;
import util.ResponseUtil;

public class AdminLoginServlet extends HttpServlet{
	AdminDao adminDao = new AdminDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		Connect con = JdbcUtils.getInstance();
		
//		获取用户名密码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Admin admin = new Admin(username, password);  //查询条件
		List<Map<String, String>> resultAdmin = null;  //查询返回的用户信息
		JSONObject result=new JSONObject();  //最终返回给前端的结果
		JSONObject dataArray = new JSONObject();
		try {
			resultAdmin = adminDao.login(admin);
			if (resultAdmin!=null) {
				result.put("status", 0);
				result.put("message", "success");
				dataArray.put("user", JsonUtil.formatMapToJsonArray(resultAdmin));
				dataArray.put("token", "");  //待定
				dataArray.put("haveMessage", adminDao.haveMessage(admin));
				result.put("data", dataArray);
			} else {
//				查询正确，骑行用户信息验证失败
				result.put("message", "failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
