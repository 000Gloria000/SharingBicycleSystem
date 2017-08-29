package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import been.PageBean;
import been.User;
import util.JdbcUtils;
import util.StringUtil;

/**
 * 骑行用户的Dao
 * @author gloria
 *
 */
public class UserDao {
	/**
	 * 骑行用户登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> login(User user) throws Exception{
		String sql = "select * from user where username=? and password=?";
		List<Object> para = new ArrayList<Object>();
		para.add(user.getUserName());
		para.add(user.getPassword());
//		List<Object> list = JdbcUtils.queryForArrObject(sql,para, User.class);
		List<Map<String, String>> result = JdbcUtils.queryForMap(sql, para);
		return result;
	}
	
	/**
	 * 骑行用户一览
	 * @param pageBean
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<Object> userList(PageBean pageBean,User user)throws Exception{
		StringBuffer sb=new StringBuffer("select * from user u ");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(user.getUserId())){
			sb.append(" and u.userId =?");
			para.add(user.getUserId());
		}
		if(StringUtil.isNotEmpty(user.getUserName())){
			sb.append(" and u.username like ?");
			para.add("%"+user.getUserName()+"%");
		}
		if(StringUtil.isNotEmpty(user.getPassword())){
			sb.append(" and u.password =?");
			para.add(user.getPassword());
		}
		if(StringUtil.isNotEmpty(user.getName())){
			sb.append(" and u.name like ?");
			para.add("%"+user.getName()+"%");
		}
		if(StringUtil.isNotEmpty(user.getCardNumber())){
			sb.append(" and u.cardNumber =?");
			para.add(user.getCardNumber());
		}
		if(StringUtil.isNotEmpty(user.getScore())){
			sb.append(" and u.score =?");
			para.add(user.getScore());
		}
		if(StringUtil.isNotEmpty(user.getPhone())){
			sb.append(" and u.phone =?");
			para.add(user.getPhone());
		}
		if(StringUtil.isNotEmpty(user.getStatus())){
			sb.append(" and u.status =?");
			para.add(user.getStatus());
		}
		if(StringUtil.isNotEmpty(user.getBalance())){
			sb.append(" and u.balance =?");
			para.add(user.getBalance());
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		String sql = sb.toString().replaceFirst("and", "where");
		List<Object> list = JdbcUtils.queryForArrObject(sql, para, User.class);
		return list;
	}
	
	/**
	 * 骑行用户删除
	 * @param delIds
	 * @return
	 * @throws Exception
	 */
	public int userDelete(String delIds)throws Exception{
		String sql="delete from user where userId in(?)";
		List<Object> para = new ArrayList<Object>();
		para.add(delIds);
		return JdbcUtils.update(sql, para);
	}
	
	/**
	 * 骑行用户添加
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean userAdd(User user)throws Exception{
		StringBuffer sb= new StringBuffer("insert into user values(");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(user.getUserId())){
			sb.append(" ,?");
			para.add(user.getUserId());
		}else if(user.getUserId()==null){
			sb.append(" ,null");
		}
		if(StringUtil.isNotEmpty(user.getUserName())){
			sb.append(" ,?");
			para.add(user.getUserName());
		}
		if(StringUtil.isNotEmpty(user.getPassword())){
			sb.append(" ,?");
			para.add(user.getPassword());
		}
		if(StringUtil.isNotEmpty(user.getName())){
			sb.append(" ,?");
			para.add(user.getName());
		}
		if(StringUtil.isNotEmpty(user.getCardNumber())){
			sb.append(" ,?");
			para.add(user.getCardNumber());
		}
		if(StringUtil.isNotEmpty(user.getScore())){
			sb.append(" ,?");
			para.add(user.getScore());
		}
		if(StringUtil.isNotEmpty(user.getPhone())){
			sb.append(" ,?");
			para.add(user.getPhone());
		}
		if(StringUtil.isNotEmpty(user.getStatus())){
			sb.append(" ,?");
			para.add(user.getStatus());
		}
		if(StringUtil.isNotEmpty(user.getBalance())){
			sb.append(" ,?");
			para.add(user.getBalance());
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
	 * 骑行用户修改
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int userModify(User user)throws Exception{
		StringBuffer sb= new StringBuffer("update user u ");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(user.getUserName())){
			sb.append(" , u.username=?");
			para.add(user.getUserName());
		}
		if(StringUtil.isNotEmpty(user.getPassword())){
			sb.append(" , u.password =?");
			para.add(user.getPassword());
		}
		if(StringUtil.isNotEmpty(user.getName())){
			sb.append(" , u.name =?");
			para.add(user.getName());
		}
		if(StringUtil.isNotEmpty(user.getCardNumber())){
			sb.append(" , u.cardNumber =?");
			para.add(user.getCardNumber());
		}
		if(StringUtil.isNotEmpty(user.getScore())){
			sb.append(" , u.score =?");
			para.add(user.getScore());
		}
		if(StringUtil.isNotEmpty(user.getPhone())){
			sb.append(" , u.phone =?");
			para.add(user.getPhone());
		}
		if(StringUtil.isNotEmpty(user.getStatus())){
			sb.append(" , u.status=?");
			para.add(user.getStatus());
		}
		if(StringUtil.isNotEmpty(user.getBalance())){
			sb.append(" , u.balance=?");
			para.add(user.getBalance());
		}
		sb.append(" where u.userId=?");
		para.add(user.getUserId());
		String sql = sb.toString().replaceFirst(",", "set");
		System.out.println(sql);
		return JdbcUtils.update(sql, para);
	}
	
	public int userCount(User user)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from user u");
		
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(user.getUserId())){
			sb.append(" and u.userId =? ");
			para.add(user.getUserId());
		}
		if(StringUtil.isNotEmpty(user.getUserName())){
			sb.append(" and u.username like ?");
			para.add("%"+user.getUserName()+"%");
		}
		if(StringUtil.isNotEmpty(user.getPassword())){
			sb.append(" and u.password =?");
			para.add(user.getPassword());
		}
		if(StringUtil.isNotEmpty(user.getName())){
			sb.append(" and u.name like ?");
			para.add("%"+user.getName()+"%");
		}
		if(StringUtil.isNotEmpty(user.getCardNumber())){
			sb.append(" and u.cardNumber =?");
			para.add(user.getCardNumber());
		}
		if(StringUtil.isNotEmpty(user.getScore())){
			sb.append(" and u.score =?");
			para.add(user.getScore());
		}
		if(StringUtil.isNotEmpty(user.getPhone())){
			sb.append(" and u.phone =?");
			para.add(user.getPhone());
		}
		if(StringUtil.isNotEmpty(user.getStatus())){
			sb.append(" and u.status=?");
			para.add(user.getStatus());
		}
		if(StringUtil.isNotEmpty(user.getBalance())){
			sb.append(" and u.balance=?");
			para.add(user.getBalance());
		}
		String sql = sb.toString().replaceFirst("and", "where");
		List<Map<String, String>> result  =JdbcUtils.queryForMap(sql, para);
		
		if(!result.isEmpty()){
			return Integer.parseInt(result.get(0).get("total"));
		}else{
			return 0;
		}
	}
}
