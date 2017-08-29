package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import been.Advice;
import been.PageBean;
import util.JdbcUtils;
import util.StringUtil;

public class AdviceDao {
	
	/**
	 * 骑行用户一览
	 * @param pageBean
	 * @param advice
	 * @return
	 * @throws Exception
	 */
	public List<Object> adviceList(PageBean pageBean,Advice advice,String afterCreateTime,String beforeCreateTime,String afterReplyTime,String beforeReplyTime )throws Exception{
		StringBuffer sb=new StringBuffer("select * from advise u ");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(advice.getAdviseId())){
			sb.append(" and u.adviseId =?");
			para.add(advice.getAdviseId());
		}
		if(StringUtil.isNotEmpty(advice.getAdminId())){
			sb.append(" and u.adminId =?");
			para.add(advice.getAdminId());
		}
		if(StringUtil.isNotEmpty(advice.getCreator())){
			sb.append(" and u.creator =?");
			para.add(advice.getCreator());
		}
		if(StringUtil.isNotEmpty(advice.getTitle())){
			sb.append(" and u.title like ?");
			para.add("%"+advice.getTitle()+"%");
		}
		if(StringUtil.isNotEmpty(advice.getContent())){
			sb.append(" and u.content like ?");
			para.add("%"+advice.getContent()+"%");
		}
		
		if(StringUtil.isNotEmpty(afterCreateTime)){
			sb.append(" and TO_SECONDS(u.createTime)>=TO_SECONDS(?)");
			para.add(afterCreateTime);
		}
		if(StringUtil.isNotEmpty(beforeCreateTime)){
			sb.append(" and TO_SECONDS(u.createTime)<=TO_SECONDS(?)");
			para.add(beforeCreateTime);
		}
		
		if(StringUtil.isNotEmpty(advice.getStatus())){
			sb.append(" and u.status =?");
			para.add(advice.getStatus());
		}
		if(StringUtil.isNotEmpty(advice.getReplyContent())){
			sb.append(" and u.replyContent like ?");
			para.add("%"+advice.getReplyContent()+"%");
		}
		
