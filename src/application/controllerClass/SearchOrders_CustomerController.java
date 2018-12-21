package application.controllerClass;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class SearchOrders_CustomerController {
	@FXML
	private AnchorPane CustomerSearchOrders;
	@FXML
	private MenuBar mnBar;
	@FXML
	private Menu mnUserName;
	@FXML
	private Menu mnItems;
	@FXML
	private Menu mnOrders;
	@FXML
	private Menu mnLogOut;
	@FXML
	private TextField txEnterBnsID;
	@FXML
	private Button btSearchBnsID;
	@FXML
	private AnchorPane pnResult;
	@FXML
	private GridPane tableOrdersFORCustomer;

}
