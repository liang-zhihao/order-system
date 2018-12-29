package application.frameClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddAItemFrame {
	public AddAItemFrame() {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application//fxml//AddAItem.fxml"));
			Scene scene = new Scene(root, 400, 672);
			// scene.getStylesheets().add(getClass().getResource("//application.css").toExternalForm());
			scene.getStylesheets()
					.add(getClass().getClassLoader().getResource("application//application.css").toExternalForm());

			Stage stage = new Stage();
			stage.setTitle("Add a Item");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
