/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import BUS_OPP_Class.BaoHanh;
import BUS_OPP_Class.CTHoaDon;
import BUS_OPP_Class.HoaDon;
import BUS_OPP_Class.KhachHang;
import BUS_OPP_Class.LoaiSP;
import BUS_OPP_Class.NhaCC;
import BUS_OPP_Class.NhaSX;
import BUS_OPP_Class.NhanVien;
import BUS_OPP_Class.PhieuNhap;
import BUS_OPP_Class.TTKhuyenMai;
import BUS_OPP_Class.TTSanPham;
import BUS_OPP_RUN.RunBaoHanh;
import BUS_OPP_RUN.RunCungCap;
import BUS_OPP_RUN.RunLoaiSP;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaiv
 */
public class FramesTable 
{
    public DefaultTableModel modeltable=null;
    public Vector header=null;
    
    public DefaultTableModel khungtableKH(ArrayList <KhachHang> List)
    {
        header = new Vector();
        header.add("CMND");
        header.add("Tên");
        header.add("SDT");
        header.add("Địa Chỉ");
        modeltable = new DefaultTableModel(header,0);
        for(KhachHang kh : List)
        {
            Vector row = new Vector();
            row.add(kh.getCMND());
            row.add(kh.getTenKH());
            row.add(kh.getSDT());
            row.add(kh.getDiaChi());
            modeltable.addRow(row);
        }
        return modeltable;
    }
    
    public DefaultTableModel khungtableNV(ArrayList <NhanVien> List)
    {
        header = new Vector();
        header.add("MaNV");
        header.add("TenNV");
        header.add("CMND");
        header.add("Password");
        header.add("Chức vụ");
        header.add("Lương");
        modeltable = new DefaultTableModel(header,0);
        for(NhanVien nv : List)
        {
            Vector row = new Vector();
            row.add(nv.getMaNV());
            row.add(nv.getTenNV());
            row.add(nv.getCMND());
            row.add(nv.getPassword());
            row.add(nv.getChucvuTT());
            row.add(nv.getluong());
            modeltable.addRow(row);
        }
        return modeltable;
    }
    
    public DefaultTableModel khungtableNhaCC(ArrayList <NhaCC> List)
    {
        header = new Vector();
        header.add("MaCC");
        header.add("Tên nhà cung cấp");
        header.add("Địa chỉ");
        header.add("Số điện thoại");
        modeltable = new DefaultTableModel(header,0);
        for(NhaCC cc : List)
        {
            Vector row = new Vector();
            row.add(cc.getMaCC());
            row.add(cc.getTenNCC());
            row.add(cc.getDiaChi());
            row.add(cc.getSDT());
            modeltable.addRow(row);
        }
        return modeltable;
    }
    
    public DefaultTableModel khungtableNhaSX(ArrayList <NhaSX> List)
    {
        header = new Vector();
        header.add("MaNSX");
        header.add("Tên nhà sản xuất (Hãng)");
        header.add("Địa chỉ");
        modeltable = new DefaultTableModel(header,0);
        for(NhaSX sx : List)
        {
            Vector row = new Vector();
            row.add(sx.getMaNSX());
            row.add(sx.getTenNSX());
            row.add(sx.getDiaChi());
            modeltable.addRow(row);
        }
        return modeltable;
    }
    
    public DefaultTableModel khungtableLSP(ArrayList <LoaiSP> List)
    {
        header = new Vector();
        header.add("Mã Loại");
        header.add("Tên Loại");
        modeltable = new DefaultTableModel(header,0);
        for(LoaiSP lsp : List)
        {
            Vector row = new Vector();
            row.add(lsp.getMaLoai());
            row.add(lsp.getTenLoai());
            modeltable.addRow(row);
        }
        return modeltable;
    }
    
    public DefaultTableModel khungThongKeTongQuat(Vector n)
    {
        Vector column1 = new Vector();
        column1.add("Số lượng nhân viên");
        column1.add("Số lượng khách hàng");
        column1.add("Số lượng sản phẩm");
        column1.add("Số lượng nhà sản xuất");
        column1.add("Số lượng nhà cung cấp");
        modeltable = new DefaultTableModel(0,0);
        modeltable.addColumn("Thống kê", column1);
        modeltable.addColumn("Số lượng",n);
        return modeltable;
    }
    
    public DefaultTableModel khungtableBH(ArrayList <BaoHanh> List)
    {
        header = new Vector();
        header.add("Mã Bảo hành");
        header.add("Vị trí (nơi) bảo hành");
        header.add("Thời gian bào hành (Tháng)");
        modeltable = new DefaultTableModel(header,0);
        for(BaoHanh bh : List)
        {
            Vector row = new Vector();
            row.add(bh.getMaBH());
            row.add(bh.getVitriTT());
            row.add(bh.getTG());
            modeltable.addRow(row);
        }
        return modeltable;
    }
    
