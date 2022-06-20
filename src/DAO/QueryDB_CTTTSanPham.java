/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;

/**
 *
 * @author thaiv
 */
public class QueryDB_CTTTSanPham 
{
    QueryDB Q = new QueryDB();
    
    public ResultSet ReadChung(String q)
    {
        String qry = "thongtinsanpham.MaSP, ";
        qry = qry + "TenSP, TenLoai, ";
        qry = qry + "ThongTin, SoLuong, ";
        qry = qry + "DonGia, TenNSX, ";
        qry = qry + "ViTriBH, ThoiGianBH ";
        qry = qry + "FROM thongtinsanpham, ";
        qry = qry + "loaisp, baohanh, nsx ";
        qry = qry + "WHERE thongtinsanpham.MaLoai=loaisp.MaLoai ";
        qry = qry + "AND thongtinsanpham.MaNSX=nsx.MaNSX ";
        qry = qry + "AND thongtinsanpham.MaBH=baohanh.MaBH ";
        qry = qry + q;
        return Q.SelectDB(qry);
    }
    
    public ResultSet ReadTTCTSP()
    {
        return ReadChung("");
    }
    
    public ResultSet SapXep(String q)
    {
        String qry = "ORDER BY "+q;
        return ReadChung(qry);
    }
    
    public ResultSet TimKiem(String ma, String q)
    {
        String qry = "AND "+ma+" LIKE '%"+q+"%'";
        return ReadChung(qry);
    }
    
    public ResultSet KetHop(String ma, String q1, String q2)
    {
        String qry = "AND "+ma+" LIKE '%"+q1+"%' "+"ORDER BY "+q2;
        return ReadChung(qry);
    }
    
}
