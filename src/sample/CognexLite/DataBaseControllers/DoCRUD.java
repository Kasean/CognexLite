package sample.CognexLite.DataBaseControllers;



import java.sql.*;
import java.util.ArrayList;

public class DoCRUD {

    private static Connection conn;



    public static void update(){
        try {
            Statement statement = conn.createStatement();
            String query = "INSERT INTO decryptedСodes (ID, Cods) VALUES(";

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }



    public static void connectToDataBase(String url){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("Connected");
        }catch (SQLException | ClassNotFoundException e){
            System.err.println(e.getMessage());
        }
    }

    public static ArrayList<String> Read(){


        ArrayList <String> data = new ArrayList<>();

        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM decryptedСodes";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt("ID");
                String cod = rs.getString("Cods");
                String result = id + " ########## " + cod;
                data.add(result);
            }
            rs.close();
            statement.close();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return data;
    }
}
