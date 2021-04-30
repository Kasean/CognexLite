package sample.MainWindow;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    int clicks = 0, countOfFail = 0, сountOfRead = 0;
    double percentageOfFailCounter = 0, percentageOfReadCounter = 0;

    String str;

    Socket socket = new Socket();


    @FXML
    private Button userTrigger;

    @FXML
    private Button tnCamera;

    @FXML
    private Button resetSettings;

    @FXML
    private Label countOfTrigger;

    @FXML
    private Label infoAboutRead;

    @FXML
    private Label infoAboutFail;

    @FXML
    private Label percentageOfReads;

    @FXML
    private Label percentageOfFails;

    @FXML
    private Label infoAboutTime;

    @FXML
    private TextField IP;

    @FXML
    private ComboBox<String> Model;

    @FXML
    private Button Connect;

    @FXML
    private Button resetAllStatistic;

    @FXML
    private Button openDataBaseWindow;

    @FXML
    void initialize() {

        ObservableList<String> list = FXCollections.observableArrayList(
                "Cognex DM 262q", "Cognex DM 374", "Cognex DM 474");
        Model.setItems(list);

//Дописать после подключения камеры
        userTrigger.setOnAction(actionEvent -> {
            clicks++;
            String msgAboutTrigger = "Number of trigger: " + clicks;
            countOfTrigger.setText(String.valueOf(msgAboutTrigger));

            //Заглушка на считывания кода

            countOfFail++;
            String msgAboutFail = "Fail: " + countOfFail;
            infoAboutFail.setText(String.valueOf(msgAboutFail));

            //Заглушка на процент считываний

            percentageOfFailCounter = (countOfFail / (countOfFail + сountOfRead)) * 100;
            String msgAboutPercentageOfFail = "Percentage of fail: " + percentageOfFailCounter;
            percentageOfFails.setText(String.valueOf(msgAboutPercentageOfFail));
        });

        //Дописать после подключения камеры
        tnCamera.setOnAction(actionEvent -> {
            System.out.println("Tune");
        });

        //Дописать после подключения камеры
        resetAllStatistic.setOnAction(actionEvent -> {
            clicks = 0;
            countOfFail = 0;
            сountOfRead = 0;
            percentageOfFailCounter = 0;
            percentageOfReadCounter = 0;


            //Обнуление счётчика триггеров
            String msgAboutTrigger = "Number of trigger: " + clicks;
            countOfTrigger.setText(String.valueOf(msgAboutTrigger));

            //Обнуление информации о фэйлах
            String msgAboutFail = "Fail: " + countOfFail;
            infoAboutFail.setText(String.valueOf(msgAboutFail));

            //Обнуление информации о считываниях
            String msgAboutRead = "Read: " + сountOfRead;
            infoAboutRead.setText(String.valueOf(msgAboutRead));

            //Обнуление информации о проценте фэйлов
            String msgAboutPercentageOfFail = "Percentage of fail: 0.0000";
            percentageOfFails.setText(String.valueOf(msgAboutPercentageOfFail));

            //Обнуление информации о проценте считываний
            String msgAboutPercentageOfRead = "Percentage of read: 0.0000";
            percentageOfReads.setText(String.valueOf(msgAboutPercentageOfRead));

        });

        resetSettings.setOnAction(actionEvent -> {
            System.out.println("Settings reset");
        });

        openDataBaseWindow.setOnAction(actionEvent -> {


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/DBWindow/DBWindow.fxml"));

            try{
                loader.load();
            }catch (IOException e){
                e.printStackTrace();
            }

            Parent root = loader.getRoot();

            Stage stage = new Stage();
            Scene scene = new Scene(root, 800, 600);
            stage.setTitle("Data Base");
            stage.setScene(scene);
            stage.showAndWait();
        });

//        additionalSettings.setOnAction(actionEvent -> {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/sample/AdditionalSettings/AdditionalSettingsWindow.fxml"));
//
//            try{
//                loader.load();
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//
//            Parent root = loader.getRoot();
//
//            Stage stage = new Stage();
//            Scene scene = new Scene(root, 393, 228);
//            stage.setTitle("Additional settings");
//            stage.setScene(scene);
//            stage.showAndWait();
//        });
        Connect.setOnAction(actionEvent -> {

            try{
                socket.connect(new InetSocketAddress(IP.getText(), 23));
                System.out.println("Вы подключились к камере: " + str + " IP: " + IP.getText());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        });
    }

    public void Select(ActionEvent actionEvent) {

        str = Model.getSelectionModel().getSelectedItem().toString();
        System.out.println("You selected: " + str);
    }
}