    public DefaultTableModel khungtableTTKM(ArrayList <TTKhuyenMai> List)
    {
        header = new Vector();
        header.add("Mã khuyến mãi");
        header.add("Số lượng cần mua -> khuyến mãi");
        header.add("Phần trăm giảm giá (%)");
        header.add("Ngày bắt đầu");
        header.add("Ngày kết thúc");
        modeltable = new DefaultTableModel(header,0);
        for(TTKhuyenMai km : List)
        {
            Vector row = new Vector();
            row.add(km.getMaKM());
            row.add(km.getSL());
            row.add(km.getGiamGia());
            row.add(km.getNgayBD());
            row.add(km.getNgayKT());
            modeltable.addRow(row);
        }
        return modeltable;
    }
    
    public DefaultTableModel khungtableLKSPvoiKM(ArrayList <TTSanPham> List)
    {
        header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        modeltable = new DefaultTableModel(header,0);
        for(TTSanPham sp : List)
        {
            Vector row = new Vector();
            row.add(sp.getMaSP());
            row.add(sp.getTenSP());
            modeltable.addRow(row);
        }
        return modeltable;
    }
    
    public DefaultTableModel khungtableSP(ArrayList<TTSanPham> List)
    {
        header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        header.add("Loại sản Phẩm");
        header.add("Nhà sản xuất");
        header.add("Nhà cung cấp");
        header.add("nơi bảo hành");
        header.add("Thời Gian Bảo hành");
        header.add("Số lượng");
        header.add("Đơn giá");
        header.add("Giá nhập");
        header.add("Thông tin");
        modeltable = new DefaultTableModel(header,0);
        RunLoaiSP lsp = new RunLoaiSP();
        RunCungCap cc= new RunCungCap();
        RunBaoHanh bh = new RunBaoHanh();
        for(TTSanPham sp : List)
        {
            Vector row = new Vector();
            row.add(sp.getMaSP());
            row.add(sp.getTenSP());
            row.add(lsp.TenLoaiSP(sp.getMaLoai()));
            row.add(sp.getMaNSX());
            row.add(cc.TenNcc(sp.getMaCC()));
            row.add(bh.NoiBH(sp.getMaBH()));
            row.add(bh.ThoiGianBH(sp.getMaBH()));
            row.add(sp.getSL());
            row.add(sp.getDG());
            row.add(sp.getGN());
            row.add(sp.getTT());
            modeltable.addRow(row);
        }
        return modeltable;
    }
    
    public DefaultTableModel khungtableCTTTSP(ResultSet rs)
    {
        header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        header.add("Loại sản Phẩm");
        header.add("Thông tin");
        header.add("Số lượng");
        header.add("Đơn giá");
        header.add("Nhà sản xuất");
        header.add("nơi bảo hành");
        header.add("Thời Gian Bảo hành");
        modeltable = new DefaultTableModel(header,0);
        try 
        {
            while(rs.next())
            {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                row.add(rs.getString(7));
                int t=rs.getInt(8);
                String s="";
                if(t==1) s="Tại Chỗ";
                else s ="Gửi về nhà cung cấp";
                row.add(s);
                row.add(rs.getString(9));
                modeltable.addRow(row);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "truy cập thất bại ! ");
        }
        return modeltable;
    }
    
    public DefaultTableModel khungtableCTHDonBanHang()
    {
        header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Mã khuyến mãi");
        header.add("Số lượng");
        header.add("Thành tiền");
        modeltable = new DefaultTableModel(header,0);
        return modeltable;
    }
    
    public DefaultTableModel khungtableCTPhieuNhap()
    {
        header = new Vector();
        header.add("Mã sản phẩm");
        header.add("Số lượng");
        header.add("Thành tiền");
        modeltable = new DefaultTableModel(header,0);
        return modeltable;
    }
    
    public DefaultTableModel khungtableHoaDon(ArrayList<HoaDon> List)
    {
        header = new Vector();
        header.add("Mã hóa đơn");
        header.add("Mã Nhân Viên");
        header.add("Mã Khách Hàng");
        header.add("Ngày giao dịch");
        header.add("Tổng tiền");
        modeltable = new DefaultTableModel(header,0);
        for(HoaDon hd: List)
        {
            Vector row = new Vector();
            row.add(hd.getMaP());
            row.add(hd.getMaNV());
            row.add(hd.getMaKH());
            row.add(hd.getNgay());
            row.add(hd.getTTien());
            modeltable.addRow(row);
        }
        return modeltable;
    }
    
    public DefaultTableModel khungtablePhieuNhap(ArrayList<PhieuNhap> List)
    {
        header = new Vector();
        header.add("Mã hóa đơn");
        header.add("Mã Nhân Viên");
        header.add("Mã Cung cấp");
        header.add("Ngày giao dịch");
        header.add("Tổng tiền");
        modeltable = new DefaultTableModel(header,0);
        for(PhieuNhap pn: List)
        {
            Vector row = new Vector();
            row.add(pn.getMaP());
            row.add(pn.getMaNV());
            row.add(pn.getMaCC());
            row.add(pn.getNgay());
            row.add(pn.getTTien());
            modeltable.addRow(row);
        }
        return modeltable;
    }
}
