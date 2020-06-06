package Db;

import dbUtils.Connect;
import pojo.Admin;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static dbUtils.Connect.getConnection;

public class CreateDB {

    public static void main(String[] args) {


    }
    public static Connection getConnectionos(){
        Connection connection = null;
        try {
           connection = Connect.getConnection();

        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void insertTables(){
        try {
            Connection connection = getConnectionos();
            String query = "ALTER TABLE users MODIFY beginning date";
            String query1 = "ALTER TABLE users ADD end date";
            Statement st = connection.createStatement();
            st.executeUpdate(query);
            st.executeUpdate(query1);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void createTables(){
        try{
            Connection connection = getConnectionos();
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE users (name varchar(30) NOT NULL, lastName varchar(30) NOT NULL PRIMARY KEY , address VARCHAR(100) NOT NULL, booksRented int NOT NULL, book VARCHAR(100) NOT NULL )";
            statement.execute(query);
        }catch (SQLException e){
            System.err.println("Sthg. gone wrong...");
            System.out.println(e.getMessage());
        }
    }
}