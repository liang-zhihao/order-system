	package application.frameClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CusAddressFrame {
	public CusAddressFrame() {
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("application//fxml//Address.fxml"));
			Scene scene = new Scene(root, 692, 666);
			scene.getStylesheets()
					.add(getClass().getClassLoader().getResource("application//application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setTitle("Customer Address");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
