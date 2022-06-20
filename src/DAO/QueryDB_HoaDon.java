/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS_OPP_Class.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB_HoaDon 
{
    QueryDB Q = new QueryDB();
    // Hoa Don
    public ArrayList ReadHD()
    {
        ArrayList <HoaDon> ListHD = new ArrayList<HoaDon>();
        try 
        {
            ResultSet rs = Q.SelectFormDB("hoadon");
            while (rs.next()) 
            {
                HoaDon hd = new HoaDon();
                hd.setMaP(rs.getString(1));
                hd.setMaNV(rs.getString(2));
                hd.setMaKH(rs.getString(3));
                hd.setNgay(rs.getString(4));
                hd.setTTien(rs.getInt(5));
                ListHD.add(hd);
            }

        } catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "ERROR Read csdl Hóa Đơn !");
        }
        return ListHD;
    }
    
    public void AddHD(HoaDon hd)
    {
        String q = "hoadon` (`MaHD`,`MaNV`,`MaKH`,`NgayBan`,`TongTien`) VALUES ('";
        q = q + hd.getMaP() + "','";
        q = q + hd.getMaNV() + "','";
        q = q + hd.getMaKH() + "','";
        q = q + hd.getNgay() + "','";
        q = q + hd.getTTien() + "')";
        Q.InsertDB(q);
    }
    
    public void FixHD(HoaDon hd, HoaDon hd1)
    {
        String q = "hoadon` SET `MaHD`='";
        q = q + hd1.getMaP() + "',`MaNV`='";
        q = q + hd1.getMaNV() + "',`MaKH`='";
        q = q + hd1.getMaKH() + "',`NgayBan`='";
        q = q + hd1.getNgay() + "',`TongTien`='";
        q = q + hd1.getTTien() + "' WHERE MaHD='";
        q = q + hd.getMaP() + "'";
        Q.UpdateDB(q);
    }
    
    public void DelHD(String MaHD)
    {
        String q = "hoadon` WHERE MaHD='";
        q = q + MaHD + "'";
        Q.DeleteDB(q);
    }
}
