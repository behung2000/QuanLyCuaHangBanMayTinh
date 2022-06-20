/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

import BUS_OPP_Class.TTSanPham;
import DAO.QueryDB_SanPham;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaiv
 */
public class RunSanPham extends ArrayListALL
{
    QueryDB_SanPham Q = new QueryDB_SanPham();
    
    public RunSanPham()
    {
        ReadTTSP();
    }
    
    // Kiểm tra mã sản phẩm
    public boolean CheckMaSP(String ma)
    {
        for(TTSanPham sp : ListSP)
        {
            if(ma.equals(sp.getMaSP())) return false;
        }
        return true;
    }
    
    // Tạo mã san pham
    public String CreateMaSP(String MaLoai, String MaSX)
    {
        String ma=MaLoai;
        ma=ma+MaSX.charAt(0);
        int dem=0;
        while(CheckMaSP(ma)==false)
        {
            if(dem<10) ma=ma+"00"+dem;
            else
            {
                if(dem<100) ma=ma+"0"+dem;
                else
                {
                    if(dem<1000) ma=ma+dem;
                }
            }
            dem++;
        }
        return ma;
    }
    
    // Tạo Liên kết sp với km
    public DefaultTableModel ReadLKSPvoiKM()
    {
        if(ListSP==null)
        {
            ListSP = new  ArrayList <TTSanPham>();
            ListSP = Q.ReadTTSP();
        }
        return FT.khungtableLKSPvoiKM(ListSP);
    }
    
    // Đọc thêm sửa xóa
    public DefaultTableModel ReadTTSP()
    {
        if(ListSP==null)
        {
            ListSP = new  ArrayList <TTSanPham>();
            ListSP = Q.ReadTTSP();
        }
        return FT.khungtableSP(ListSP);
    }
    
    public DefaultTableModel AddTTSP(String Ten, String MaSX, String cungcap, String loaisp, int DonGia, String vitriBH, int thoigianBH, String TT)
    {
        RunCungCap cc = new RunCungCap();
        String macc = cc.MaNcc(cungcap);
        RunLoaiSP lsp = new RunLoaiSP();
        String malsp = lsp.MaLoaiSP(loaisp);
        RunBaoHanh bh = new RunBaoHanh();
        int i=-1;
        if(vitriBH.equals("Tại Chỗ")) i=1;
        else i=0;
        String mabh =""+i+thoigianBH;
        RunSanXuat sx = new RunSanXuat();
        if(macc==null || malsp==null || bh.CheckMaBH(mabh)==true || sx.KTMaSX(MaSX,0)==true) JOptionPane.showInternalMessageDialog(null,"không tìm thấy mã cung cấp or mã loại sản phẩm or mã bảo hành or mã nhà sản xuất!");
        else
        {
            String MaSP=CreateMaSP(malsp, MaSX);
            TTSanPham sp = new TTSanPham();
            sp.setMaSP(MaSP);
            sp.setTenSP(Ten);
            sp.setMaLoai(malsp);
            sp.setMaNSX(MaSX);
            sp.setMaCC(macc);
            sp.setSL(0);
            sp.setGN(0);
            sp.setDG(DonGia);
            sp.setMaBH(mabh);
            sp.setTT(TT);
            Q.AddTTSP(sp);
            ListSP=null;
        }
        return ReadTTSP();
    }
    
    public DefaultTableModel FixTTSP(String Ma, String Ten, String MaSX, String cungcap, String loaisp, int DonGia, String vitriBH, int thoigianBH, String TT)
    {
        RunCungCap cc = new RunCungCap();
        String macc = cc.MaNcc(cungcap);
        RunLoaiSP lsp = new RunLoaiSP();
        String malsp = lsp.MaLoaiSP(loaisp);
        RunBaoHanh bh = new RunBaoHanh();
        int i=-1;
        if(vitriBH.equals("Tại Chỗ")) i=1;
        else i=0;
        String mabh =""+i+thoigianBH;
        RunSanXuat sx = new RunSanXuat();
        if(macc==null || malsp==null || bh.CheckMaBH(mabh)==true || sx.KTMaSX(MaSX,0)==true) JOptionPane.showInternalMessageDialog(null,"không tìm thấy mã cung cấp or mã loại sản phẩm or mã bảo hành or mã nhà sản xuất!");
        else
        {
            String MaSP=CreateMaSP(malsp, MaSX);
            TTSanPham sp = new TTSanPham();
            sp.setMaSP(MaSP);
            sp.setTenSP(Ten);
            sp.setMaLoai(malsp);
            sp.setMaNSX(MaSX);
            sp.setMaCC(macc);
            sp.setSL(0);
            sp.setGN(0);
            sp.setDG(DonGia);
            sp.setMaBH(mabh);
            sp.setTT(TT);
            Q.FixTTSP(Ma, sp);
            ListSP=null;
        }
        return ReadTTSP();
    }
    
    public DefaultTableModel DelTTSP(String Ma)
    {
        if(CheckMaSP(Ma)) JOptionPane.showInternalMessageDialog(null,"không tìm thấy đối tượng !");
        else
        {
            Q.DelTTSP(Ma);
            ListSP=null;
        }
        return ReadTTSP();
    }
    
    // Tìm kiếm
    public String TenSP(String MaSP)
    {
        for(TTSanPham sp : ListSP)
        {
            if(MaSP.equals(sp.getMaSP())) return sp.getTenSP();
        }
        return "null";
    }
    
    public TTSanPham xuatSP(String MaSP)
    {
        for(TTSanPham sp : ListSP)
        {
            if(MaSP.equals(sp.getMaSP())) return sp;
        }
        return null;
    }
}
