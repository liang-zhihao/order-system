package application.dataClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

public class NowInf {
	public static Customer customer = null;
	public static Business business = null;

	public static Image copyPictureToProject(File source, String name, String type) throws IOException {
		Path t = Paths.get(source.getAbsolutePath());
		Path tmp1 = null;
		Path tmp2 = null;
		if (type.equals("a")) {
			tmp1 = Paths.get(System.getProperty("user.dir"), "/src/application/fxml/img/avatar", name);
			tmp2 = Paths.get(System.getProperty("user.dir"), "/bin/application/fxml/img/avatar", name);

		} else {
			tmp1 = Paths.get(System.getProperty("user.dir"), "/src/application/fxml/img/item", name);
			tmp2 = Paths.get(System.getProperty("user.dir"), "/bin/application/fxml/img/item", name);

		}
		Files.copy(t, tmp1, StandardCopyOption.REPLACE_EXISTING);
		Files.copy(t, tmp2, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("add successfully");
		if (type.equals("a")) {
			return new Image("application/fxml/img/avatar/" + name);
		} else {
			return new Image("application/fxml/img/item/" + name);
		}

	}

	public static void setPicView(ImageView im, String path) {
		im.setImage(new Image("application/fxml/img/" + path));
	}

	public static String getGreetingWords() {
		String t = "";
		if (NowInf.customer == null) {
			t = NowInf.business.getUsername();
		} else {
			t = NowInf.customer.getNickname();
		}

		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("HH");// 设置日期格式
		String time = df.format(new Date());// new Date()为获取当前系统时间

		int hour = Integer.valueOf(time);

		if (hour < 12 && hour > 0) {
			time = " morning! ";
		} else if (hour < 18 && hour >= 12) {
			time = " afternoon! ";
		} else {
			time = " evening! ";
		}
		String g = "Good" + time + t;
		return g;
	}

	public static void addItemToPane(FlowPane p, ArrayList<Product> productlist, String type) {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();

		for (int i = 0; i < productlist.size(); i++) {
			Product t = productlist.get(i);
			String sql = "select DISTINCT businessname from business,product where product.businessid =business.businessid and product.businessid="
					+ t.getBusinessiD();
			System.out.println(t.getBusinessiD());
			String busname = "";
			try {
				Object[] res = qr.query(db.getConnection(), sql, new ArrayHandler());
				busname = res[0].toString();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String picname = t.getPictureName();
			if (type.equals("b")) {
				VBoxItemForBus tmp = new VBoxItemForBus("item/" + picname, t.getName(), busname, t.getStandardcost());
				tmp.setItemId(t.getProductid());
				p.getChildren().add(tmp);
			} else {
				VBoxItemForCus tmp = new VBoxItemForCus("item/" + picname, t.getName(), busname, t.getStandardcost());
				tmp.setItemId(t.getProductid());
				p.getChildren().add(tmp);
			}

		}
		System.out.println("successfully");
	}

	public static String getPicAttributeFromFile(String picname) {
		return picname.substring(picname.lastIndexOf(".") + 1);
	}

	public static OrderTable[] convertToOrderTable(ArrayList<SalesOrder> orderlist) {
		OrderTable[] t = new OrderTable[orderlist.size()];
		for (int i = 0; i < orderlist.size(); i++) {
			t[i] = new OrderTable();
		}
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql1 = "select BusinessName from business where businessId=?";
		String sql2 = "select Name from Product where ProductId=?";
		Object[] para = new Object[1];
		Object[] tmp = null;
		try {
			for (int i = 0; i < orderlist.size(); i++) {
				para[0] = orderlist.get(i).getBusinessId();
				tmp = qr.query(db.getConnection(), sql1, para, new ArrayHandler());
				t[i].setBusiness(tmp[0].toString());
				para[0] = orderlist.get(i).getProductId();
				tmp = qr.query(db.getConnection(), sql2, para, new ArrayHandler());
				t[i].setItemName(tmp[0].toString());
				t[i].setComment(orderlist.get(i).getComment());
				t[i].setOrderDate(orderlist.get(i).getOrderDate());
				t[i].setQuantity(orderlist.get(i).getQuantity());
				t[i].setSalesOrderNumber(orderlist.get(i).getSalesOrderNumber());
				t[i].setStatus(orderlist.get(i).getStatus());
				t[i].setSubTotal(orderlist.get(i).getSubTotal());
				t[i].setIsCheck(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

}
