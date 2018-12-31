package application.frameClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelectAddressFrame {
	public static VBox t;

	public SelectAddressFrame(VBox t) {
		this.t = t;
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("application//fxml//SelectAddress.fxml"));
			Scene scene = new Scene(root, 605, 465);
			scene.getStylesheets()
					.add(getClass().getClassLoader().getResource("application//application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setTitle("Customer Homepage");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(String.format("%-7s:  %-5sX  %-5s", "dudud", "20", "100"));
	}

}