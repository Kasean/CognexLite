package sample.CognexLite.Connect;

import javafx.scene.control.Alert;
import sample.CognexLite.Factories.SocketFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

public class WorkWithConnection {

    private static Socket socket;

    private static int countOfSocket = 0;

    public static boolean connectToCamera(String IP, int PORT, String str){

        socket = SocketFactory.createSocket();

        try{
            socket.connect(new InetSocketAddress(IP, PORT));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION");
            alert.setHeaderText("Information about connect");
            alert.setContentText("Вы подключились к камере: " + "\n" +
                    "NAME: " + str + "\n" +
                    "IP: " + IP + "\n" +
                    "Socket № " + countOfSocket + " opened");

            alert.showAndWait();

            System.out.println("Вы подключились к камере: " + str + " IP: " + IP +
                    " используя сокет №: " + countOfSocket + " из пула сокетов");

            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }

    }

    public static void disconnectFromCamera(String str, String IP){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText("Information about disconnect");
        alert.setContentText("Вы отключились от камеры: " + "\n" +
                "NAME: " + str + "\n" +
                "IP: " + IP + "\n" +
                "Socket № " + countOfSocket + " closed");

        alert.showAndWait();

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        countOfSocket++;

    }

    public static Socket getSocket() {
        return socket;
    }

    public static int getCountOfSocket() {
        return countOfSocket;
    }
}
