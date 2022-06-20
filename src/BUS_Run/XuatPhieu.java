/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_Run;

import BUS_OPP_Class.CTHoaDon;
import BUS_OPP_Class.CTPhieuNhap;
import BUS_OPP_Class.HoaDon;
import BUS_OPP_Class.KhachHang;
import BUS_OPP_Class.NhaCC;
import BUS_OPP_Class.NhanVien;
import BUS_OPP_Class.PhieuNhap;
import BUS_OPP_Class.TTSanPham;
import BUS_OPP_RUN.ArrayListALL;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author thaiv
 */
public class XuatPhieu 
{
    public  PdfPTable TieuDeGiua(String s, Font font)
    {
        PdfPTable t = new PdfPTable(1);
        t.setWidthPercentage(105);
        t.setSpacingAfter(11f);
        t.setSpacingBefore(11f);
        float[] cout = {2f};
        try 
        {
            t.setWidths(cout);
        } 
        catch (DocumentException ex) 
        {
            Logger.getLogger(XuatPhieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPCell cell = new PdfPCell(new Paragraph(s,font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorderColor(BaseColor.WHITE);
        t.addCell(cell);
        return t;
    }
    
    public  PdfPTable GachNgang(int n)
    {
        PdfPTable t = new PdfPTable(1);
        t.setWidthPercentage((PageSize.A7.getWidth()));
        String s="";
        for(int i= 0 ; i< n/6; i++)
        {
            s=s+"-";
        }
        s=s+"";
        PdfPCell cell = new PdfPCell(new Paragraph(s));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorderColor(BaseColor.WHITE);
        t.addCell(cell);
        return t;
    }
    
    public  PdfPTable GachNgang2(int n)
    {
        PdfPTable t = new PdfPTable(1);
        t.setWidthPercentage((PageSize.A7.getWidth()));
        String s="";
        for(int i= 0 ; i< n/6; i++)
        {
            s=s+"   ";
        }
        s=s+"";
        PdfPCell cell = new PdfPCell(new Paragraph(s));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorderColorTop(BaseColor.BLACK);
        t.addCell(cell);
        return t;
    }
    
    public  PdfPTable TieuDeTrai(String s, Font font)
    {
        PdfPTable t = new PdfPTable(1);
        t.setWidthPercentage(105);
        t.setSpacingAfter(11f);
        t.setSpacingBefore(11f);
        float[] cout = {2f};
        try 
        {
            t.setWidths(cout);
        } 
        catch (DocumentException ex) 
        {
            Logger.getLogger(XuatPhieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPCell cell = new PdfPCell(new Paragraph(s,font));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorderColor(BaseColor.WHITE);
        t.addCell(cell);
        return t;
    }
    
    public   PdfPTable TaoGiua3Str(String s1, String s2, String s3, Font font)
    {
        PdfPTable t = new PdfPTable(3);
        t.setWidthPercentage(105);
        t.setSpacingAfter(11f);
        t.setSpacingBefore(11f);
        float[] cout = {2f,2f,2f};
        try 
        {
            t.setWidths(cout);
        } 
        catch (DocumentException ex) 
        {
            Logger.getLogger(XuatPhieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPCell cell;
        cell = new PdfPCell(new Paragraph(s1,font));
        cell.setBorderColor(BaseColor.WHITE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        t.addCell(cell);
        cell = new PdfPCell(new Paragraph(s2,font));
        cell.setBorderColor(BaseColor.WHITE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        t.addCell(cell);
        cell = new PdfPCell(new Paragraph(s3,font));
        cell.setBorderColor(BaseColor.WHITE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        t.addCell(cell);
        return t;
    }
    
    public  PdfPTable TaoGiua2Str(String s1, String s2, Font font)
    {
        PdfPTable t = new PdfPTable(2);
        t.setWidthPercentage(105);
        t.setSpacingAfter(11f);
        t.setSpacingBefore(11f);
        float[] cout = {2f,2f};
        try 
        {
            t.setWidths(cout);
        } 
        catch (DocumentException ex) 
        {
            Logger.getLogger(XuatPhieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        PdfPCell cell;
        cell = new PdfPCell(new Paragraph(s1,font));
        cell.setBorderColor(BaseColor.WHITE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        t.addCell(cell);
        cell = new PdfPCell(new Paragraph(s2,font));
        cell.setBorderColor(BaseColor.WHITE);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        t.addCell(cell);
        return t;
    }
    public  void XuatHD(HoaDon hd, NhanVien nv, KhachHang kh)
    {
        Document document = new Document();
        String filename=hd.getMaP()+".pdf";
        try 
        {
            File fontFile = new File("VietFontsWeb1_ttf/vuArial.ttf");
            BaseFont bf;
            bf = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED); 
            Font font15 = new Font(bf,15);
            Font font12 = new Font(bf,12);
            PdfWriter wri = PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            int n = (int) wri.getPageSize().getHeight();
            document.add(GachNgang2(n));
            document.add(TieuDeGiua("Công Ty Bán Máy Tính Nhóm 6",font15));
            document.add(TieuDeGiua("Bán Hàng",font15));
            document.add(TieuDeGiua("Ngày: "+hd.getNgay(),font15));
            document.add(GachNgang(n));
            document.add(TieuDeTrai("Thông tin nhân viên giao dịch:",font15));
            document.add(TaoGiua2Str("Mã nhân viên",nv.getMaNV(),font12));
            document.add(TaoGiua2Str("Tên nhân viên",nv.getTenNV(),font12));
            document.add(TieuDeTrai("Thông tin khách hàng giao dịch:",font15));
            document.add(TaoGiua2Str("Mã khách hàng",kh.getCMND(),font12));
            document.add(TaoGiua2Str("Tên khách hàng",kh.getTenKH(),font12));
            document.add(TaoGiua2Str("Số ĐT khách hàng",kh.getSDT(),font12));
            document.add(TaoGiua2Str("Địa chỉ khách hàng",kh.getDiaChi(),font12));
            document.add(GachNgang(n));
            document.add(TieuDeTrai("Chi tiết hóa đơn:",font15));
            document.add(TaoGiua2Str("Mã sản phẩm","Tên sản phẩm",font15));
            document.add(TaoGiua3Str("Mã khuyến mãi","Số lượng","Tổng tiền",font15));
            document.add(GachNgang2(n));
            for(CTHoaDon cthd : ArrayListALL.ListCTHD)
            {
                if (hd.getMaP().equals(cthd.MaP)) 
                {
                    for (TTSanPham sp : ArrayListALL.ListSP) 
                    {
                        if (cthd.getMaSP().equals(sp.getMaSP())) 
                        {
                            document.add(TaoGiua2Str(sp.getMaSP(),sp.getTenSP(),font12));
                        }
                    }
                    document.add(TaoGiua3Str(cthd.getMaKM(),""+cthd.getSL(),""+cthd.getTTien(),font12));
                }
            }
            document.add(GachNgang(n));
            document.add(TaoGiua2Str("Tổng tiền của hóa đơn:",""+hd.getTTien(),font12));
            document.add(GachNgang2(n));
            document.close();
            wri.close();
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(XuatPhieu.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (DocumentException ex) 
        {
            Logger.getLogger(XuatPhieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
                Logger.getLogger(XuatPhieu.class.getName()).log(Level.SEVERE, null, ex);
            }
        if (Desktop.isDesktopSupported()) 
        {
            try 
            {
                File myFile = new File(filename);
                Desktop.getDesktop().open(myFile);
            } 
            catch (IOException ex) 
            {
                // no application registered for PDFs 
            }
        }
    }
    
    public void XuatPN(PhieuNhap pn, NhanVien nv, NhaCC cc)
    {
        Document document = new Document();
        String filename=pn.getMaP()+".pdf";
        try 
        {
            File fontFile = new File("VietFontsWeb1_ttf/vuArial.ttf");
            BaseFont bf = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font15 = new Font(bf,15);
            Font font12 = new Font(bf,12);
            PdfWriter wri = PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();
            int n = (int) wri.getPageSize().getHeight();
            document.add(GachNgang2(n));
            document.add(TieuDeGiua("Công Ty Bán Máy Tính Nhóm 6",font15));
            document.add(TieuDeGiua("Nhập Hàng",font15));
            document.add(TieuDeGiua("Ngày: "+pn.getNgay(),font15));
            document.add(GachNgang(n));
            document.add(TieuDeTrai("Thông tin nhân viên giao dịch:",font15));
            document.add(TaoGiua2Str("Mã nhân viên",nv.getMaNV(),font12));
            document.add(TaoGiua2Str("Tên nhân viên",nv.getTenNV(),font12));
            document.add(TieuDeTrai("Thông tin nhà cung cấp giao dịch:",font15));
            document.add(TaoGiua2Str("Mã nhà cung cấp",cc.getMaCC(),font12));
            document.add(TaoGiua2Str("Tên nhà cung cấp",cc.getMaCC(),font12));
            document.add(TaoGiua2Str("Số ĐT nhà cung cấp",cc.getSDT(),font12));
            document.add(TaoGiua2Str("Địa chỉ nhà cung cấp",cc.getDiaChi(),font12));
            document.add(GachNgang(n));
            document.add(TieuDeTrai("Chi tiết phiếu nhập:",font15));
            document.add(TaoGiua2Str("Mã sản phẩm","Tên sản phẩm",font15));
            document.add(TaoGiua2Str("Số lượng","Tổng tiền",font15));
            document.add(GachNgang2(n));
            for(CTPhieuNhap ctpn : ArrayListALL.ListCTPN)
            {
                if (pn.getMaP().equals(ctpn.MaP)) 
                {
                    for (TTSanPham sp : ArrayListALL.ListSP) 
                    {
                        if (ctpn.getMaSP().equals(sp.getMaSP())) 
                        {
                            document.add(TaoGiua2Str(sp.getMaSP(),sp.getTenSP(),font12));
                        }
                    }
                    document.add(TaoGiua2Str(""+ctpn.getSL(),""+ctpn.getTTien(),font12));
                }
            }
            document.add(GachNgang(n));
            document.add(TaoGiua2Str("Tổng tiền của hóa đơn:",""+pn.getTTien(),font12));
            document.add(GachNgang2(n));
            document.close();
            wri.close();
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(XuatPhieu.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (DocumentException ex) 
        {
            Logger.getLogger(XuatPhieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(XuatPhieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (Desktop.isDesktopSupported()) 
        {
            try 
            {
                File myFile = new File(filename);
                Desktop.getDesktop().open(myFile);
            } 
            catch (IOException ex) 
            {
                // no application registered for PDFs 
            }
        }
    }
}
