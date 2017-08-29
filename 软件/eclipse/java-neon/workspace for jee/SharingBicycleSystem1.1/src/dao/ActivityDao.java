package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import been.Activity;
import been.PageBean;
import util.JdbcUtils;
import util.StringUtil;

public class ActivityDao {
	
	/**
	 * 楠戣鐢ㄦ埛涓�瑙�
	 * @param pageBean
	 * @param activity
	 * @return
	 * @throws Exception
	 */
	public List<Object> activityList(PageBean pageBean,Activity activity,String afterCreateTime,String beforeCreateTime,String afterStartTime,String beforeStartTime,String afterEndTime,String beforeEndTime)throws Exception{
		StringBuffer sb=new StringBuffer("select * from activity u ");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(activity.getActivityId())){
			sb.append(" and u.activityId =?");
			para.add(activity.getActivityId());
		}
		if(StringUtil.isNotEmpty(activity.getUserId())){
			sb.append(" and u.userId =?");
			para.add(activity.getUserId());
		}
		if(StringUtil.isNotEmpty(activity.getTitle())){
			sb.append(" and u.title like ?");
			para.add("%"+activity.getTitle()+"%");
		}
		
		
		if(StringUtil.isNotEmpty(afterCreateTime)){
			sb.append(" and TO_SECONDS(u.createTime)>=TO_SECONDS(?)");
			para.add(afterCreateTime);
		}
		if(StringUtil.isNotEmpty(beforeCreateTime)){
			sb.append(" and TO_SECONDS(u.createTime)<=TO_SECONDS(?)");
			para.add(beforeCreateTime);
		}
		
		
		if(StringUtil.isNotEmpty(afterStartTime)){
			sb.append(" and TO_SECONDS(u.startTime)>=TO_SECONDS(?)");
			para.add(afterStartTime);
		}
		if(StringUtil.isNotEmpty(beforeStartTime)){
			sb.append(" and TO_SECONDS(u.startTime)<=TO_SECONDS(?)");
			para.add(beforeStartTime);
		}
		
		if(StringUtil.isNotEmpty(afterEndTime)){
			sb.append(" and TO_SECONDS(u.endTime)>=TO_SECONDS(?)");
			para.add(afterEndTime);
		}
		if(StringUtil.isNotEmpty(beforeEndTime)){
			sb.append(" and TO_SECONDS(u.endTime)<=TO_SECONDS(?)");
			para.add(beforeEndTime);
		}
			
		
		if(StringUtil.isNotEmpty(activity.getDescription())){
			sb.append(" and u.description like ?");
			para.add("%"+activity.getDescription()+"%");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		String sql = sb.toString().replaceFirst("and", "where");
		System.out.println(sql);
		System.out.println(para);
		List<Object> list = JdbcUtils.queryForArrObject(sql, para, Activity.class);
		return list;
	}
	
	/**
	 * 楠戣鐢ㄦ埛鍒犻櫎
	 * @param delIds
	 * @return
	 * @throws Exception
	 */
	public int activityDelete(String delIds)throws Exception{
		String sql="delete from activity where activityId in(?)";
		List<Object> para = new ArrayList<Object>();
		para.add(delIds);
		return JdbcUtils.update(sql, para);
	}
	
	/**
	 * 楠戣鐢ㄦ埛娣诲姞
	 * @param activity
	 * @return
	 * @throws Exception
	 */
	public boolean activityAdd(Activity activity)throws Exception{
		StringBuffer sb= new StringBuffer("insert into activity values(");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(activity.getActivityId())){
			sb.append(" ,?");
			para.add(activity.getActivityId());
		}else if(activity.getActivityId()==null){
			sb.append(" ,null");
		}
		if(StringUtil.isNotEmpty(activity.getUserId())){
			sb.append(" ,?");
			para.add(activity.getUserId());
		}
		if(StringUtil.isNotEmpty(activity.getTitle())){
			sb.append(" ,?");
			para.add(activity.getTitle());
		}
		if(StringUtil.isNotEmpty(activity.getCreateTime())){
			sb.append(" ,?");
			para.add(activity.getCreateTime());
		}
		if(StringUtil.isNotEmpty(activity.getStartTime())){
			sb.append(" ,?");
			para.add(activity.getStartTime());
		}else if(activity.getStartTime()==null){
			sb.append(" ,null");
		}
		if(StringUtil.isNotEmpty(activity.getEndTime())){
			sb.append(" ,?");
			para.add(activity.getEndTime());
		}else if(activity.getEndTime()==null){
			sb.append(" ,null");
		}
		if(StringUtil.isNotEmpty(activity.getDescription())){
			sb.append(" ,?");
			para.add(activity.getDescription());
		}
		
