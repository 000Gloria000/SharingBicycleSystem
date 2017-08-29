package dao;

import java.util.ArrayList;
import java.util.List;

import been.Bicycle;
import been.PageBean;
import util.JdbcUtils;
import util.StringUtil;

public class BicycleDao {
		
		/**
		 *自行车列表查询
		 * @param pageBean
		 * @param bicycle
		 * @return
		 * @throws Exception
		 */
		public List<Object> bicycleList(PageBean pageBean,Bicycle bicycle)throws Exception{
			StringBuffer sb=new StringBuffer("select * from bicycle b");
			List<Object> para = new ArrayList<Object>();
			if(StringUtil.isNotEmpty(bicycle.getBicycleId())){
				sb.append(" and b.bicycleId = ? ");
				para.add(bicycle.getBicycleId());
			}
			if(StringUtil.isNotEmpty(bicycle.getFrom())){
				sb.append(" and b.from = ? ");
				para.add(bicycle.getFrom());
			}
			
			//To-do根据将时间点查询可以改成根据时间区间查询
			if(StringUtil.isNotEmpty(bicycle.getTime())){
				sb.append(" and b.time = ? ");
				para.add(bicycle.getTime());
			}
//			
//			if(StringUtil.isNotEmpty(bicycle.getPhoto())){
//				sb.append(" and b.photo = ?");
//				para.add(bicycle.getPhoto());
//			}
			if(StringUtil.isNotEmpty(bicycle.getLockId())){
				sb.append(" and b.lockId = ? ");
				para.add(bicycle.getLockId());
			}
			if(StringUtil.isNotEmpty(bicycle.getLocationX())){
				sb.append(" and b.locationX = ? ");
				para.add(bicycle.getLocationX());
			}
			if(StringUtil.isNotEmpty(bicycle.getLocationY())){
				sb.append(" and b.locationX = ? ");
				para.add(bicycle.getLocationY());
			}
			if(StringUtil.isNotEmpty(bicycle.getStatus())){
				sb.append(" and b.status =?");
				para.add(bicycle.getStatus());
			}
			if(StringUtil.isNotEmpty(bicycle.getEnergy())){
				sb.append(" and b.energy =?");
				para.add(bicycle.getEnergy());
			}
			if(pageBean!=null){
				sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
			}
			String sql = sb.toString().replaceFirst("and", "where");
			
			List<Object> list = JdbcUtils.queryForArrObject(sql, para, Bicycle.class);
			return list;
		}
		
		/**
		 * 自行车删除
		 * @param delIds
		 * @return
		 * @throws Exception
		 */
		public int bicycleDelete(String delIds)throws Exception{
			String sql="delete from bicycle where bicycleId in(?)";
			List<Object> para = new ArrayList<Object>();
			para.add(delIds);
			return JdbcUtils.update(sql, para);
		}
		
		/**
		 * 添加自行车
		 * @param bicycle
		 * @return
		 * @throws Exception
		 */
		public int bicycleAdd(Bicycle bicycle)throws Exception{
			StringBuffer sb= new StringBuffer("insert into bicycle values(");
			List<Object> para = new ArrayList<Object>();
			if(StringUtil.isNotEmpty(bicycle.getBicycleId())){
				sb.append(" ,?");
				para.add(bicycle.getBicycleId());
			}
			if(StringUtil.isNotEmpty(bicycle.getFrom())){
				sb.append(" ,?");
				para.add(bicycle.getFrom());
			}
			if(StringUtil.isNotEmpty(bicycle.getTime())){
				sb.append(" ,?");
				para.add(bicycle.getTime());
			}
			if(StringUtil.isNotEmpty(bicycle.getPhoto())){
				sb.append(" ,?");
				para.add(bicycle.getPhoto());
			}
			if(StringUtil.isNotEmpty(bicycle.getLockId())){
				sb.append(" ,?");
				para.add(bicycle.getLockId());
			}
			if(StringUtil.isNotEmpty(bicycle.getLocationX())){
				sb.append(" ,?");
				para.add(bicycle.getLocationX());
			}
			if(StringUtil.isNotEmpty(bicycle.getLocationY())){
				sb.append(" ,?");
				para.add(bicycle.getLocationY());
			}
			if(StringUtil.isNotEmpty(bicycle.getStatus())){
				sb.append(" ,?");
				para.add(bicycle.getStatus());
			}
			if(StringUtil.isNotEmpty(bicycle.getEnergy())){
				sb.append(" ,?");
				para.add(bicycle.getEnergy());
			}
			sb.append(")");
			String sql = sb.toString().replaceFirst(",", " ");
			
			return JdbcUtils.update(sql, para);
		}
		
