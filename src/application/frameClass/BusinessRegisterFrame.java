package application.frameClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BusinessRegisterFrame {
	public BusinessRegisterFrame() {
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("application//fxml//BusinessRegister.fxml"));
			Scene scene = new Scene(root, 533, 601);
			// scene.getStylesheets().add(getClass().getResource("//application.css").toExternalForm());
			scene.getStylesheets()
					.add(getClass().getClassLoader().getResource("application//application.css").toExternalForm());

			Stage stage = new Stage();
			stage.setTitle("Business Register");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}