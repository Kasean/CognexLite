package sample.DataBaseControllers;



import java.sql.*;
import java.util.ArrayList;

public class DoCRUD {

    private static Connection conn;




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
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return data;
    }
}
