/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS_OPP_Class.CTPhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB_CTPhieuNhap 
{
    QueryDB Q = new QueryDB();
    // Chi Tiet Phieu Nhap
    public ArrayList ReadCTPN()
    {
        ArrayList <CTPhieuNhap> ListCTPN = new ArrayList<CTPhieuNhap>();
        try 
        {
            ResultSet rs = Q.SelectFormDB("`chitietphieunhap`");
            while(rs.next()) 
            {
                CTPhieuNhap ctpn = new CTPhieuNhap();
                ctpn.setMaP(rs.getString(1));
                ctpn.setMaSP(rs.getString(2));
                ctpn.setSL(rs.getInt(3));
                ctpn.setTTien(rs.getInt(4));
                ListCTPN.add(ctpn);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "ERROR Read csdl chi tiết Phiếu nhập !");
        }
        return ListCTPN;
    }
    
    public void AddCTPN(CTPhieuNhap pn)
    {
        String q = "chitietphieunhap`(`MaPN`, `MaSP`, `SoLuong`, `ThanhTien`) VALUES ('";
        q = q + pn.getMaP() + "','";
        q = q + pn.getMaSP() + "','";
        q = q + pn.getSL() + "','";
        q = q + pn.getTTien() + "')";
        Q.InsertDB(q);
    }
    
    public void FixCTPN(CTPhieuNhap pn, CTPhieuNhap pn1)
    {
        String q = "chitietphieunhap` SET `MaPN`='";
        q = q + pn1.getMaP() + "',`MaSP`='";
        q = q + pn1.getMaSP() + "',`SoLuong`='";
        q = q + pn1.getSL() + "',`ThanhTien`='";
        q = q + pn1.getTTien() + "' WHERE MaPN='";
        q = q + pn.getMaP() + "' AND MaSP ='";
        q = q + pn.getMaSP() + "'";
        Q.UpdateDB(q);
    }
    
    public void DelCTPN(CTPhieuNhap pn)
    {
        String q = "chitietphieunhap` WHERE MaPN='";
        q = q + pn.getMaP() + "' AND MaSP='";
        q = q + pn.getMaSP() + "'";
        Q.DeleteDB(q);   
    }
    
    public void Del1SPTrongPN(String MaPN, String MaSP)
    {
        String q = "chitietphieunhap` WHERE MaPN='";
        q = q + MaPN + "' AND MaSP='";
        q = q + MaSP + "'";
        Q.DeleteDB(q); 
    }
    
    public void CongSP(String MaSP, int soluong, int Tien)
    {
        String q = "thongtinsanpham` SET `SoLuong`='";
        q = q + soluong + "', `GiaNhap`='";
        q = q + Tien + "' WHERE `MaSP`='";
        q = q + MaSP + "'";
        Q.UpdateDB(q);
    }
}
