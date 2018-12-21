package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application//fxml//SignIn.fxml"));
			Scene scene = new Scene(root, 600, 500);
			// scene.getStylesheets().add(getClass().getResource("//application.css").toExternalForm());
			scene.getStylesheets()
					.add(getClass().getClassLoader().getResource("application//application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Sign In");
<<<<<<< HEAD
=======
			primaryStage.getIcons().add(new Image("application/fxml/img/233.jpg"));
>>>>>>> parent of 9f64fcc... Merge branch 'master' of https://github.com/TTEAMM/orderSystem
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
		String t = "Business-1-82824-jpg";
		System.out.println();
	}
}
