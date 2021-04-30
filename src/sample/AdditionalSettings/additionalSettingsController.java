package sample.AdditionalSettings;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class additionalSettingsController {

    String str;

    @FXML
    private TextField IP;

    @FXML
    private ComboBox Model;

    @FXML
    void Select(ActionEvent event) {

        str = Model.getSelectionModel().getSelectedItem().toString();
        System.out.println("You selected: " + str);

    }

    @FXML
    private Button Connect;

    @FXML
    void initialize() {

        ObservableList<String> list = FXCollections.observableArrayList(
                "Cognex DM 262q", "Cognex DM 374", "Cognex DM 474");
        Model.setItems(list);

        Connect.setOnAction(actionEvent -> {
            System.out.println("You selected: " + str + " IP: " + IP.getText());

            try(Socket socket = new Socket()){
                socket.connect(new InetSocketAddress(IP.getText(), 23));
                System.out.println("Вы подключились к камере: " + str + " IP: " + IP.getText());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        });

    }

}