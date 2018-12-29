package application.frameClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ShopHomepageFrame {
	public ShopHomepageFrame() {
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("application//fxml//ShopHomepage.fxml"));
			Scene scene = new Scene(root, 1024, 768);
			scene.getStylesheets()
					.add(getClass().getClassLoader().getResource("application//application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setTitle("ShopHomepage");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
