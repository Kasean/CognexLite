package sample.DBWindow;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.DataBaseControllers.DoCRUD;

public class DBController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TextArea DBData;

    @FXML
    private Button getData;


    @FXML
    private Button connectToDataBase;

    @FXML
    private TextField urlField;



    @FXML
    void initialize() {
        DoCRUD work = new DoCRUD();
        connectToDataBase.setOnAction(actionEvent -> {
            String DataBaseName = urlField.getText();

            String url = "jdbc:sqlite:" + DataBaseName + ".db";

            work.connectToDataBase(url);
        });

        getData.setOnAction(actionEvent -> {
            ArrayList<String> stringsFromDB = work.Read();
            ArrayList<String> ID = new ArrayList<>();
            ArrayList<String> CODS = new ArrayList<>();
            
            for (int i = 0;i < stringsFromDB.size();i++){
                String[] components = stringsFromDB.get(i).split(" ########## ");
                ID.add(components[0]);
                CODS.add(components[1]);
            }

            ArrayList <Data> all = new ArrayList<>();

            for (int i = 0;i < ID.size();i++){
                Data data =  new Data(ID.get(i), CODS.get(i));
                all.add(i, data);
            }

            for (int i = 0;i < all.size();i++){
                DBData.appendText("[ID]: " + all.get(i).Id + "    [COD]: " + all.get(i).Cods + "\n");
            }


        });
    }
}