		sb.append(")");
		String sql = sb.toString().replaceFirst(",", " ");
		System.out.println(sql);
		System.out.println(para);
		if(1==JdbcUtils.update(sql, para)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 楠戣鐢ㄦ埛淇敼
	 * @param con
	 * @param activity
	 * @return
	 * @throws Exception
	 */
	public int activityModify(Activity activity)throws Exception{
		StringBuffer sb= new StringBuffer("update activity u ");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(activity.getUserId())){
			sb.append(" , u.userId=?");
			para.add(activity.getUserId());
		}
		if(StringUtil.isNotEmpty(activity.getTitle())){
			sb.append(" , u.title =?");
			para.add(activity.getTitle());
		}
		if(StringUtil.isNotEmpty(activity.getCreateTime())){
			sb.append(" , u.createTime =?");
			para.add(activity.getCreateTime());
		}
		if(StringUtil.isNotEmpty(activity.getStartTime())){
			sb.append(" , u.startTime =?");
			para.add(activity.getStartTime());
		}
		if(StringUtil.isNotEmpty(activity.getEndTime())){
			sb.append(" , u.endTime =?");
			para.add(activity.getEndTime());
		}
		if(StringUtil.isNotEmpty(activity.getDescription())){
			sb.append(" , u.description =?");
			para.add(activity.getDescription());
		}
		
		sb.append(" where u.activityId=?");
		para.add(activity.getActivityId());
		String sql = sb.toString().replaceFirst(",", "set");
		System.out.println(sql);
		return JdbcUtils.update(sql, para);
	}
	
	public int activityCount(Activity activity,String afterCreateTime,String beforeCreateTime,String afterStartTime,String beforeStartTime,String afterEndTime,String beforeEndTime)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from activity u");
		
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(activity.getActivityId())){
			sb.append(" and u.activityId =? ");
			para.add(activity.getActivityId());
		}
		if(StringUtil.isNotEmpty(activity.getUserId())){
			sb.append(" and u.userId =? ");
			para.add(activity.getUserId());
		}
		if(StringUtil.isNotEmpty(activity.getTitle())){
			sb.append(" and u.title like ?");
			para.add("%"+activity.getTitle()+"%");
		}
		if(StringUtil.isNotEmpty(afterCreateTime)){
			sb.append(" and TO_SECONDS(u.createTime)>=TO_SECONDS(?)");
			para.add(afterCreateTime);
		}
		if(StringUtil.isNotEmpty(beforeCreateTime)){
			sb.append(" and TO_SECONDS(u.createTime)<=TO_SECONDS(?)");
			para.add(beforeCreateTime);
		}
		
		
		if(StringUtil.isNotEmpty(afterStartTime)){
			sb.append(" and TO_SECONDS(u.startTime)>=TO_SECONDS(?)");
			para.add(afterStartTime);
		}
		if(StringUtil.isNotEmpty(beforeStartTime)){
			sb.append(" and TO_SECONDS(u.startTime)<=TO_SECONDS(?)");
			para.add(beforeStartTime);
		}
		
		if(StringUtil.isNotEmpty(afterEndTime)){
			sb.append(" and TO_SECONDS(u.endTime)>=TO_SECONDS(?)");
			para.add(afterEndTime);
		}
		if(StringUtil.isNotEmpty(beforeEndTime)){
			sb.append(" and TO_SECONDS(u.endTime)<=TO_SECONDS(?)");
			para.add(beforeEndTime);
		}
		if(StringUtil.isNotEmpty(activity.getDescription())){
			sb.append(" and u.description like ?");
			para.add("%"+activity.getDescription()+"%");
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
