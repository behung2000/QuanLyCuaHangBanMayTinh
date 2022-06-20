/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS_OPP_Class.NhaCC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB_CungCap 
{
    QueryDB Q = new QueryDB();
    // Nha Cung Cap
    public ArrayList ReadCC()
    {
        ArrayList <NhaCC> ListCC = new ArrayList<NhaCC>();
        try 
        {
            ResultSet rs = Q.SelectFormDB("nhacungcap");
            while (rs.next()) 
            {
                NhaCC cc = new NhaCC();
                cc.setMaCC(rs.getString(1));
                cc.setTenNCC(rs.getString(2));
                cc.setDiaChi(rs.getString(3));
                cc.setSDT(rs.getString(4));
                ListCC.add(cc);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "ERROR Read csdl Nhà cung cấp !");
        }
        return ListCC;
    }
    
    public void AddCC(NhaCC cc)
    {
        String q = "nhacungcap`(`MaCC`, `TenNCC`, `Diachi`, `SDT`) VALUES ('";
        q = q + cc.getMaCC() + "','";
        q = q + cc.getTenNCC() + "','";
        q = q + cc.getDiaChi() + "','";
        q = q + cc.getSDT() + "')";
        Q.InsertDB(q);
    }
    
    public void FixCC(String MaCC, NhaCC cc1)
    {
        String q = "nhacungcap` SET `MaCC`='";
        q = q + cc1.getMaCC() + "',`TenNCC`='";
        q = q + cc1.getTenNCC() + "',`Diachi`='";
        q = q + cc1.getDiaChi() + "',`SDT`='";
        q = q + cc1.getSDT() + "' WHERE MaCC='";
        q = q + MaCC + "'";
        Q.UpdateDB(q);
    }
    
    public void DelCC(String MaCC)
    {
        String q = "nhacungcap` WHERE MaCC='";
        q = q + MaCC + "'";
        Q.DeleteDB(q);
    }
}
