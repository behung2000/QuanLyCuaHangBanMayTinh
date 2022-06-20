/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS_OPP_Class.BaoHanh;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB_BaoHanh 
{    
    QueryDB Q = new QueryDB();
    
    // Bao Hanh
    public ArrayList ReadBH()
    {
        ArrayList <BaoHanh> ListBH = new ArrayList<BaoHanh>();
        try 
        {
            ResultSet rs = Q.SelectFormDB("`baohanh`");
            while (rs.next()) 
            {
                BaoHanh bh = new BaoHanh();
                bh.setMaBH(rs.getString(1));
                bh.setVitri(rs.getBoolean(2));
                bh.setTG(rs.getInt(3));
                ListBH.add(bh);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "ERROR Read csdl Bảo Hành !");
        }
        return ListBH;
    }
    
    public void AddBH(BaoHanh bh)
    {
        String q = "baohanh`(`MaBH`, `ViTriBH`, `ThoiGianBH`) VALUES ('";
        q = q + bh.getMaBH() + "','";
        q = q + bh.getVitri() + "','";
        q = q + bh.getTG() + "')";
        Q.InsertDB(q);
    }
    
    public void FixBH(String MaBH, BaoHanh bh1)
    {
        String q ="baohanh` SET `MaBH`='";
        q = q + bh1.getMaBH() + "',`ViTriBH`='";
        q = q + bh1.getVitri() + "',`ThoiGianBH`='";
        q = q + bh1.getTG() + "' WHERE MaBH='";
        q = q + MaBH + "'";
        Q.UpdateDB(q);
    }
    
    public void DelBH(String MaBH)
    {
        String q = "baohanh` WHERE MaBH='";
        q = q + MaBH + "'";
        Q.DeleteDB(q);
    }
}
