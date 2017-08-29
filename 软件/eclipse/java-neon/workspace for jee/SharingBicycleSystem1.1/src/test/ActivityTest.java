//package test;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Scanner;
//
//import been.Activity;
//import been.PageBean;
//import dao.ActivityDao;
//import util.DateUtil;
//
//
///**
// * 初期的测试类
// * @author gloria
// *
// */
//public class ActivityTest {
//	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in);
//		while(true){
//			System.out.println("请选择测试方法：1.list 2.delete "
//					+ "3.add 4.modify 5.count 6.exit");
//			int method = sc.nextInt();
//			ActivityDao activityDao = new ActivityDao();
//			if(method==1){
//				Activity activity = new Activity();
////				判断数据是否合法
////				activity.setActivityId("1");
////				activity.setActivityName("activity");
//				PageBean pageBean = new PageBean(1, 10); 
//				try {
//					String afterCreateTime="";
//					String beforeCreateTime="20170820100000";
//					String afterStartTime="20160101";
//					String beforeStartTime="";
//					String afterEndTime="";
//					String beforeEndTime="20170101";
//					List<Object> list = activityDao.activityList(pageBean, activity,afterCreateTime,beforeCreateTime,afterStartTime,beforeStartTime,afterEndTime,beforeEndTime);
//					if(list.isEmpty()){
//						System.out.println("没有相关用户");
//					}else{
//						for(int i=0; i<list.size(); ++i){
//							Activity result = (Activity)list.get(i);
//							System.out.println("相关用户的信息为："+result);
//						}
//					}
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else if(method==2){
//				try {
//					activityDao.activityDelete("1");
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else if(method==3){
//				Activity activity = new Activity(null,"1", "activity1","20150602","20180901","无聊");
//				String now1=DateUtil.nowTime();
//				String now2=DateUtil.parseTime(now1);
//				System.out.println(now1);
//				System.out.println(now2);
//				Date now=DateUtil.parse(now2);
//				activity.setCreateTime(now2);
//				System.out.println(now);
//				try {
//					if(activityDao.activityAdd(activity)){
//						System.out.println("添加成功");
//					}else{
//						System.out.println("添加失败");
//					}
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else if(method==4){
//				Activity activity = new Activity();
////				判断数据合法性
//				activity.setEndTime("20180201");
//				activity.setTitle("200");
//				activity.setActivityId("4");
//				try {
//					activityDao.activityModify(activity);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else if(method==5){
//				Activity activity = new Activity();
//				try {
//					String afterCreateTime="";
//					String beforeCreateTime="20170820100000";
//					String afterStartTime="20160101";
//					String beforeStartTime="";
//					String afterEndTime="";
//					String beforeEndTime="20170101"; 
//					System.out.println("用户个数为："+activityDao.activityCount(activity,afterCreateTime,beforeCreateTime,afterStartTime,beforeStartTime,afterEndTime,beforeEndTime));
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else {
//				break;
//			}
//		}
//	}
//}
