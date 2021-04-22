package sample.DBWindow;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DBController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> DBTable;

    @FXML
    private Button getData;

    @FXML
    private Button connectToDataBase;

    @FXML
    private TextField urlField;

    @FXML
    void initialize() {
        connectToDataBase.setOnAction(actionEvent -> {
            String DataBaseName = urlField.getText();
            //Подключение к бд (написать)

            System.out.println(DataBaseName);

        });

    }
}
