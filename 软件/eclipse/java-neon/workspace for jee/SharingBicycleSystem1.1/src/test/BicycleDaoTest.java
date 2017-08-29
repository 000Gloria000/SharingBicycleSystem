//package test;
//import java.lang.reflect.Field;
//import java.util.List;
//
//import org.junit.BeforeClass;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import been.Bicycle;
//import been.PageBean;
//import dao.BicycleDao;
//import junit.framework.Assert;
//import util.DateUtil;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//
//public class BicycleDaoTest {
//	private static BicycleDao bicycleDao;
//	//初始化Dao对象
//	@BeforeClass
//	public static void initBicycleDao(){
//		bicycleDao=new BicycleDao();
//	}
//
//	//添加
//	@SuppressWarnings("deprecation")
//	@Test
//	public void test1BicycleAdd(){
//		try {
//			Bicycle bicycle=new Bicycle();
//			bicycle.setBicycleId("1");
//			bicycle.setFrom("0");
//			bicycle.setLockId("1");
//			bicycle.setLocationX("1");
//			bicycle.setLocationY("2");
//			bicycle.setPhoto("/image/xxx.jpg");
//			bicycle.setStatus("1");
//			bicycle.setTime(DateUtil.nowTime());
//			bicycle.setEnergy("99.9");
//		
//			
//			int count=bicycleDao.bicycleAdd(bicycle);
//			Assert.assertEquals(1, count);
//			bicycle.setBicycleId("2");
//			bicycle.setLockId("2");
//			bicycle.setTime(DateUtil.nowTime());
//			count=bicycleDao.bicycleAdd(bicycle);
//			Assert.assertEquals(1, count);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	//修改
//	@SuppressWarnings("deprecation")
//	@Test
//	public void test2MOdify(){
//		Bicycle bicycle=new Bicycle();
//		bicycle.setBicycleId("1");
//		bicycle.setEnergy("50.5");
//		try {
//			int count=bicycleDao.bicycleModify(bicycle);
//			Assert.assertEquals(1, count);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	//获取自行车数量
//		@Test
//		public void test3BicycleCount() {
//			Bicycle bicycle=new Bicycle();
//			bicycle.setBicycleId("1");
//			
//			try {
//				
//				int count=bicycleDao.bicycleCount(bicycle);
//				Assert.assertEquals(1, count);
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	//获取自行车列表
//	@Test
//	public void test4BicycleList() {
//		//参数1,5是随便写的
//		PageBean pageBean=new been.PageBean(1,5);
//		Bicycle bicycle=new Bicycle();
//		bicycle.setBicycleId("1");
//		try {
//			
//			List<Object> bList=bicycleDao.bicycleList(pageBean, bicycle);
//			for (Object object : bList) {
//				System.out.println("-----");
//				Class c=object.getClass();
//				Field [] fields=c.getDeclaredFields();
//				for (Field field : fields) {
//					field.setAccessible(true);
//					System.out.println(field.get(object));
//				}
//				System.out.println("-----");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	//删除
//	@SuppressWarnings("deprecation")
//	@Test
//	public void test5BicycleDelete(){
//		try {
//			int count=bicycleDao.bicycleDelete("1");
//			Assert.assertEquals(1, count);
//			count=bicycleDao.bicycleDelete("2");
//			Assert.assertEquals(1, count);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
