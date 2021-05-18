package sample.Connecting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPRequest {

    public void doSomeRequest(){

        String actionCommands = "||>trigger on\\CR\\LF\n" +
                "\n";

        byte[] actionComm = actionCommands.getBytes();

        String urlAdress = "10.86.80.0";
        URL url;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try{

            url = new URL(urlAdress);
            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            httpURLConnection.setConnectTimeout(200);
            httpURLConnection.setReadTimeout(200);
            httpURLConnection.connect();

            try{
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(actionComm);
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

            if(HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()){
                System.out.println("good");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
