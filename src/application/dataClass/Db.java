package application.dataClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

/*
 * public Object query(Connection conn, String sql, Object[] params, ResultSetHandler rsh) throws SQLException：执行一个查询操作，在这个查询中，对象数组中的每个元素值被用来作为查询语句的置换参数。该方法会自行处理 PreparedStatement 和 ResultSet 的创建和关闭。
　　public Object query(String sql, Object[] params, ResultSetHandler rsh) throws SQLException:　几乎与第一种方法一样；唯一的不同在于它不将数据库连接提供给方法，并且它是从提供给构造方法的数据源(DataSource) 或使用的setDataSource 方法中重新获得 Connection。
　　public Object query(Connection conn, String sql, ResultSetHandler rsh) throws SQLException : 执行一个不需要置换参数的查询操作。
　　public int update(Connection conn, String sql, Object[] params) throws SQLException:用来执行一个更新（插入、更新或删除）操作。
　　public int update(Connection conn, String sql) throws SQLException：用来执行一个不需要置换参数的更新操作。
 * 
 * ①ArrayHandler：     将查询结果的第一行数据，保存到Object数组中
      ②ArrayListHandler     将查询的结果，每一行先封装到Object数组中，然后将数据存入List集合
      ③BeanHandler     将查询结果的第一行数据，封装到user对象
     ④BeanListHandler     将查询结果的每一行封装到user对象，然后再存入List集合
     ⑤ColumnListHandler     将查询结果的指定列的数据封装到List集合中
     ⑥MapHandler     将查询结果的第一行数据封装到map结合（key==列名，value==列值）
     ⑦MapListHandler     将查询结果的每一行封装到map集合（key==列名，value==列值），再将map集合存入List集合
     ⑧BeanMapHandler     将查询结果的每一行数据，封装到User对象，再存入mao集合中（key==列名，value==列值）
     ⑨KeyedHandler     将查询的结果的每一行数据，封装到map1（key==列名，value==列值 ），然后将map1集合（有多个）存入map2集合（只有一个）
     ⑩ScalarHandler     封装类似count、avg、max、min、sum......函数的执行结果
 * */
public class Db {

	public static String url = "jdbc:mysql://127.0.0.1:3306/sys?useSSL=false&serverTimezone=GMT&allowPublicKeyRetrieval=true ";
	public static String user = "root";
	public static String passwd = "123456";
	public static String driver = "com.mysql.cj.jdbc.Driver";

	public Db() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 使用静态块加载驱动程序
	// 定义一个获取数据库连接的方法
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取连接失败");
		}
		return conn;
	}

	// 关闭数据库连接
	public static void close(ResultSet rs, Statement stat, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stat != null)
				stat.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		String sql = "select * from customer";
		QueryRunner qr = new QueryRunner();
		Db db = new Db();
		java.util.List<Object[]> list = qr.query(db.getConnection(), sql, new ArrayListHandler());
		for (int i = 0; i < list.size(); i++) {
			Object[] ob = list.get(i);
			for (int j = 0; j < ob.length; j++) {
				System.out.println(ob[j]);
			}
		}
		System.out.println(list);

	}

}