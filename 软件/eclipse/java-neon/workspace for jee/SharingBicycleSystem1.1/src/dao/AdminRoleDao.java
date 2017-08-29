package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import been.AdminRole;
import been.PageBean;
import util.JdbcUtils;
import util.StringUtil;

/**
 * 管理员权限用户的Dao
 * @author gloria
 *
 */
public class AdminRoleDao {
	/**
	 * 管理员权限一览
	 * @param pageBean
	 * @param adminRole
	 * @return
	 * @throws Exception
	 */
	public List<Object> adminRoleList(PageBean pageBean,AdminRole adminRole)throws Exception{
		StringBuffer sb=new StringBuffer("select * from adminRole u ");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(adminRole.getAdminRoleId())){
			sb.append(" and u.adminRoleId =?");
			para.add(adminRole.getAdminRoleId());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireUser())){
			sb.append(" and u.requireUser = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateUser())){
			sb.append(" and u.updateUser =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireActivity())){
			sb.append(" and u.requireActivity = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateActivity())){
			sb.append(" and u.updateActivity =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireAdmin())){
			sb.append(" and u.requireAdmin = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateAdmin())){
			sb.append(" and u.updateAdmin =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireAdvice())){
			sb.append(" and u.requireAdvice = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateAdvice())){
			sb.append(" and u.updateAdvice =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireBicycle())){
			sb.append(" and u.requireBicycle = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateBicycle())){
			sb.append(" and u.updateBicycle =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireCyclingrecord())){
			sb.append(" and u.requireCyclingrecord = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateCyclingrecord())){
			sb.append(" and u.updateCyclingrecord =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireDealrecord())){
			sb.append(" and u.requireDealrecord = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateDealrecord())){
			sb.append(" and u.updateDealrecord =?");
			para.add(adminRole.getUpdateUser());
		}
		
		String sql = sb.toString().replaceFirst("and", "where");
		List<Object> list = JdbcUtils.queryForArrObject(sql, para, AdminRole.class);
		return list;
	}
	
	/**
	 * 管理员权限删除
	 * @param delIds
	 * @return
	 * @throws Exception
	 */
	public int adminRoleDelete(String delIds)throws Exception{
		String sql="delete from adminRole where adminRoleId in(?)";
		List<Object> para = new ArrayList<Object>();
		para.add(delIds);
		return JdbcUtils.update(sql, para);
	}
	
	/**
	 * 管理员权限添加
	 * @param adminRole
	 * @return
	 * @throws Exception
	 */
	public boolean adminRoleAdd(AdminRole adminRole)throws Exception{
		StringBuffer sb= new StringBuffer("insert into adminRole values(");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(adminRole.getAdminRoleId())){
			sb.append(" ,?");
			para.add(adminRole.getAdminRoleId());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireUser())){
			sb.append(" ,?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateUser())){
			sb.append(" ,?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireActivity())){
			sb.append(" ,?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateActivity())){
			sb.append(" ,?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireAdmin())){
			sb.append(" ,?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateAdmin())){
			sb.append(" ,?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireAdvice())){
			sb.append(" ,?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateAdvice())){
			sb.append(" ,?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireBicycle())){
			sb.append(" ,?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateBicycle())){
			sb.append(" ,?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireCyclingrecord())){
			sb.append(" ,?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateCyclingrecord())){
			sb.append(" ,?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireDealrecord())){
			sb.append(" ,?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateDealrecord())){
			sb.append(" ,?");
			para.add(adminRole.getUpdateUser());
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
	 * 管理员权限用户修改
	 * @param con
	 * @param adminRole
	 * @return
	 * @throws Exception
	 */
	public int adminRoleModify(AdminRole adminRole)throws Exception{
		StringBuffer sb= new StringBuffer("update adminRole u ");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(adminRole.getRequireUser())){
			sb.append(" , u.requireUser = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateUser())){
			sb.append(" , u.updateUser =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireActivity())){
			sb.append(" , u.requireActivity = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateActivity())){
			sb.append(" , u.updateActivity =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireAdmin())){
			sb.append(" , u.requireAdmin = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateAdmin())){
			sb.append(" , u.updateAdmin =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireAdvice())){
			sb.append(" , u.requireAdvice = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateAdvice())){
			sb.append(" , u.updateAdvice =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireBicycle())){
			sb.append(" , u.requireBicycle = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateBicycle())){
			sb.append(" , u.updateBicycle =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireCyclingrecord())){
			sb.append(" , u.requireCyclingrecord = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateCyclingrecord())){
			sb.append(" , u.updateCyclingrecord =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireDealrecord())){
			sb.append(" , u.requireDealrecord = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateDealrecord())){
			sb.append(" , u.updateDealrecord =?");
			para.add(adminRole.getUpdateUser());
		}
		sb.append(" where u.adminRoleId =?");
		para.add(adminRole.getAdminRoleId());
		String sql = sb.toString().replaceFirst(",", "set");
		return JdbcUtils.update(sql, para);
	}
	
	public int adminRoleCount(AdminRole adminRole)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from adminRole u");
		
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(adminRole.getAdminRoleId())){
			sb.append(" and u.adminRoleId =?");
			para.add(adminRole.getAdminRoleId());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireUser())){
			sb.append(" and u.requireUser = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateUser())){
			sb.append(" and u.updateUser =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireActivity())){
			sb.append(" and u.requireActivity = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateActivity())){
			sb.append(" and u.updateActivity =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireAdmin())){
			sb.append(" and u.requireAdmin = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateAdmin())){
			sb.append(" and u.updateAdmin =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireAdvice())){
			sb.append(" and u.requireAdvice = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateAdvice())){
			sb.append(" and u.updateAdvice =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireBicycle())){
			sb.append(" and u.requireBicycle = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateBicycle())){
			sb.append(" and u.updateBicycle =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireCyclingrecord())){
			sb.append(" and u.requireCyclingrecord = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateCyclingrecord())){
			sb.append(" and u.updateCyclingrecord =?");
			para.add(adminRole.getUpdateUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getRequireDealrecord())){
			sb.append(" and u.requireDealrecord = ?");
			para.add(adminRole.getRequireUser());
		}
		if(StringUtil.isNotEmpty(adminRole.getUpdateDealrecord())){
			sb.append(" and u.updateDealrecord =?");
			para.add(adminRole.getUpdateUser());
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
