package dao;

import java.util.ArrayList;
import java.util.List;

import been.Bicycle;
import been.CyclingRecord;
import been.PageBean;
import util.JdbcUtils;
import util.StringUtil;

public class CyclingRecordDao {
	/**
	 *骑行记录列表查询
	 * @param pageBean
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public List<Object> cyclingRecordList(PageBean pageBean,CyclingRecord cyclingRecord)throws Exception{
		StringBuffer sb=new StringBuffer("select * from cyclingrecord c");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(cyclingRecord.getCyclingRecordId())){
			sb.append(" and c.cyclingRecordId = ? ");
			para.add(cyclingRecord.getCyclingRecordId());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getBicycleId())){
			sb.append(" and c.bicycleId = ? ");
			para.add(cyclingRecord.getBicycleId());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getUserId())){
			sb.append(" and c.userId = ? ");
			para.add(cyclingRecord.getUserId());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getStartTime())){
			sb.append(" and c.startTime = ? ");
			para.add(cyclingRecord.getStartTime());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getEndTime())){
			sb.append(" and c.endTime = ? ");
			para.add(cyclingRecord.getEndTime());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getStartLocX())){
			sb.append(" and c.startLocX = ? ");
			para.add(cyclingRecord.getStartLocX());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getStartLocY())){
			sb.append(" and c.startLocY = ? ");
			para.add(cyclingRecord.getStartLocY());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getEndLocX())){
			sb.append(" and c.endLocX =? ");
			para.add(cyclingRecord.getEndLocX());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getEndLocY())){
			sb.append(" and c.endLocY =?");
			para.add(cyclingRecord.getEndLocY());
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		String sql = sb.toString().replaceFirst("and", "where");
		List<Object> list = JdbcUtils.queryForArrObject(sql, para, CyclingRecord.class);
		return list;
	}
	
	/**
	 * 删除骑行记录
	 * @param delIds
	 * @return
	 * @throws Exception
	 */
	public int CyclingRecordDelete(String delIds)throws Exception{
		String sql="delete from cyclingrecord where cyclingRecordId in(?)";
		List<Object> para = new ArrayList<Object>();
		para.add(delIds);
		return JdbcUtils.update(sql, para);
	}
	
	/**
	 * 添加骑行记录
	 * @param bicycle
	 * @return
	 * @throws Exception
	 */
	public int CyclingRecordAdd(CyclingRecord cyclingRecord)throws Exception{
		StringBuffer sb= new StringBuffer("insert into cyclingrecord  values( ");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(cyclingRecord.getCyclingRecordId())){
			sb.append(" ,?");
			para.add(cyclingRecord.getCyclingRecordId());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getBicycleId())){
			sb.append(" ,?");
			para.add(cyclingRecord.getBicycleId());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getUserId())){
			sb.append(" ,?");
			para.add(cyclingRecord.getUserId());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getStartTime())){
			sb.append(" ,?");
			para.add(cyclingRecord.getStartTime());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getEndTime())){
			sb.append(" ,?");
			para.add(cyclingRecord.getEndTime());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getStartLocX())){
			sb.append(" ,?");
			para.add(cyclingRecord.getStartLocX());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getStartLocY())){
			sb.append(" ,?");
			para.add(cyclingRecord.getStartLocY());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getEndLocX())){
			sb.append(" ,?");
			para.add(cyclingRecord.getEndLocX());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getEndLocY())){
			sb.append(" ,?");
			para.add(cyclingRecord.getEndLocY());
		}
		
		sb.append(")");
		String sql = sb.toString().replaceFirst(",", " ");
		
		return JdbcUtils.update(sql, para);
	}
	
	/**
	 * 修改骑行记录
	 * @param con
	 * @param cyclingRecord
	 * @return
	 * @throws Exception
	 */
	public int CyclingRecordModify(CyclingRecord cyclingRecord)throws Exception{
		StringBuffer sb= new StringBuffer("update cyclingrecord c ");
		List<Object> para = new ArrayList<Object>();

		if(StringUtil.isNotEmpty(cyclingRecord.getBicycleId())){
			sb.append(" , c.bicycleId =?");
			para.add(cyclingRecord.getBicycleId());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getUserId())){
			sb.append(" , c.userId =?");
			para.add(cyclingRecord.getUserId());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getStartTime())){
			sb.append(" , c.startTime =?");
			para.add(cyclingRecord.getStartTime());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getEndTime())){
			sb.append(" , c.endTime =?");
			para.add(cyclingRecord.getEndTime());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getStartLocX())){
			sb.append(" , c.startLocX =? ");
			para.add(cyclingRecord.getStartLocX());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getStartLocY())){
			sb.append(" , c.startLocY =? ");
			para.add(cyclingRecord.getStartLocY());
		}
		
		if(StringUtil.isNotEmpty(cyclingRecord.getEndLocX())){
			sb.append(" , c.endLocX = ? ");
			para.add(cyclingRecord.getEndLocX());
		}
		
		if(StringUtil.isNotEmpty(cyclingRecord.getEndLocY())){
			sb.append(" , c.endLocY = ? ");
			para.add(cyclingRecord.getEndLocY());
		}
		
		sb.append("where c.cyclingRecordId= ? ");
		para.add(cyclingRecord.getCyclingRecordId());
		String sql = sb.toString().replaceFirst(" , ", " set ");
		return JdbcUtils.update(sql, para);
	}
	
	public int CyclingRecordCount(CyclingRecord cyclingRecord)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from cyclingrecord c");
		
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(cyclingRecord.getCyclingRecordId())){
			sb.append(" and c.cyclingRecordId = ? ");
			para.add(cyclingRecord.getCyclingRecordId());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getBicycleId())){
			sb.append(" and c.bicybleId = ? ");
			para.add(cyclingRecord.getBicycleId());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getUserId())){
			sb.append(" and c.userId = ? ");
			para.add(cyclingRecord.getUserId());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getStartTime())){
			sb.append(" and c.startTime = ? ");
			para.add(cyclingRecord.getStartTime());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getEndTime())){
			sb.append(" and c.endTime =?");
			para.add(cyclingRecord.getEndTime());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getStartLocX())){
			sb.append(" and c.startLocX =?");
			para.add(cyclingRecord.getStartLocX());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getStartLocY())){
			sb.append(" and c.startLocY =?");
			para.add(cyclingRecord.getStartLocY());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getEndLocX())){
			sb.append(" and c.endLocX =?");
			para.add(cyclingRecord.getEndLocX());
		}
		if(StringUtil.isNotEmpty(cyclingRecord.getEndLocY())){
			sb.append(" and c.endLocY =?");
			para.add(cyclingRecord.getEndLocY());
		}
		
		String sql = sb.toString().replaceFirst("and", "where");
		
		int count = JdbcUtils.count(sql, para);
		return count;
		
	}

}
