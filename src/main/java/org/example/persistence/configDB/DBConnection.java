package org.example.persistence.configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;


    //THIS FUNCTION RETURN A CONNECTION
    public static Connection getConnection(){
        //HERE ARE THE INFORMATION ABOUT MY CONNECTION IN MYSQL
        String URL = "jdbc:mysql://127.0.0.1:3306/RiwiAcademyDB";
        String USER = "root";
        String PASSWORD = "tupassword";

        try{
            //HERE INSTANCE IT THE CONNECTION
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    //THIS IS A FUNCTION TO DISCONNECT THE DATABASE
    public static void closeConnection(){
        try{
            if(connection != null){
                connection.close();
            }else{
                return;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