		if(StringUtil.isNotEmpty(afterReplyTime)){
			sb.append(" and TO_SECONDS(u.replyTime)>=TO_SECONDS(?)");
			para.add(afterReplyTime);
		}
		if(StringUtil.isNotEmpty(beforeReplyTime)){
			sb.append(" and TO_SECONDS(u.replyTime)<=TO_SECONDS(?)");
			para.add(beforeReplyTime);
		}
		
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		String sql = sb.toString().replaceFirst("and", "where");
		System.out.println(sql);
		List<Object> list = JdbcUtils.queryForArrObject(sql, para, Advice.class);
		return list;
	}
	
	/**
	 * 骑行用户删除
	 * @param delIds
	 * @return
	 * @throws Exception
	 */
	public int adviceDelete(String delIds)throws Exception{
		String sql="delete from advise where adviseId in(?)";
		List<Object> para = new ArrayList<Object>();
		para.add(delIds);
		return JdbcUtils.update(sql, para);
	}
	
	/**
	 * 骑行用户添加
	 * @param advice
	 * @return
	 * @throws Exception
	 */
	public boolean adviceAdd(Advice advice)throws Exception{
		StringBuffer sb= new StringBuffer("insert into advise values(");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(advice.getAdviseId())){
			sb.append(" ,?");
			para.add(advice.getAdviseId());
		}else if(advice.getAdviseId()==null){
			sb.append(" ,null");
		}
		if(StringUtil.isNotEmpty(advice.getAdminId())){
			sb.append(" ,?");
			para.add(advice.getAdminId());
		}else if(advice.getAdminId()==null){
			sb.append(" ,null");
		}
		if(StringUtil.isNotEmpty(advice.getCreator())){
			sb.append(" ,?");
			para.add(advice.getCreator());
		}
		if(StringUtil.isNotEmpty(advice.getTitle())){
			sb.append(" ,?");
			para.add(advice.getTitle());
		}
		if(StringUtil.isNotEmpty(advice.getContent())){
			sb.append(" ,?");
			para.add(advice.getContent());
		}
		if(StringUtil.isNotEmpty(advice.getCreateTime())){
			sb.append(" ,?");
			para.add(advice.getCreateTime());
		}
		if(StringUtil.isNotEmpty(advice.getStatus())){
			sb.append(" ,?");
			para.add(advice.getStatus());
		}
		if(StringUtil.isNotEmpty(advice.getReplyContent())){
			sb.append(" ,?");
			para.add(advice.getReplyContent());
		}else if(advice.getReplyContent()==null){
			sb.append(" ,null");
		}
		if(StringUtil.isNotEmpty(advice.getReplyTime())){
			sb.append(" ,?");
			para.add(advice.getReplyTime());
		}else if(advice.getReplyTime()==null){
			sb.append(" ,null");
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
	 * @param advice
	 * @return
	 * @throws Exception
	 */
	public int adviceModify(Advice advice)throws Exception{
		StringBuffer sb= new StringBuffer("update advise u ");
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(advice.getAdminId())){
			sb.append(" , u.adminId=?");
			para.add(advice.getAdminId());
		}
		if(StringUtil.isNotEmpty(advice.getCreator())){
			sb.append(" , u.creator =?");
			para.add(advice.getCreator());
		}
		if(StringUtil.isNotEmpty(advice.getTitle())){
			sb.append(" , u.title =?");
			para.add(advice.getTitle());
		}
		if(StringUtil.isNotEmpty(advice.getContent())){
			sb.append(" , u.content =?");
			para.add(advice.getContent());
		}
		if(StringUtil.isNotEmpty(advice.getCreateTime())){
			sb.append(" , u.createTime =?");
			para.add(advice.getCreateTime());
		}
		if(StringUtil.isNotEmpty(advice.getStatus())){
			sb.append(" , u.status =?");
			para.add(advice.getStatus());
		}
		if(StringUtil.isNotEmpty(advice.getReplyContent())){
			sb.append(" , u.replyContent=?");
			para.add(advice.getReplyContent());
		}
		if(StringUtil.isNotEmpty(advice.getReplyTime())){
			sb.append(" , u.replyTime=?");
			para.add(advice.getReplyTime());
		}
		sb.append(" where u.adviseId=?");
		para.add(advice.getAdviseId());
		String sql = sb.toString().replaceFirst(",", "set");
		System.out.println(sql);
		return JdbcUtils.update(sql, para);
	}
	
	public int adviceCount(Advice advice,String afterCreateTime,String beforeCreateTime,String afterReplyTime,String beforeReplyTime)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from advise u");
		
		List<Object> para = new ArrayList<Object>();
		if(StringUtil.isNotEmpty(advice.getAdviseId())){
			sb.append(" and u.adviseId =? ");
			para.add(advice.getAdviseId());
		}
		if(StringUtil.isNotEmpty(advice.getAdminId())){
			sb.append(" and u.adminId =? ");
			para.add(advice.getAdminId());
		}
		if(StringUtil.isNotEmpty(advice.getCreator())){
			sb.append(" and u.creator =?");
			para.add(advice.getCreator());
		}
		if(StringUtil.isNotEmpty(advice.getTitle())){
			sb.append(" and u.title like ?");
			para.add("%"+advice.getTitle()+"%");
		}
		if(StringUtil.isNotEmpty(advice.getContent())){
			sb.append(" and u.content like ?");
			para.add("%"+advice.getContent()+"%");
		}
		
		if(StringUtil.isNotEmpty(afterCreateTime)){
			sb.append(" and TO_SECONDS(u.createTime)>=TO_SECONDS(?)");
			para.add(afterCreateTime);
		}
		if(StringUtil.isNotEmpty(beforeCreateTime)){
			sb.append(" and TO_SECONDS(u.createTime)<=TO_SECONDS(?)");
			para.add(beforeCreateTime);
		}
		
		if(StringUtil.isNotEmpty(advice.getStatus())){
			sb.append(" and u.status=?");
			para.add(advice.getStatus());
		}
		if(StringUtil.isNotEmpty(advice.getReplyContent())){
			sb.append(" and u.replyContent like ?");
			para.add("%"+advice.getReplyContent()+"%");
		}
		
		if(StringUtil.isNotEmpty(afterReplyTime)){
			sb.append(" and TO_SECONDS(u.replyTime)>=TO_SECONDS(?)");
			para.add(afterReplyTime);
		}
		if(StringUtil.isNotEmpty(beforeReplyTime)){
			sb.append(" and TO_SECONDS(u.replyTime)<=TO_SECONDS(?)");
			para.add(beforeReplyTime);
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
