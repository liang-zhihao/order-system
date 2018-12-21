package application.dataClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NowInf {
	public static Customer customer = null;
	public static Business business = null;

	public static Image copyPictureToProject(File source, String name) throws IOException {
		Path t = Paths.get(source.getAbsolutePath());
		String attribution = source.getName().substring(source.getName().lastIndexOf("."));
		Path tmp1 = Paths.get(System.getProperty("user.dir"), "/src/application/fxml/img", name + attribution);
		Path tmp2 = Paths.get(System.getProperty("user.dir"), "/bin/application/fxml/img", name + attribution);
		Files.copy(t, tmp1, StandardCopyOption.REPLACE_EXISTING);
		Files.copy(t, tmp2, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("add successfully");
		return new Image("application/fxml/img/" + name + attribution);

	}

	public static void setPicView(ImageView im, String path) {
		im.setImage(new Image("application/fxml/img/" + path));
	}
}
