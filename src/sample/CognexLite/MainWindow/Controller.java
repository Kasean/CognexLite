package sample.CognexLite.MainWindow;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.CognexLite.ActionCommand.ActionCommand;
import sample.CognexLite.Connect.WorkWithConnection;
import sample.WorkWithTCP.Listener;


public class Controller {

    int clicks = 0;
    double percentageOfFailCounter = 0, percentageOfReadCounter = 0, countOfFail = 0, countOfRead = 0;

    int quantityOfLabels;

    String str;

    @FXML
    private PieChart Chart;


    @FXML
    private Button Ok;

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
    private TextField codQuantity;

    @FXML
    private Label codQuantityLbl;

    @FXML
    private Button openDataBaseWindow;

    @FXML
    private Label one;

    @FXML
    private Label two;

    @FXML
    private Label three;

    @FXML
    private Label four;

    @FXML
    private Label five;

    @FXML
    private Label six;

    @FXML
    private Label seven;

    @FXML
    private Label eight;

    @FXML
    private Label nine;

    @FXML
    private Label ten;

    @FXML
    private Label eleven;

    @FXML
    private Label twelve;

    @FXML
    private Label thirteen;

    @FXML
    private Label fourteen;

    @FXML
    private Label fifteen;


    @FXML
    private Label sixteen;

    @FXML
    private Label seventeen;

    @FXML
    private AnchorPane photoPane;

    @FXML
    private Label eighteen;

    @FXML
    private Label nineteen;

    @FXML
    private Label twenty;

    @FXML
    private Label twentyOne;

    @FXML
    private Label twentyTwo;

    @FXML
    private Label twentyThree;

    @FXML
    private CheckBox apparatTrigger;

    @FXML
    private Label twentyFour;

    @FXML
    private Button DisConnect;

    @FXML
    private TextArea decriptedCods;


