/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

import BUS_OPP_Class.CTPhieuNhap;
import DAO.QueryDB_CTPhieuNhap;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author thaiv
 */
public class RunCTPhieuNhap extends ArrayListALL
{
    QueryDB_CTPhieuNhap Q = new QueryDB_CTPhieuNhap();
    // Chi Tiet Phieu Nhap
    public RunCTPhieuNhap()
    {
        ReadCTPN();
    }
    
    public void ReadCTPN()
    {
        if(ListCTPN==null)
        {
            ListCTPN = new ArrayList<CTPhieuNhap>();
            ListCTPN = Q.ReadCTPN();
        }
    }
    
    public void AddCTPN(String MaPN, String MaSP, int SoLuong, int Tien)
    {
        CTPhieuNhap ctpn = new  CTPhieuNhap();
        ctpn.setMaP(MaPN);
        ctpn.setMaSP(MaSP);
        ctpn.setSL(SoLuong);
        ctpn.setTTien(Tien);
        Q.AddCTPN(ctpn);
        ListCTPN=null;
        ReadCTPN();
    }
    
    public void Del1SPTrongPN(String MaPN, String MaSP)
    {
        Q.Del1SPTrongPN(MaPN, MaSP);
        ListCTPN=null;
        ReadCTPN();
    }
    
    //Nhập hàng
    public Vector NhapHang(String masp, int sl, int tien)
    {
        Vector row = new Vector();
        row.add(masp);
        row.add(sl);
        row.add(tien);
        return row;
    }
    
    public void CongSP(String MaSP, int soluongkho, int soluongnhap, int Tien)
    {
        int TB = Tien/soluongnhap;
        int soluong = soluongkho + soluongnhap;
        Q.CongSP(MaSP, soluong, TB);
    }
}
