//package test;
//
//import java.util.List;
//import java.util.Scanner;
//
//import been.Activity;
//import been.Admin;
//import been.AdminRole;
//import been.PageBean;
//import been.User;
//import dao.AdminDao;
//import dao.AdminRoleDao;
//import dao.UserDao;
//import util.StringUtil;
//
///**
// * 初期的测试类
// * @author gloria
// *
// */
//public class UserAdminAdminRoleDaoTest {
//	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in);
//		while(true){
//			System.out.println("请选择测试类：1.UserDao 2.AdminDao "
//					+ "3.AdminRoleDao 4. 5. 6.");
//			int choose = sc.nextInt();
//
//			if(choose == 1){
//				System.out.println("请选择测试方法：1.list 2.delete "
//						+ "3.add 4.modify 5.count 6.login");
//				int method = sc.nextInt();
//				UserDao userDao = new UserDao();
//				AdminDao adminDao = new AdminDao();
//				if(method==1){
//					User user = new User();
////					判断数据是否合法
////					user.setUserId("1");
////					user.setUserName("user");
//					PageBean pageBean = new PageBean(1, 10); 
//					try {
//						List<Object> list = userDao.userList(pageBean, user);
//						if(list.isEmpty()){
//							System.out.println("没有相关用户");
//						}else{
//							for(int i=0; i<list.size(); ++i){
//								User result = (User)list.get(i);
//								System.out.println("相关用户的信息为："+result.getName()+result.getUserName());
//							}
//						}
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==2){
//					try {
//						userDao.userDelete("2");
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==3){
//					User user = new User("user2", "777777", "骑行用户2", "233", "20", "123456", "1", "20");
//					try {
//						if(userDao.userAdd(user)){
//							System.out.println("添加成功");
//						}else{
//							System.out.println("添加失败");
//						}
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==4){
//					User user = new User();
////					判断数据合法性
//					user.setUserId("2");
//					user.setBalance("300");
//					try {
//						userDao.userModify(user);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==5){
//					User user = new User();
//					try {
//						System.out.println("用户个数为："+userDao.userCount(user));
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==6){
//					User user = new User();
//					user.setUserName("user");
//					user.setPassword("888888");
////					user.setPassword("8888888");
//					try {
//						System.out.println(userDao.login(user));
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}else if(choose == 2){
//				System.out.println("请选择测试方法：1.list 2.delete "
//						+ "3.add 4.modify 5.count 6.login");
//				int method = sc.nextInt();
//				AdminDao adminDao = new AdminDao();
//				if(method==1){
//					Admin admin = new Admin();
////					判断数据是否合法
////					admin.setAdminId("1");
////					admin.setUserName("admin");
//					PageBean pageBean = new PageBean(1, 10); 
//					try {
//						List<Object> list = adminDao.adminList(pageBean, admin);
//						if(list.isEmpty()){
//							System.out.println("没有相关用户");
//						}else{
//							for(int i=0; i<list.size(); ++i){
//								Admin result = (Admin)list.get(i);
//								System.out.println("相关用户的信息为："+result.getName()+result.getUserName());
//							}
//						}
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==2){
//					try {
//						adminDao.adminDelete("3");
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==3){
//					Admin admin = new Admin("3", "admin3", "777777", "管理员用户3", "2");
//					try {
//						if(adminDao.adminAdd(admin)){
//							System.out.println("添加成功");
//						}else{
//							System.out.println("添加失败");
//						}
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==4){
//					Admin admin = new Admin();
////					判断数据合法性
//					admin.setAdminId("3");
//					admin.setName("乌拉乌拉乌拉");
//					try {
//						adminDao.adminModify(admin);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==5){
//					Admin admin = new Admin();
//					try {
//						System.out.println("用户个数为："+adminDao.adminCount(admin));
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==6){
//					Admin admin = new Admin();
//					admin.setUserName("admin");
//					admin.setPassword("888888");
////					admin.setPassword("8888888");
//					try {
//						System.out.println(adminDao.login(admin));
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}else if(choose == 3){
//				System.out.println("请选择测试方法：1.list 2.delete "
//						+ "3.add 4.modify 5.count");
//				int method = sc.nextInt();
//				AdminRoleDao adminRoleDao = new AdminRoleDao();
//				if(method==1){
//					AdminRole adminRole = new AdminRole();
////					判断数据是否合法
////					adminRole.setAdminRoleId("1");
//					PageBean pageBean = new PageBean(1, 10); 
//					try {
//						List<Object> list = adminRoleDao.adminRoleList(pageBean, adminRole);
//						if(list.isEmpty()){
//							System.out.println("没有相关记录");
//						}else{
//							for(int i=0; i<list.size(); ++i){
//								AdminRole result = (AdminRole)list.get(i);
//								System.out.println("相关记录的信息为："+result.getAdminRoleId()+result.getRequireActivity());
//							}
//						}
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==2){
//					try {
//						adminRoleDao.adminRoleDelete("4");
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==3){
//					AdminRole adminRole = new AdminRole("4", "1", "1", "0", "1", "1", "0", "1", "1", "0", "1", "1", "0", "1", "1");
//					try {
//						if(adminRoleDao.adminRoleAdd(adminRole)){
//							System.out.println("添加成功");
//						}else{
//							System.out.println("添加失败");
//						}
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==4){
//					AdminRole adminRole = new AdminRole();
////					判断数据合法性
//					adminRole.setAdminRoleId("4");
//					adminRole.setRequireUser("0");
//					try {
//						adminRoleDao.adminRoleModify(adminRole);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else if(method==5){
//					AdminRole adminRole = new AdminRole();
//					try {
//						System.out.println("管理员角色个数为："+adminRoleDao.adminRoleCount(adminRole));
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//	}
//}
