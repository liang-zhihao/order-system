package application.frameClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CusRegisterFrame {
	public CusRegisterFrame() {
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("application//fxml//CusRegister.fxml"));
			Scene scene = new Scene(root, 533, 734);
			scene.getStylesheets()
					.add(getClass().getClassLoader().getResource("application//application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setTitle("Customer Register");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}