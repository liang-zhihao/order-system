package application;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ConnUtil {
	// 定义操作数据库需要的东西
	PreparedStatement ps = null;
	Connection ct = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://127.0.0.1:3306/ordersystemby(yyandlzh)?useSSL=false&serverTimezone=GMT";
	String user = "root";
	String passwd = "123456";
	String driver = "com.mysql.cj.jdbc.Driver";

	// 关闭数据库资源
	public void close() {
		// 关闭
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (ct != null)
				ct.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 写了一个不需要注入的方法
	public ResultSet queryExecute(String sql) {
		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.得到连接
			ct = DriverManager.getConnection(url, user, passwd);
			// 3.创建ps
			ps = ct.prepareStatement(sql);

			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源

		}
		return rs;
	}

	// 模糊查询数据库的操作
	public ResultSet queryLikeExecute(String sql, String[] paras) {
		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.得到连接
			ct = DriverManager.getConnection(url, user, passwd);
			// 3.创建ps
			ps = ct.prepareStatement(sql);
			// 给ps的？赋值
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, "%" + paras[i] + "%");
			}

			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源

		}
		return rs;
	}

	// 查询数据库的操作
	public ResultSet queryExecute(String sql, String[] paras) {
		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.得到连接
			ct = DriverManager.getConnection(url, user, passwd);
			// 3.创建ps
			ps = ct.prepareStatement(sql);
			// 给ps的？赋值
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, paras[i]);
			}

			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源

		}
		return rs;
	}

	// 把增删改合在一起
	public boolean updExecute(String sql, String[] paras) {
		boolean b = true;

		try {
			// 1.加载驱动
			Class.forName(driver);
			// 2.得到连接
			ct = DriverManager.getConnection(url, user, passwd);
			// 3.创建ps
			ps = ct.prepareStatement(sql);
			// 给ps的？赋值
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, paras[i]);
			}
			// 4.执行操作
			if (ps.executeUpdate() != 1) {
				b = false;
			}

		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}

	public static void main(String[] args) throws UnsupportedEncodingException, SQLException {
		ConnUtil conn = new ConnUtil();
		String sql = "select ? from ? where username=?";
		String[] p = new String[3];
		p[0] = "username";
		p[1] = "username";
		p[2] = "xhy";
		ResultSet rs = conn.queryExecute(sql, p);
		rs.next();
		System.out.println(rs.getString(1));
	}
}