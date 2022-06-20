/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS_OPP_Class.LoaiSP;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB_LoaiSP 
{
    QueryDB Q = new QueryDB();
    // Loai San Pham
    public ArrayList ReadLSP()
    {
        ArrayList <LoaiSP> ListLSP = new ArrayList<LoaiSP>();
        try
        {
            ResultSet rs = Q.SelectFormDB("loaisp");
            while(rs.next())
            {
                LoaiSP lsp = new LoaiSP();
                lsp.setMaLoai(rs.getString(1));
                lsp.setTenLoai(rs.getString(2));
                ListLSP.add(lsp);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showInternalMessageDialog(null,"ERROR Read csdl loại Sản Phẩm !");
        }
        return ListLSP;    
    }
    
    public void AddLSP(LoaiSP lsp)
    {
        String q ="loaisp`(`MaLoai`, `TenLoai`) VALUES ('";
        q = q + lsp.getMaLoai() + "','";
        q = q + lsp.getTenLoai() + "')";
        Q.InsertDB(q);
    }
    
    public void FixLSP(String MaLoai, LoaiSP lsp1)
    {
        String q ="loaisp` SET `MaLoai`='";
        q = q + lsp1.getMaLoai() + "',`TenLoai`='";
        q = q + lsp1.getTenLoai() + "' WHERE MaLoai='";
        q = q + MaLoai + "'";
        Q.UpdateDB(q);
    }
    
    public void DelLSP(String MaLoai)
    {
        String q = "loaisp` WHERE MaLoai='";
        q = q + MaLoai + "'";
        Q.DeleteDB(q);
    }
}
