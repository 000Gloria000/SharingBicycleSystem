package test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import been.Admin;
import been.User;
import dao.AdminDao;
import dao.UserDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.Connect;
import util.JdbcUtils;
import util.JsonUtil;

public class JsonUtilTest {
	public static void main(String[] args) {
		Connect con = JdbcUtils.getInstance();
		AdminDao adminDao = new AdminDao();
//		获取用户名密码
		Admin admin = new Admin("admin", "888888");  //查询条件
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
			e.printStackTrace();

			result.put("message", "failed");
		}

		
		System.out.println(result);
	}
}
