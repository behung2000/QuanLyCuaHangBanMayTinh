/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS_OPP_Class.CTHoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB_CTHoaDon 
{
    QueryDB Q = new QueryDB();
    
    // Chi Tiet Hoa Don
    public ArrayList ReadCTHD()
    {
        ArrayList <CTHoaDon> ListCTHD = new ArrayList<CTHoaDon>();
        try 
        {
            ResultSet rs = Q.SelectFormDB("chitiethoadon");
            while (rs.next()) 
            {
                CTHoaDon hd = new CTHoaDon();
                hd.setMaP(rs.getString(1));
                hd.setMaSP(rs.getString(2));
                hd.setMaKM(rs.getString(3));
                hd.setSL(rs.getInt(4));
                hd.setTTien(rs.getInt(5));
                ListCTHD.add(hd);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "ERROR Read csdl chi tiết hóa đơn !");
        }
        return ListCTHD;
    }
    
    public void AddCTHD(CTHoaDon hd)
    {
        String q = "chitiethoadon`(`MaHD`, `MaSP`, `MaKM`, `SoLuong`, `ThanhTien`) VALUES ('";
        q = q + hd.getMaP() + "','";
        q = q + hd.getMaSP() + "','";
        q = q + hd.getMaKM() + "','";
        q = q + hd.getSL() + "','";
        q = q + hd.getTTien() + "')";
        Q.InsertDB(q);
    }
    
    public void FixCTHD(CTHoaDon hd, CTHoaDon hd1)
    {
        String q = "chitiethoadon` SET `MaHD`='";
        q = q + hd1.getMaP() + "',`MaSP`='";
        q = q + hd1.getMaSP() + "',`MaKM`='";
        q = q + hd1.getMaKM() + "',`SoLuong`='";
        q = q + hd1.getSL() + "',`ThanhTien`='";
        q = q + hd1.getTTien() + "' WHERE MaHD='";
        q = q + hd.getMaP() + "' AND MaSP='";
        q = q + hd.getMaSP() + "'";
        Q.UpdateDB(q);
    }
    
    public void DelCTHD(CTHoaDon hd)
    {
        String q = "chitiethoadon` WHERE MaHD='";
        q = q + hd.getMaP() + "' AND MaSP='";
        q = q + hd.getMaSP() + "'";
        Q.DeleteDB(q);
    }
    
    public void DelCTHD1SP(String MaHD, String MaSP)
    {
        String q = "chitiethoadon` WHERE MaHD='";
        q = q + MaHD + "' AND MaSP='";
        q = q + MaSP + "'";
        Q.DeleteDB(q);
    }
    
    public void TruSP(String MaSP, int soluong)
    {
        String q = "thongtinsanpham` SET `SoLuong`='";
        q = q + soluong + "' WHERE `MaSP`='";
        q = q + MaSP + "'";
        Q.UpdateDB(q);
    }
}
