//package test;
//import java.lang.reflect.Field;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import been.Bicycle;
//import been.CyclingRecord;
//import been.PageBean;
//import dao.CyclingRecordDao;
//import junit.framework.Assert;
//import util.DateUtil;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//
//public class CycingRecordDaoTest {
//	private static CyclingRecordDao cyclingRecordDao ;
//	
//	@BeforeClass
//	public static void initCyclingRecordDao(){
//		cyclingRecordDao=new CyclingRecordDao();
//		 BicycleDaoTest bdt;
//		 bdt=new BicycleDaoTest();
//		 bdt.initBicycleDao();
//		 bdt.test1BicycleAdd();
//	}
//	@AfterClass
//	public static void destoryCyclingRecordDao(){
//		
//		 BicycleDaoTest bdt;
//		 bdt=new BicycleDaoTest();
//		 bdt.initBicycleDao();
//		 bdt.test5BicycleDelete();
//	}
//
//	//添加
//	@SuppressWarnings("deprecation")
//	@Test
//	public void test1Add(){
//		try {
//			
//			CyclingRecord cyclingRecord=new CyclingRecord();
//			cyclingRecord.setUserId("1");
//			cyclingRecord.setBicycleId("1");
//			cyclingRecord.setStartTime("2017-08-20 10:22:11");
//			cyclingRecord.setEndTime("2017-08-20 10:25:11");
//			cyclingRecord.setStartLocX("1");
//			cyclingRecord.setStartLocY("1");
//			cyclingRecord.setEndLocX("2");
//			cyclingRecord.setEndLocY("2");
//			Date startTime=DateUtil.parse("2017-08-20 10:22:11");
//			Date endTime=DateUtil.parse("2017-08-20 10:25:11");
//			cyclingRecord.setCyclingRecordId(cyclingRecord.getUserId()+(endTime.getSeconds()-startTime.getSeconds()));
//			int count=cyclingRecordDao.CyclingRecordAdd(cyclingRecord);
//			Assert.assertEquals(1, count);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	//修改
//	@SuppressWarnings("deprecation")
//	@Test
//	public void test2MOdify(){
//
//		CyclingRecord cyclingRecord=new CyclingRecord();
//		cyclingRecord.setUserId("1");
//		
//		cyclingRecord.setStartTime("2017-08-20 10:22:11");
//		cyclingRecord.setEndTime("2017-08-20 10:25:11");
//		
//		cyclingRecord.setEndLocX("4");
//		cyclingRecord.setEndLocY("4");
//		Date startTime=DateUtil.parse("2017-08-20 10:22:11");
//		Date endTime=DateUtil.parse("2017-08-20 10:25:11");
//		cyclingRecord.setCyclingRecordId(cyclingRecord.getUserId()+(endTime.getSeconds()-startTime.getSeconds()));
//		int count;
//		try {
//			count = cyclingRecordDao.CyclingRecordModify(cyclingRecord);
//			Assert.assertEquals(1, count);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	//获取自行车列表
//		@Test
//		public void test3Count() {
//		
//			CyclingRecord cyclingRecord=new CyclingRecord();
//			cyclingRecord.setUserId("1");
//			cyclingRecord.setStartTime("2017-08-20 10:22:11");
//			cyclingRecord.setEndTime("2017-08-20 10:25:11");
//			Date startTime=DateUtil.parse("2017-08-20 10:22:11");
//			Date endTime=DateUtil.parse("2017-08-20 10:25:11");
//			cyclingRecord.setCyclingRecordId(cyclingRecord.getUserId()+(endTime.getSeconds()-startTime.getSeconds()));
//			try {
//				
//				int count=cyclingRecordDao.CyclingRecordCount(cyclingRecord);
//				Assert.assertEquals(1, count);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//	//获取自行车列表
//	@Test
//	public void test4List() {
//		//参数1,5是随便写的
//		PageBean pageBean=new been.PageBean(1,5);
//
//		CyclingRecord cyclingRecord=new CyclingRecord();
//		cyclingRecord.setUserId("1");
//		cyclingRecord.setStartTime("2017-08-20 10:22:11");
//		cyclingRecord.setEndTime("2017-08-20 10:25:11");
//		Date startTime=DateUtil.parse("2017-08-20 10:22:11");
//		Date endTime=DateUtil.parse("2017-08-20 10:25:11");
//		cyclingRecord.setCyclingRecordId(cyclingRecord.getUserId()+(endTime.getSeconds()-startTime.getSeconds()));
//		try {
//			
//			List<Object> cList=cyclingRecordDao.cyclingRecordList(pageBean, cyclingRecord);
//			for (Object object : cList) {
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
//	public void test5Delete(){
//		try {
//			CyclingRecord cyclingRecord=new CyclingRecord();
//			cyclingRecord.setUserId("1");
//			cyclingRecord.setStartTime("2017-08-20 10:22:11");
//			cyclingRecord.setEndTime("2017-08-20 10:25:11");
//			Date startTime=DateUtil.parse("2017-08-20 10:22:11");
//			Date endTime=DateUtil.parse("2017-08-20 10:25:11");
//			cyclingRecord.setCyclingRecordId(cyclingRecord.getUserId()+(endTime.getSeconds()-startTime.getSeconds()));
//			int count=cyclingRecordDao.CyclingRecordDelete(cyclingRecord.getCyclingRecordId());
//			Assert.assertEquals(1, count);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
