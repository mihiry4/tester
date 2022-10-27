package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
 


public class User {
    String username;
    String password;
    final String DB_URL = "jdbc:mysql://localhost/CampusCashDB";
    final String USER = "root";
    final String PASS = "iamonMars1!";


    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String login(){
        
        String ans = "empty";

        try(
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
          ) 
          {		      
                PreparedStatement preparedStatement = conn.prepareStatement(getLoginQuery());
                preparedStatement.setString(1, this.username);
                preparedStatement.setString(2, this.password);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                ans= resultSet.getString(3);
                try { resultSet.close(); } catch (Exception e) { /* Ignored */ }
                try { preparedStatement.close(); } catch (Exception e) { /* Ignored */ }
                try { conn.close(); } catch (Exception e) { /* Ignored */ }
          } catch (SQLException e) {
                e.printStackTrace();
          } 
          return ans;
    }

    public String getLoginQuery(){
        String s="SELECT * FROM user "+
                " WHERE username=? AND password=?";
        return s;
    }
    
}