		/**
		 * 修改自行车
		 * @param con
		 * @param bicycle
		 * @return
		 * @throws Exception
		 */
		public int bicycleModify(Bicycle bicycle)throws Exception{
			StringBuffer sb= new StringBuffer("update bicycle b   ");
			List<Object> para = new ArrayList<Object>();
			if(StringUtil.isNotEmpty(bicycle.getFrom())){
				sb.append(" , b.from =?");
				para.add(bicycle.getFrom());
			}
			if(StringUtil.isNotEmpty(bicycle.getTime())){
				sb.append(" , b.time =?");
				para.add(bicycle.getTime());
			}
			if(StringUtil.isNotEmpty(bicycle.getPhoto())){
				sb.append(" , b.photo =?");
				para.add(bicycle.getPhoto());
			}
			if(StringUtil.isNotEmpty(bicycle.getLockId())){
				sb.append(" , b.lockId =?");
				para.add(bicycle.getLockId());
			}
			if(StringUtil.isNotEmpty(bicycle.getLocationX())){
				sb.append(" , b.locationX =? ");
				para.add(bicycle.getLocationX());
			}
			if(StringUtil.isNotEmpty(bicycle.getLocationX())){
				sb.append(" , b.locationX =? ");
				para.add(bicycle.getLocationX());
			}
			if(StringUtil.isNotEmpty(bicycle.getLocationY())){
				sb.append(" , b.locationY =? ");
				para.add(bicycle.getLocationY());
			}
			if(StringUtil.isNotEmpty(bicycle.getStatus())){
				sb.append(" , b.status=?");
				para.add(bicycle.getStatus());
			}	
			if(StringUtil.isNotEmpty(bicycle.getEnergy())){
				sb.append(" , b.energy=?");
				para.add(bicycle.getEnergy());
			}
			sb.append("where b.bicycleId=?");
			para.add(bicycle.getBicycleId());
			String sql = sb.toString().replaceFirst(",", "set");
			
			return JdbcUtils.update(sql, para);
		}
		
		public int bicycleCount(Bicycle bicycle)throws Exception{
			StringBuffer sb=new StringBuffer("select count(*) as total from bicycle b");
			
			List<Object> para = new ArrayList<Object>();
			if(StringUtil.isNotEmpty(bicycle.getBicycleId())){
				sb.append(" and b.bicycleId = ? ");
				para.add(bicycle.getBicycleId());
			}
			if(StringUtil.isNotEmpty(bicycle.getFrom())){
				sb.append(" and b.from= ? ");
				para.add(bicycle.getFrom());
			}
			if(StringUtil.isNotEmpty(bicycle.getTime())){
				sb.append(" and b.time = ? ");
				para.add(bicycle.getTime());
			}
			if(StringUtil.isNotEmpty(bicycle.getPhoto())){
				sb.append(" and b.photo = ? ");
				para.add(bicycle.getPhoto());
			}
			if(StringUtil.isNotEmpty(bicycle.getLockId())){
				sb.append(" and b.lockId =?");
				para.add(bicycle.getLockId());
			}
			if(StringUtil.isNotEmpty(bicycle.getLocationX())){
				sb.append(" and b.locationX =?");
				para.add(bicycle.getLocationX());
			}
			if(StringUtil.isNotEmpty(bicycle.getLocationY())){
				sb.append(" and b.locationY =?");
				para.add(bicycle.getLocationY());
			}
			if(StringUtil.isNotEmpty(bicycle.getStatus())){
				sb.append(" and b.status= ? " );
				para.add(bicycle.getStatus());
			}
			if(StringUtil.isNotEmpty(bicycle.getEnergy())){
				sb.append(" and b.energy=?");
				para.add(bicycle.getEnergy());
			 }
			
			String sql = sb.toString().replaceFirst("and", "where");
			
			int count = JdbcUtils.count(sql, para);
			return count;
		}

}
