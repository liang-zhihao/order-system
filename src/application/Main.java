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
			Scene scene = new Scene(root, 600, 534);
			// scene.getStylesheets().add(getClass().getResource("//application.css").toExternalForm());
			scene.getStylesheets()
					.add(getClass().getClassLoader().getResource("application//application.css").toExternalForm());

			primaryStage.setScene(scene);
<<<<<<< HEAD
			primaryStage.setTitle("Sign In");

			primaryStage.getIcons().add(new Image("application/fxml/img/233.jpg"));

=======
			primaryStage.setTitle("µÇÂ¼´°¿Ú");
>>>>>>> e457a272e7cf6be5e1ee67a8df756741526b9de2
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
