/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB
{
    public ConnectDB c = new ConnectDB();
    public Connection conn = c.OpenDB();
    public Statement st=null;
    public ResultSet rs=null;
    
    public ResultSet SelectDB(String q)
    {
        if(conn != null)
        {
            String qry="SELECT "+q;
            try
            {
                st = conn.createStatement();
                rs = st.executeQuery(qry);
                return rs;
            }
            catch(SQLException ex)
            {
                JOptionPane.showInternalMessageDialog(null,"truy cập thất bại ! "+qry);
                
            }
        }
        return null;
    }
    
    public ResultSet SelectFormDB(String q)
    {
        if(conn != null)
        {
            String qry="SELECT * FROM "+q;
            try
            {
                st = conn.createStatement();
                rs = st.executeQuery(qry);
                return rs;
            }
            catch(SQLException ex)
            {
                JOptionPane.showInternalMessageDialog(null,"truy cập thất bại ! "+qry);
                
            }
        }
        return null;
    }
    
    public ResultSet CountFormDB(String q)
    {
        if(conn != null)
        {
            String qry="SELECT count(*) FROM "+q;
            try
            {
                st = conn.createStatement();
                rs = st.executeQuery(qry);
                return rs;
            }
            catch(SQLException ex)
            {
                JOptionPane.showInternalMessageDialog(null,"truy cập thất bại ! "+qry);
                
            }
        }
        return null;
    }
    
    public void InsertDB(String q) 
    {
        if(conn != null)
        {
            String qry="INSERT INTO `"+q;
            try
            {
                st = conn.createStatement();
                st.executeUpdate(qry);
            }
            catch (SQLException ex) 
            {
                JOptionPane.showInternalMessageDialog(null,"Thêm thất bại ! "+qry);
            }
        }
            
    }
    
    public void DeleteDB(String q)
    {
        if(conn != null)
        {
            String qry="DELETE FROM `"+q;
            try
            {
                st = conn.createStatement();
                st.executeUpdate(qry);
            }
            catch (SQLException ex) 
            {
                JOptionPane.showInternalMessageDialog(null,"Xóa thất bại ! "+qry);
            }
        }
    }
    
    public void UpdateDB(String q)
    {
        if(conn != null)
        {
            String qry="UPDATE `"+q;
            try
            {
                st = conn.createStatement();
                st.executeUpdate(qry);
            }
            catch (SQLException ex) 
            {
                JOptionPane.showInternalMessageDialog(null,"Sửa thất bại ! "+qry);
            }
        }
    }
}
