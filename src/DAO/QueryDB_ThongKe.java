/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author WIN7
 */
public class QueryDB_ThongKe 
{
    QueryDB Q = new QueryDB();
    
    public int thongKeNhanVien() throws SQLException
    {
        String q = "nhanvien";
        int dem = 0;
        ResultSet rs = Q.CountFormDB(q);
        while(rs.next())
        {
            dem = rs.getInt(1);
        }
        return dem;
    }
    
    public int thongKeKhachHang() throws SQLException
    {
        String q = "khachhang";
        int dem = 0;
        ResultSet rs = Q.CountFormDB(q);
        Q.CountFormDB(q);
        while(rs.next())
        {
            dem = rs.getInt(1);
        }
        return dem;
    }
    
    public int thongKeSanPham() throws SQLException
    {
        String q = "thongtinsanpham";
        int dem = 0;
        ResultSet rs = Q.CountFormDB(q);
        Q.CountFormDB(q);
        while(rs.next())
        {
            dem = rs.getInt(1);
        }
        return dem;
    }
    
    public int thongKeNhaSanXuat() throws SQLException
    {
        String q = "nsx";
        int dem = 0;
        ResultSet rs = Q.CountFormDB(q);
        Q.CountFormDB(q);
        while(rs.next())
        {
            dem = rs.getInt(1);
        }
        return dem;
    }
    
    public int thongKeNhaCungCap() throws SQLException
    {
        String q = "nhacungcap";
        int dem = 0;
        ResultSet rs = Q.CountFormDB(q);
        Q.CountFormDB(q);
        while(rs.next())
        {
            dem = rs.getInt(1);
        }
        return dem;
    }
    
    public ResultSet thongKeTheoThang(int month)
    {
        String q = "hoadon where month(`NgayBan`)="+month;
        ResultSet rs = Q.SelectFormDB(q);
        return rs;
    }
    
    public ResultSet thongKeGiua2Ngay(String ngaybd, String ngaykt)
    {
        String q = "hoadon where `NgayBan` between \""+ngaybd+"\"and \""+ngaykt+"\"";
        ResultSet rs = Q.SelectFormDB(q);
        return rs;
    }

}
