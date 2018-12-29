package application.frameClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangeItemFrame {
	public static int itemId;

	public ChangeItemFrame(int itemId) {
		try {
			this.itemId = itemId;
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("application//fxml//ChangeItem.fxml"));
			Scene scene = new Scene(root, 400, 672);
			// scene.getStylesheets().add(getClass().getResource("//application.css").toExternalForm());
			scene.getStylesheets()
					.add(getClass().getClassLoader().getResource("application//application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setTitle("Change a Item");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}