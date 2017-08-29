//package test;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Scanner;
//
//import been.Advice;
//import been.PageBean;
//import dao.AdviceDao;
//import util.DateUtil;
//
//
///**
// * 初期的测试类
// * @author gloria
// *
// */
//public class AdviceTest {
//	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in);
//		while(true){
//			System.out.println("请选择测试方法：1.list 2.delete "
//					+ "3.add 4.modify 5.count 6.exit");
//			int method = sc.nextInt();
//			AdviceDao adviceDao = new AdviceDao();
//			if(method==1){
//				Advice advice = new Advice();
////				判断数据是否合法
////				advice.setAdviceId("1");
////				advice.setAdviceName("advice");
//				PageBean pageBean = new PageBean(1, 10); 
//				try {
//					String afterCreateTime="20170819101953";
//					String beforeCreateTime="";
//					String afterReplyTime="";
//					String beforeReplyTime="";
//					List<Object> list = adviceDao.adviceList(pageBean, advice,afterCreateTime,beforeCreateTime,afterReplyTime,beforeReplyTime);
//					if(list.isEmpty()){
//						System.out.println("没有相关用户");
//					}else{
//						for(int i=0; i<list.size(); ++i){
//							Advice result = (Advice)list.get(i);
//							System.out.println("相关用户的信息为："+result);
//						}
//					}
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else if(method==2){
//				try {
//					adviceDao.adviceDelete("1");
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else if(method==3){
//				Advice advice = new Advice(null, "1", "报修", "爆胎", "0");
//				String now1=DateUtil.nowTime();
//				String now2=DateUtil.parseTime(now1);
//				System.out.println(now1);
//				System.out.println(now2);
//				Date now=DateUtil.parse(now2);
//				advice.setCreateTime(now2);
//				System.out.println(now);
//				try {
//					if(adviceDao.adviceAdd(advice)){
//						System.out.println("添加成功");
//					}else{
//						System.out.println("添加失败");
//					}
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else if(method==4){
//				Advice advice = new Advice();
////				判断数据合法性
//				advice.setStatus("1");
//				advice.setTitle("300");
//				advice.setAdviseId("2");
//				try {
//					adviceDao.adviceModify(advice);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}else if(method==5){
//				Advice advice = new Advice();
//				try {
//					String afterCreateTime="";
//					String beforeCreateTime="";
//					String afterReplyTime="";
//					String beforeReplyTime="";
//					System.out.println("用户个数为："+adviceDao.adviceCount(advice,afterCreateTime,beforeCreateTime,afterReplyTime,beforeReplyTime));
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
