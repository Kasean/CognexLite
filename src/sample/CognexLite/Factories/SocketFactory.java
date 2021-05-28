package sample.CognexLite.Factories;

import java.net.Socket;

public class SocketFactory {


    public static Socket createSocket(){

        Socket socket = new Socket();

        return socket;
    }


}
