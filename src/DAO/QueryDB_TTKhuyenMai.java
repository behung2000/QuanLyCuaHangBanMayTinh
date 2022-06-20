/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS_OPP_Class.TTKhuyenMai;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB_TTKhuyenMai 
{
    QueryDB Q = new QueryDB();
    //TT Khuyen Mai
    public ArrayList ReadTTKM()
    {
        ArrayList <TTKhuyenMai> ListKM = new ArrayList<TTKhuyenMai>();
        try 
        {
            ResultSet rs = Q.SelectFormDB("thongtinkhuyenmai");
            while (rs.next()) 
            {
                TTKhuyenMai km = new TTKhuyenMai();
                km.setMaKM(rs.getString(1));
                km.setSL(rs.getInt(2));
                km.setGiamGia(rs.getInt(3));
                km.setNgayBD(rs.getString(4));
                km.setNgayKT(rs.getString(5));
                ListKM.add(km);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "ERROR Read csdl Thông Tin Khuyến Mãi !");
        }
        return ListKM;
    }
    
    public void AddTTKM(TTKhuyenMai km)
    {
        String q = "thongtinkhuyenmai`(`MaKM`, `SoLuongCanMua`, `GiamGia(phantram)`, `NgayBD`, `NgayKT`) VALUES ('";
        q = q + km.getMaKM() + "','";
        q = q + km.getSL()+ "','";
        q = q + km.getGiamGia() + "','";
        q = q + km.getNgayBD() + "','";
        q = q + km.getNgayKT() + "')"; 
        Q.InsertDB(q);
    }
    
    public void FixTTKM(String MaKM, TTKhuyenMai km1)
    {
        String q = "thongtinkhuyenmai` SET `MaKM`='";
        q = q + km1.getMaKM() + "',`SoLuongCanMua`='";
        q = q + km1.getSL() + "',`GiamGia(phantram)`='";
        q = q + km1.getGiamGia() + "',`NgayBD`='";
        q = q + km1.getNgayBD() + "',`NgayKT`='";
        q = q + km1.getNgayKT() + "' WHERE MaKM='";
        q = q + MaKM + "'";
        Q.UpdateDB(q);
    }
    
    public void DelTTKM(String MaKM)
    {
        String q = "thongtinkhuyenmai` WHERE MaKM='";
        q = q + MaKM + "'";
        Q.DeleteDB(q);
    }
    
    public void DelALLTTKM()
    {
        String q = "thongtinkhuyenmai`";
        Q.DeleteDB(q);
    }
}
