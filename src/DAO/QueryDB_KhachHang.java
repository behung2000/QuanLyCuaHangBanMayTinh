/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS_OPP_Class.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB_KhachHang {
    // Khach Hang
    
    QueryDB Q = new QueryDB();
    
    public ArrayList ReadKhachHang()
    {
        ArrayList <KhachHang> ListKH = new ArrayList <KhachHang>();
        try
        {
            ResultSet rs = Q.SelectFormDB("khachhang");
            while(rs.next())
            {
                KhachHang kh = new KhachHang();
                kh.setCMND(rs.getString(1));
                kh.setTenKH(rs.getString(2));
                kh.setSDT(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                ListKH.add(kh);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showInternalMessageDialog(null,"ERROR Read csdl Khách Hàng !");
        }
        return ListKH;
    }
    
    public void AddKhachHang(KhachHang kh)
    {
        String q = "khachhang`(`CMND`,`TenKH`,`SDT`,`DiaChi`) VALUES ('";
        q=q+kh.getCMND()+"','";
        q=q+kh.getTenKH()+"','";
        q=q+kh.getSDT()+"','";
        q=q+kh.getDiaChi()+"')";
        Q.InsertDB(q);
    }
    
    public void FixKhachHang(String MaKH, KhachHang kh1)
    {
        String q = "khachhang` SET `CMND`='";
        q = q + kh1.getCMND() + "',`TenKH`='";
        q = q + kh1.getTenKH() + "',`SDT`='";
        q = q + kh1.getSDT() + "',`DiaChi`='";
        q = q + kh1.getDiaChi() + "' WHERE CMND='";
        q = q + MaKH +"'";
        Q.UpdateDB(q);
    }
    
    public void DelKhachHang(String MaKH)
    {
        String q = "khachhang` WHERE CMND='";
        q = q + MaKH +"'";
        Q.DeleteDB(q);
    }
}
