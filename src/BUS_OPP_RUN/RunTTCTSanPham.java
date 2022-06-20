/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

import DAO.QueryDB_CTTTSanPham;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaiv
 */
public class RunTTCTSanPham extends ArrayListALL
{
    QueryDB_CTTTSanPham Q = new QueryDB_CTTTSanPham();
    
    public DefaultTableModel ReadCTTTSP()
    {
        return FT.khungtableCTTTSP(Q.ReadTTCTSP());
    }
    
    public String LCCB(int i)
    {
        switch(i)
        {
            case 0:
            {
                return "MaSP";
            }
            case 1:
            {
                return "TenSP";
            }
            case 2:
            {
                return "TenLoai";
            }
            case 3:
            {
                return "TenNSX";
            }
            case 4:
            {
                return "ThoiGianBH";
            }
            default: return null;
        }
    }
    
     public String LCCBBanHang(int i)
    {
        switch(i)
        {
            case 1:
            {
                return "TenSP";
            }
            case 2:
            {
                return "TenLoai";
            }
            case 3:
            {
                return "TenNSX";
            }
            default: return null;
        }
    }
    
    public DefaultTableModel TimKiem(String st, int i)
    {
        return FT.khungtableCTTTSP(Q.TimKiem(LCCB(i), st));
    }
    
    public DefaultTableModel SapXep(int i)
    {
        return FT.khungtableCTTTSP(Q.SapXep(LCCB(i)));
    }
    
    public DefaultTableModel KetHop(String st, int i, int j)
    {
        return FT.khungtableCTTTSP(Q.KetHop(LCCB(i), st, LCCB(j)));
    }
    
    public DefaultTableModel TimKiemBanHang(String st, int i)
    {
        return FT.khungtableCTTTSP(Q.TimKiem(LCCBBanHang(i), st));
    }
}
