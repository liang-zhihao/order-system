package application.frameClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ShowItemDetailFrame {
	public static int itemId;

	public ShowItemDetailFrame(int itemId) {
		try {
			this.itemId = itemId;
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("application//fxml//ShowItemDetail.fxml"));
			Scene scene = new Scene(root, 400, 672);
			// scene.getStylesheets().add(getClass().getResource("//application.css").toExternalForm());
			scene.getStylesheets()
					.add(getClass().getClassLoader().getResource("application//application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setTitle("Show Detail");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}