    @FXML
    void initialize() {

        apparatTrigger.setOnAction(actionEvent -> {
            
            if(apparatTrigger.isSelected()){
                Listener.listenToPort();
            }
        });



        Ok.setVisible(false);

        Chart.setStyle("-fx-background-color: gray");


        ArrayList<Label> lbl = new ArrayList<>();

        lbl.add(0, one);
        lbl.add(1, two);
        lbl.add(2, three);
        lbl.add(3, four);
        lbl.add(4, five);
        lbl.add(5, six);
        lbl.add(6, seven);
        lbl.add(7, eight);
        lbl.add(8, nine);
        lbl.add(9, ten);
        lbl.add(10, eleven);
        lbl.add(11, twelve);
        lbl.add(12, thirteen);
        lbl.add(13, fourteen);
        lbl.add(14, fifteen);
        lbl.add(15, sixteen);
        lbl.add(16, seventeen);
        lbl.add(17, eighteen);
        lbl.add(18, nineteen);
        lbl.add(19, twenty);
        lbl.add(20, twentyOne);
        lbl.add(21, twentyTwo);
        lbl.add(22, twentyThree);
        lbl.add(23, twentyFour);

        codQuantity.setVisible(false);
        codQuantityLbl.setVisible(false);

        for (int i = 0;i < 24;i++){
            lbl.get(i).setVisible(false);
        }


        ObservableList<String> list = FXCollections.observableArrayList(
                "Cognex DM 262q", "Cognex DM 374", "Cognex DM 474");
        Model.setItems(list);

//???????????????? ?????????? ?????????????????????? ????????????

        userTrigger.setOnAction(actionEvent -> {



//            try {
//                BufferedReader reader =  new BufferedReader(new InputStreamReader(poolOfSocket.get(countOfSocket).getInputStream()));
//                String data = new String();
//
//                int tra = reader.read();
//                System.out.println(tra);
//
//                if(str.equals("Cognex DM 262q")){
//
//                    if(tra == 48){
//
//                        data += reader.readLine();
//                        data += "\n";
//                        decriptedCods.appendText(data);
//                        System.out.println(data);
//
//                        countOfRead++;
//                        String msgAboutRead = "Read: " + countOfRead;
//                        infoAboutRead.setText(msgAboutRead);
//                        lbl.get(0).setStyle("-fx-background-color: green");
//                        Image image = null;
//                        try {
//                            image = new Image(new FileInputStream("E:\\JFX\\Yes.png"));
//                        } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                        }
//                        ImageView imageView = new ImageView(image);
//                        imageView.setFitHeight(200);
//                        imageView.setFitWidth(200);
//
//                        photoPane.getChildren().add(imageView);
//                    }
//
//                    if(tra == 70){
//                        decriptedCods.appendText("FAIL" + "\n");
//
//                        countOfFail++;
//                        String msgAboutFail = "Fail: " + countOfFail;
//                        infoAboutFail.setText(msgAboutFail);
//
//                        lbl.get(0).setStyle("-fx-background-color: red");
//
//                        Image image = null;
//                        try {
//                            image = new Image(new FileInputStream("E:\\JFX\\No.png"));
//                        } catch (FileNotFoundException e) {
//                            e.printStackTrace();
//                        }
//                        ImageView imageView = new ImageView(image);
//                        imageView.setFitHeight(200);
//                        imageView.setFitWidth(200);
//
//                        photoPane.getChildren().add(imageView);
//                    }
//
//                }
//
//                if(str.equals("Cognex DM 474")){
//
//                    if(tra == 48){
//                        for (int i = 0;i < quantityOfLabels;i++){
//                            data += reader.readLine();
//                            data += "\n";
//                        }
//
//                        decriptedCods.appendText(data);
//                        System.out.println(data);
//
//                        countOfRead++;
//                        String msgAboutRead = "Read: " + countOfRead;
//                        infoAboutRead.setText(msgAboutRead);
//
//                        for(int i = 0;i < quantityOfLabels; i++){
//                            lbl.get(i).setStyle("-fx-background-color: green");
//                        }
//
//                    }
//                    if(tra == 70){
//                        decriptedCods.appendText("FAIL" + "\n");
//
//                        countOfFail++;
//                        String msgAboutFail = "Fail: " + countOfFail;
//                        infoAboutFail.setText(msgAboutFail);
//
//                        for(int i = 0;i < quantityOfLabels; i++){
//                            lbl.get(i).setStyle("-fx-background-color: red");
//                        }
//                    }
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            clicks++;
            String msgAboutTrigger = "Number of trigger: " + clicks;
            countOfTrigger.setText(msgAboutTrigger);




            percentageOfReadCounter = (countOfRead / (countOfRead + countOfFail)) * 100;
            String msgAboutPercentageOfRead = "Percentage of reads: " + percentageOfReadCounter;
            percentageOfReads.setText(msgAboutPercentageOfRead);
            percentageOfFailCounter = (countOfFail / (countOfFail + countOfRead) * 100);
            String msgAboutPercentageOfFail = "Percentage of fails: " + percentageOfFailCounter;
            percentageOfFails.setText(msgAboutPercentageOfFail);


            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("Read", countOfRead),
                    new PieChart.Data("Fail", countOfFail)
            );

            Chart.setData(pieChartData);


        });


        DisConnect.setOnAction(actionEvent -> {

            WorkWithConnection.disconnectFromCamera(str, IP.getText());

        });

        tnCamera.setOnAction(actionEvent -> {
            ActionCommand.tune();

        });

