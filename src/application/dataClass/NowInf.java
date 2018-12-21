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
		String attribution = source.getName().substring(source.getName().lastIndexOf("."));
		Path tmp1 = null;
		Path tmp2 = null;
		if (type.equals("a")) {
			tmp1 = Paths.get(System.getProperty("user.dir"), "/src/application/fxml/img/avatar", name + attribution);
			tmp2 = Paths.get(System.getProperty("user.dir"), "/bin/application/fxml/img/avatar", name + attribution);

		} else {
			tmp1 = Paths.get(System.getProperty("user.dir"), "/src/application/fxml/img/item", name + attribution);
			tmp2 = Paths.get(System.getProperty("user.dir"), "/bin/application/fxml/img/item", name + attribution);

		}
		Files.copy(t, tmp1, StandardCopyOption.REPLACE_EXISTING);
		Files.copy(t, tmp2, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("add successfully");
		if (type.equals("a")) {
			return new Image("application/fxml/img/avatar/" + name + attribution);
		} else {
			return new Image("application/fxml/img/item/" + name + attribution);
		}

	}

	public static void setPicView(ImageView im, String path) {
		System.out.println("FUCK-application/fxml/img/" + path);
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

	public static void addItemToPane(FlowPane p, ArrayList<Product> productlist) {
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
			String picNameAtt = t.getPictureName().substring(t.getPictureName().lastIndexOf("-") + 1);
			String picname = t.getPictureName() + "." + picNameAtt;
			VBoxItemForBus tmp = new VBoxItemForBus("item/" + picname, t.getName(), busname, t.getStandardcost());
			tmp.setItemId(t.getProductid());
			p.getChildren().add(tmp);
		}
		System.out.println("successfully");
	}
	// public static void main(String[] args) {
	// System.out.println(getGreetingWords("c"));
	// }
}
