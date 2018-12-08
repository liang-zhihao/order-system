package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application//fxml//SignIn.fxml"));
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("//application.css").toExternalForm());
			scene.getStylesheets()
					.add(getClass().getClassLoader().getResource("application//application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setTitle("µÇÂ¼´°¿Ú");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
