package com.Greg;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        com.Greg.ToDoList List = new com.Greg.ToDoList();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Get a connection to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_list", "root", "number21");

            // Create a statement
            Statement state = conn.createStatement();

            // Execute SQL query
            ResultSet mySet = state.executeQuery("SELECT * FROM all_tasks");



        }
        catch (ClassNotFoundException cnfe)    {
            System.out.println("Can't instantiate driver class; check you have drives and classpath configured   correctly?");
            cnfe.printStackTrace();
            System.exit(-1); //No driver? Need to fix before anything else will work. So quit the program
        }
        catch (Exception e)    {
            e.printStackTrace();
        }
    }
}