        resetAllStatistic.setOnAction(actionEvent -> {

            clicks = 0;
            countOfFail = 0;
            countOfRead = 0;
            percentageOfFailCounter = 0;
            percentageOfReadCounter = 0;


            //?????????????????? ???????????????? ??????????????????
            String msgAboutTrigger = "Number of trigger: " + clicks;
            countOfTrigger.setText(msgAboutTrigger);

            //?????????????????? ???????????????????? ?? ????????????
            String msgAboutFail = "Fail: " + countOfFail;
            infoAboutFail.setText(msgAboutFail);

            //?????????????????? ???????????????????? ?? ??????????????????????
            String msgAboutRead = "Read: " + countOfRead;
            infoAboutRead.setText(msgAboutRead);

            //?????????????????? ???????????????????? ?? ???????????????? ????????????
            String msgAboutPercentageOfFail = "Percentage of fail: 0.0000";
            percentageOfFails.setText(msgAboutPercentageOfFail);

            //?????????????????? ???????????????????? ?? ???????????????? ????????????????????
            String msgAboutPercentageOfRead = "Percentage of read: 0.0000";
            percentageOfReads.setText(msgAboutPercentageOfRead);

        });

        resetSettings.setOnAction(actionEvent -> {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("WARNING!!!");
            alert.setContentText("?????? ???????????????? ?????????????????????????? ????????????????????" + "\n" + "???????????? ?????????????????????");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK){
                ActionCommand.reboot();
            }
            else {
                alert.close();
            }


        });

        openDataBaseWindow.setOnAction(actionEvent -> {


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/CognexLite/DBWindow/DBWindow.fxml"));

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

        Connect.setOnAction(actionEvent -> {



            if(WorkWithConnection.connectToCamera(IP.getText(), 23, str)){
                System.out.println("Ok");
            }
            else {
                System.out.println("Not ok");
            }

            if (str.equals("Cognex DM 262q")){
                lbl.get(0).setVisible(true);
            }

            if (str.equals("Cognex DM 374")){
                lbl.get(0).setVisible(true);
            }

            if(str.equals("Cognex DM 474")){
                Ok.setVisible(true);
            }

        });

        Ok.setOnAction(actionEvent -> {
            String key = new String();


            key = codQuantity.getText();


            if (str.equals("Cognex DM 474")){
                switch (key){
                    case("1") :
                        quantityOfLabels = 1;
                        break;
                    case("2") :
                        quantityOfLabels = 2;
                        break;
                    case("3") :
                        quantityOfLabels = 3;
                        break;
                    case("4") :
                        quantityOfLabels = 4;
                        break;
                    case("5") :
                        quantityOfLabels = 5;
                        break;
                    case("6") :
                        quantityOfLabels = 6;
                        break;
                    case("7") :
                        quantityOfLabels = 7;
                        break;
                    case("8") :
                        quantityOfLabels = 8;
                        break;
                    case("10") :
                        quantityOfLabels = 10;
                        break;
                    case("11") :
                        quantityOfLabels = 11;
                        break;
                    case("12") :
                        quantityOfLabels = 12;
                        break;
                    case("13") :
                        quantityOfLabels = 13;
                        break;
                    case("14") :
                        quantityOfLabels = 14;
                        break;
                    case("15") :
                        quantityOfLabels = 15;
                        break;
                    case("16") :
                        quantityOfLabels = 16;
                        break;
                    case("17") :
                        quantityOfLabels = 17;
                        break;
                    case("18") :
                        quantityOfLabels = 18;
                        break;
                    case("19") :
                        quantityOfLabels = 19;
                        break;
                    case("20") :
                        quantityOfLabels = 20;
                        break;
                    case("21") :
                        quantityOfLabels = 21;
                        break;
                    case("22") :
                        quantityOfLabels = 22;
                        break;
                    case("23") :
                        quantityOfLabels = 23;
                        break;
                    case("24") :
                        quantityOfLabels = 24;
                        break;
                    case("9") :
                        quantityOfLabels = 9;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + key);
                }
                for (int i = 0;i < quantityOfLabels;i++){
                    lbl.get(i).setVisible(true);
                }
            }
        });
    }



    public void Select(ActionEvent actionEvent) {

        str = Model.getSelectionModel().getSelectedItem().toString();

        if (str.equals("Cognex DM 474")){
            codQuantityLbl.setVisible(true);
            codQuantity.setVisible(true);
        }


    }
}
