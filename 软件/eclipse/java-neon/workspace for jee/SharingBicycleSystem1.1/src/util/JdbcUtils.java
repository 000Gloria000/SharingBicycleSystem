package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 关于数据库的工具类
 * 对Connect.java的进一步封装，开发服务器时需再次修改，
 * 平时写代码时调用这里面的方法
 * @author gloria
 *
 */
public class JdbcUtils
{
	private static final Connect connect = new Connect();
	
	/**
	 * 创建与数据库的连接
	 * @return	连接
	 * @throws SQLException
	 */
	public static Connection createConnection() throws SQLException
	{
		return connect.getConnection();
	}
	
	 public static Connect getInstance(){
		 return connect.getInstance();
	 }

	/**
	 * 关闭Connection连接
	 * @param conn Connection连接
	 */
	public static void closeConnection(Connection conn)
	{
		connect.freeConnection(conn);
	}
	
	/**
	 * 关闭Statement
	 * @param st
	 */
	public static void closeStatement(Statement st)
	{
		connect.freeStatement(st);
	}
	
	/**
	 * 关闭ResultSet
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs)
	{
		connect.freeResultSet(rs);
	}
	
	/**
	 * 关闭Connection、Statement、ResultSet
	 * @param rs
	 */
	public static void closeAll(ResultSet rs)
	{
		Statement stmt = null;
		Connection conn = null;
		try
		{
			stmt = rs.getStatement();
			conn = stmt.getConnection();
		} catch (SQLException e)
		{
			//
		}
		finally
		{
			closeConnection(conn);
			closeStatement(stmt);
			closeResultSet(rs);
		}
	}
	
	/**
	 * 修改，删除，添加使用
	 * @param sql sql语句
	 * @param param	和sql中的问号一一对应
	 * @return	更新记录数目
	 */
	public static int update(String sql, List<Object> param) {
		return connect.update(sql, param);
	}
	
	/**
	 * 查询表中的记录数，返回数量
	 * @param sql	sql语句
	 * @param param 和sql中的问号一一对应
	 * @return	记录数
	 */
	public static int count(String sql, List<Object> param) {
		return connect.count(sql, param);
	}
	
	/**
	 * 查询并以Map的形式返回查询结果
	 * @param sql	sql语句
	 * @param param	和sql中的问号一一对应
	 * @return
	 */
	public static List<Map<String, String>> queryForMap(String sql, List<Object> param) {
		return connect.queryForMap(sql, param);
	}
	
	/**
	 * 查询并以数组(List)的形式返回查询结果
	 * 根据 sql 返回对象，sql 中查询的字段需要和bean中的一致，bean中属性必须为string类型
	 * @param sql	sql语句
	 * @param param	和sql中的问号一一对应
	 * @return
	 */
	public static List<Object> queryForArrObject(String sql, List<Object> param, Class<?> cls) {
		return connect.queryForArrObject(sql, param, cls);
	}
}
