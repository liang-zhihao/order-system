package application.dataClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

/*
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

	// 数据库连接地址
	public static String URL;
	// 用户名
	public static String USERNAME;
	// 密码
	public static String PASSWORD;
	// mysql的驱动类
	public static String DRIVER;

	private static ResourceBundle rb = ResourceBundle.getBundle("db-config");

	// 使用静态块加载驱动程序
	static {
		URL = rb.getString("jdbc.url");
		USERNAME = rb.getString("jdbc.username");
		PASSWORD = rb.getString("jdbc.password");
		DRIVER = rb.getString("jdbc.driver");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 定义一个获取数据库连接的方法
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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

		java.util.List<Object[]> list = qr.query(Db.getConnection(), sql, new ArrayListHandler());
		for (int i = 0; i < list.size(); i++) {
			Object[] ob = list.get(i);
			for (int j = 0; j < ob.length; j++) {
				System.out.println(ob[j]);
			}
		}
		System.out.println(list);

	}

}