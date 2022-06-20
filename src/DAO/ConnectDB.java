/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author thaiv
*/

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnectDB 
{
    public String databaseName="storecomputer";
    public String hostname="localhost";
    public String user="root";
    public String pass="";
    public String dbURL = "jdbc:mysql://"+hostname+":3306/"+databaseName;
    public Connection conn=null;
    public Statement st=null;
    public ResultSet rs=null;
    
    public ConnectDB()
    {
        try
        {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = (Connection) DriverManager.getConnection(dbURL,user,pass);
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null,"Kết nối Database thất bại !");
            System.exit(0);
        }
        
        
    }
    
    public Connection OpenDB()
    {
        return conn;
    }
    
    public void CloseDB() throws SQLException
    {
        conn.close();
    }
}
