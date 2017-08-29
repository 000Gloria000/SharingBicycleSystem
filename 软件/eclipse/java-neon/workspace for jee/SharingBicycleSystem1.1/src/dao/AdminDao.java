package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import been.Admin;
import been.PageBean;
import util.JdbcUtils;
import util.StringUtil;

/**
 * 管理员用户的Dao
 * @author gloria
 *
 */
public class AdminDao {
	/**
	 * 管理员用户登录
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> login(Admin admin) throws Exception{
		String sql = "select * from admin where userName=? and password=?";
		List<Object> para = new ArrayList<Object>();
		para.add(admin.getUserName());
		para.add(admin.getPassword());
//		List<Object> list = JdbcUtils.queryForArrObject(sql,para, Admin.class);
		List<Map<String, String>> result = JdbcUtils.queryForMap(sql, para);
		return result;
	}
	
	/**
	 * 管理员用户一览
	 * @param pageBean
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	public List<Object> adminList(PageBean pageBean,Admin admin)throws Exception{
		StringBuffer sb=new StringBuffer("select * from admin u ");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(admin.getAdminId())){
			sb.append(" and u.adminId =?");
			para.add(admin.getAdminId());
		}
		if(StringUtil.isNotEmpty(admin.getUserName())){
			sb.append(" and u.username like ?");
			para.add("%"+admin.getUserName()+"%");
		}
		if(StringUtil.isNotEmpty(admin.getPassword())){
			sb.append(" and u.password =?");
			para.add(admin.getPassword());
		}
		if(StringUtil.isNotEmpty(admin.getName())){
			sb.append(" and u.name like ?");
			para.add("%"+admin.getName()+"%");
		}
		if(StringUtil.isNotEmpty(admin.getAdminRoleId())){
			sb.append(" and u.adminRoleId =?");
			para.add(admin.getAdminRoleId());
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		String sql = sb.toString().replaceFirst("and", "where");
		List<Object> list = JdbcUtils.queryForArrObject(sql, para, Admin.class);
		return list;
	}
	
	/**
	 * 管理员用户删除
	 * @param delIds
	 * @return
	 * @throws Exception
	 */
	public int adminDelete(String delIds)throws Exception{
		String sql="delete from admin where adminId in(?)";
		List<Object> para = new ArrayList<Object>();
		para.add(delIds);
		return JdbcUtils.update(sql, para);
	}
	
	/**
	 * 管理员用户添加
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	public boolean adminAdd(Admin admin)throws Exception{
		StringBuffer sb= new StringBuffer("insert into admin values(");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(admin.getAdminId())){
			sb.append(" ,?");
			para.add(admin.getAdminId());
		}
		if(StringUtil.isNotEmpty(admin.getUserName())){
			sb.append(" ,?");
			para.add(admin.getUserName());
		}
		if(StringUtil.isNotEmpty(admin.getPassword())){
			sb.append(" ,?");
			para.add(admin.getPassword());
		}
		if(StringUtil.isNotEmpty(admin.getName())){
			sb.append(" ,?");
			para.add(admin.getName());
		}
		if(StringUtil.isNotEmpty(admin.getAdminRoleId())){
			sb.append(" ,?");
			para.add(admin.getAdminRoleId());
		}

		sb.append(")");
		String sql = sb.toString().replaceFirst(",", " ");
		if(1==JdbcUtils.update(sql, para)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 管理员用户修改
	 * @param con
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	public int adminModify(Admin admin)throws Exception{
		StringBuffer sb= new StringBuffer("update admin u ");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(admin.getUserName())){
			sb.append(" , u.userName=?");
			para.add(admin.getUserName());
		}
		if(StringUtil.isNotEmpty(admin.getPassword())){
			sb.append(" , u.password =?");
			para.add(admin.getPassword());
		}
		if(StringUtil.isNotEmpty(admin.getName())){
			sb.append(" , u.name =?");
			para.add(admin.getName());
		}
		if(StringUtil.isNotEmpty(admin.getAdminRoleId())){
			sb.append(" , u.adminRoleId=?");
			para.add(admin.getAdminRoleId());
		}
		sb.append(" where u.adminId=?");
		para.add(admin.getAdminId());
		String sql = sb.toString().replaceFirst(",", "set");
		return JdbcUtils.update(sql, para);
	}
	
	public int adminCount(Admin admin)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from admin u");
		
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(admin.getAdminId())){
			sb.append(" and u.adminId =? ");
			para.add(admin.getAdminId());
		}
		if(StringUtil.isNotEmpty(admin.getUserName())){
			sb.append(" and u.userName like ?");
			para.add("%"+admin.getUserName()+"%");
		}
		if(StringUtil.isNotEmpty(admin.getPassword())){
			sb.append(" and u.password =?");
			para.add(admin.getPassword());
		}
		if(StringUtil.isNotEmpty(admin.getName())){
			sb.append(" and u.name like ?");
			para.add("%"+admin.getName()+"%");
		}
		if(StringUtil.isNotEmpty(admin.getAdminRoleId())){
			sb.append(" and u.adminRoleId=?");
			para.add(admin.getAdminRoleId());
		}
		String sql = sb.toString().replaceFirst("and", "where");
		List<Map<String, String>> result  =JdbcUtils.queryForMap(sql, para);
		
		if(!result.isEmpty()){
			return Integer.parseInt(result.get(0).get("total"));
		}else{
			return 0;
		}
	}

	public Map<String, String> haveMessage(Admin admin) {
		Map<String, String> result = new HashMap<String, String>();
		String sql = "select count(*) from user where status in(2, 3)";
		List<Object> list = JdbcUtils.queryForArrObject(sql, null, String.class);
		if("0".equals(list.get(0))){
			result.put("user", "false");
		}else{
			result.put("user", "true");
		}
		sql = "select count(*) from activity where status<-1";
		list = JdbcUtils.queryForArrObject(sql, null, String.class);
		if("0".equals(list.get(0))){
			result.put("activities", "false");
		}else{
			result.put("activities", "true");
		}
		sql = "select count(*) from advise where status<-1";
		list = JdbcUtils.queryForArrObject(sql, null, String.class);
		if("0".equals(list.get(0))){
			result.put("feedback", "false");
		}else{
			result.put("feedback", "true");
		}
		return result;
	}
}
