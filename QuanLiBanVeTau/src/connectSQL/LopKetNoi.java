/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectSQL;


import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class LopKetNoi {
    private Connection connection;
    
    
    public LopKetNoi(){
        
        String url = "jdbc:sqlserver://;databaseName=QuanLiVeTau";
        String user = "sa";
        String pass = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection  = DriverManager.getConnection(url, user, pass);
            System.out.println("Ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LopKetNoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    public ResultSet selectQuery(String sql){
        ResultSet rs = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
  
}
