/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS_OPP_Class.LoaiSP;
import BUS_OPP_Class.TTSanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB_SanPham {

    QueryDB Q = new QueryDB();

    // San Pham
    public ArrayList ReadTTSP() {
        ArrayList<TTSanPham> ListSP = new ArrayList<TTSanPham>();
        try {
            ResultSet rs = Q.SelectFormDB("thongtinsanpham");
            while (rs.next()) {
                TTSanPham sp = new TTSanPham();
                sp.setMaSP(rs.getString(1));
                sp.setMaNSX(rs.getString(2));
                sp.setTenSP(rs.getString(3));
                sp.setTT(rs.getString(4));
                sp.setSL(rs.getInt(5));
                sp.setGN(rs.getInt(6));
                sp.setMaCC(rs.getString(7));
                sp.setDG(rs.getInt(8));
                sp.setMaLoai(rs.getString(9));
                sp.setMaBH(rs.getString(10));
                ListSP.add(sp);
            }
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "ERROR Read csdl Sản Phẩm !");
        }
        return ListSP;
    }

    public void AddTTSP(TTSanPham sp) 
    {
        String q = "thongtinsanpham`(`MaSP`, `MaNSX`, `TenSP`, `ThongTin`, `SoLuong`, `GiaNhap`, `MaCC`, `DonGia`, `MaLoai`, `MaBH`) VALUES ('";
        q = q + sp.getMaSP() + "','";
        q = q + sp.getMaNSX() + "','";
        q = q + sp.getTenSP() + "','";
        q = q + sp.getTT() + "','";
        q = q + sp.getSL() + "','";
        q = q + sp.getGN() + "','";
        q = q + sp.getMaCC() + "','";
        q = q + sp.getDG() + "','";
        q = q + sp.getMaLoai() + "','";
        q = q + sp.getMaBH() + "')";
        Q.InsertDB(q);
    }
    
    public void FixTTSP(String MaSP, TTSanPham sp1)
    {
        String q = "thongtinsanpham` SET `MaSP`='";
        q = q + sp1.getMaSP() + "',`MaNSX`='";
        q = q + sp1.getMaNSX() + "',`TenSP`='";
        q = q + sp1.getTenSP() + "',`ThongTin`='";
        q = q + sp1.getTT() + "',`SoLuong`='";
        q = q + sp1.getSL() + "',`GiaNhap`='";
        q = q + sp1.getGN() + "',`MaCC`='";
        q = q + sp1.getMaCC() + "',`DonGia`='";
        q = q + sp1.getDG() + "',`MaLoai`='";
        q = q + sp1.getMaLoai() + "',`MaBH`='";
        q = q + sp1.getMaBH() + "' WHERE MaSP='";
        q = q + MaSP + "'";
        Q.UpdateDB(q);
    }
    
    public void DelTTSP(String MaSP)
    {
        String q = "thongtinsanpham` WHERE MaSP='";
        q = q + MaSP + "'";
        Q.DeleteDB(q);
    }
}
