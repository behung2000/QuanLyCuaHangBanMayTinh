/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS_OPP_Class.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB_NhanVien 
{
    QueryDB Q = new QueryDB();
    // Nhan Vien
    public ArrayList ReadNhanVien()
    {
        ArrayList <NhanVien> ListNV = new ArrayList<NhanVien>();
        try 
        {
            ResultSet rs = Q.SelectFormDB("`nhanvien`");
            while(rs.next())
            {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setTenNV(rs.getString(2));
                nv.setCMND(rs.getString(3));
                nv.setPassword(rs.getString(4));
                nv.setChucvu(rs.getInt(5));
                nv.setluong(rs.getInt(6));
                ListNV.add(nv);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null,"ERROR Read csdl Nhân Viên !");
        }
        return ListNV;
    }
    
    public void AddNhanVien(NhanVien nv)
    {
        String q = "nhanvien`(`MaNV`, `TenNV`, `CMND`, `Password`, `ChucVu`, `Luong`) VALUES ('";
        q=q+nv.getMaNV()+"','";
        q=q+nv.getTenNV()+"','";
        q=q+nv.getCMND()+"','";
        q=q+nv.getPassword()+"','";
        q=q+nv.getChucvu()+"','";
        q=q+nv.getluong()+"')";
        Q.InsertDB(q);
    }
    
    public void FixNhanVien(String MaNV, NhanVien nv1)
    {
        String q = "nhanvien` SET `MaNV`='";
        q = q + nv1.getMaNV()+ "',`TenNV`='";
        q = q + nv1.getTenNV()+ "',`CMND`='";
        q = q + nv1.getCMND()+ "',`Password`='";
        q = q + nv1.getPassword()+ "',`ChucVu`='";
        q = q + nv1.getChucvu()+ "',`Luong`='";
        q = q + nv1.getluong()+ "' WHERE MaNV='";
        q = q + MaNV +"'";
        Q.UpdateDB(q);
    }
    
    public void DelNhanVien(String MaNV)
    {
        String q = "nhanvien` WHERE MaNV='";
        q = q + MaNV +"'";
        Q.DeleteDB(q);
    }
}
