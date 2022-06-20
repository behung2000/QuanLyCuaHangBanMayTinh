/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS_OPP_Class.NhaSX;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB_SanXuat 
{
    QueryDB Q = new QueryDB();
    // Nha San Xuat
    public ArrayList ReadSX()
    {
        ArrayList <NhaSX> ListSX = new ArrayList<NhaSX>();
        try 
        {
            ResultSet rs = Q.SelectFormDB("nsx");
            while (rs.next()) 
            {
                NhaSX sx = new NhaSX();
                sx.setMaNSX(rs.getString(1));
                sx.setTenNSX(rs.getString(2));
                sx.setDiaChi(rs.getString(3));
                ListSX.add(sx);
            } 
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "ERROR Read csdl Sản Xuất !");
        }
        return ListSX;
    }
    
    public void AddSX(NhaSX sx)
    {
        String q = "nsx`(`MaNSX`, `TenNSX`, `DiaChi`) VALUES ('";
        q = q + sx.getMaNSX() + "','";
        q = q + sx.getTenNSX() + "','";
        q = q + sx.getDiaChi() + "')";
        Q.InsertDB(q);
    }
    
    public void FixSX(String MaNSX, NhaSX sx1)
    {
        String q = "nsx` SET `MaNSX`='";
        q = q + sx1.getMaNSX() + "',`TenNSX`='";
        q = q + sx1.getTenNSX() + "',`DiaChi`='";
        q = q + sx1.getDiaChi() + "' WHERE MaNSX='";
        q = q + MaNSX + "'";
        Q.UpdateDB(q);
    }
    
    public void DelSX(String MaNSX)
    {
        String q = "nsx` WHERE MaNSX='";
        q = q + MaNSX + "'";
        Q.DeleteDB(q);
    }
}
