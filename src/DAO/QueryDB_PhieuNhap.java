/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS_OPP_Class.PhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB_PhieuNhap 
{
    QueryDB Q = new QueryDB();
    
    // Phiếu Nhập
    public ArrayList ReadPN()
    {
        ArrayList <PhieuNhap> ListPN = new ArrayList<PhieuNhap>();
        try 
        {
            ResultSet rs = Q.SelectFormDB("phieunhap");
            while (rs.next()) 
            {
                PhieuNhap pn = new PhieuNhap();
                pn.setMaP(rs.getString(1));
                pn.setMaCC(rs.getString(2));
                pn.setMaNV(rs.getString(3));
                pn.setNgay(rs.getString(4));
                pn.setTTien(rs.getInt(5));
                ListPN.add(pn);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "ERROR Read csdl Phiếu nhập !");
        }
        return ListPN;
    }
    
    public void AddPN(PhieuNhap pn)
    {
        String q = "phieunhap`(`MaPN`, `MaCC`, `MaNV`, `NgayNhap`, `TongTien`) VALUES ('";
        q = q + pn.getMaP() + "','";
        q = q + pn.getMaCC() + "','";
        q = q + pn.getMaNV() + "','";
        q = q + pn.getNgay() + "','";
        q = q + pn.getTTien() + "')";
        Q.InsertDB(q);
    }
    
    public void FixPN(PhieuNhap pn, PhieuNhap pn1)
    {
        String q = "phieunhap` SET `MaPN`='";
        q = q + pn1.MaP + "',`MaCC`='";
        q = q + pn1.MaCC + "',`MaNV`='";
        q = q + pn1.getMaNV() + "',`NgayNhap`='";
        q = q + pn1.getNgay() + "',`TongTien`='";
        q = q + pn1.getTTien() + "' WHERE MaPN='";
        q = q + pn.getMaP() + "'";
        Q.UpdateDB(q);
    }
    
    public void DelPN(String MaPN)
    {
        String q = "phieunhap` WHERE MaPN='";
        q = q + MaPN + "'";
        Q.DeleteDB(q);
    }
    
    
}
