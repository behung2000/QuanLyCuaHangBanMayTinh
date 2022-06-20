/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;


import BUS_OPP_Class.CTHoaDon;
import BUS_OPP_Class.HoaDon;
import BUS_OPP_Class.TTKhuyenMai;
import DAO.QueryDB_CTHoaDon;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author thaiv
 */
public class RunCTHoaDon extends ArrayListALL
{
    QueryDB_CTHoaDon  Q = new QueryDB_CTHoaDon();
    
    public RunCTHoaDon()
    {
        ReadCTHD();
    }
    
    // Chi Tiet Hoa Don
    public void ReadCTHD()
    {
        if(ListCTHD==null)
        {
            ListCTHD = new ArrayList<CTHoaDon>();
            ListCTHD = Q.ReadCTHD();
        }
    }
    
    public void AddCTHD(String MaHD, String MaSP, String MaKM, int SoLuong, int Tien)
    {
        CTHoaDon cthd = new  CTHoaDon();
        cthd.setMaP(MaHD);
        cthd.setMaSP(MaSP);
        cthd.setMaKM(MaKM);
        cthd.setSL(SoLuong);
        cthd.setTTien(Tien);
        Q.AddCTHD(cthd);
        ListCTHD=null;
        ReadCTHD();
    }
    
    public void Del1SPTrongHD(String MaHD, String MaSP)
    {
        Q.DelCTHD1SP(MaHD, MaSP);
        ListCTHD=null;
        ReadCTHD();
    }
    
    // Bán Hàng
    public int TinhTien(String makm, int sl ,int tien)
    {
        int ThanhTien=tien*sl;
        if(makm.equals("false sai")==false)
        {
            for(TTKhuyenMai km : ListKM)
            {
                if(makm.equals(km.getMaKM()))
                {
                    ThanhTien=ThanhTien-((ThanhTien*km.getGiamGia())/100);
                }
            }
        }
        return ThanhTien;
    }
    
    public Vector BanHang(String masp, int sl, int tien)
    {
        Vector row = new Vector();
        row.add(masp);
        RunSP_KM lkm = new RunSP_KM();
        String makm = lkm.TruycapKM(masp, sl);
        if(makm.equals("false sai")==false) row.add(makm);
        else row.add("null");
        row.add(sl);
        row.add(TinhTien(makm, sl, tien));
        return row;
    }
    
    public void TruSP(String MaSP, int soluong)
    {
        Q.TruSP(MaSP, soluong);
    }
}
