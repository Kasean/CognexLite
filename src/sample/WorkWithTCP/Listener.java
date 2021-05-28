package sample.WorkWithTCP;

import sample.CognexLite.Connect.WorkWithConnection;
import sample.DataTransportClasses.TCPDataTransportClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Listener {

    private static final String start = "<start>";
    private static final String stop = "<stop>";
    private static final String fail = "fail";
    private static final String quality = "quality";
    private static String temp = null;
    private static String result = null;


    public static void listenToPort(){
        while (true){
            try {

                BufferedReader reader = new BufferedReader(new InputStreamReader(WorkWithConnection.getSocket().getInputStream()));
                if(reader.readLine().equals(start)){

                    while (!((temp = reader.readLine()).equals(stop))){

                        result += temp;

                    }

                    TCPDataTransportClass.setResult(result);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
