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
            document.add(TieuDeGiua("C??ng Ty B??n M??y T??nh Nh??m 6",font15));
            document.add(TieuDeGiua("B??n H??ng",font15));
            document.add(TieuDeGiua("Ng??y: "+hd.getNgay(),font15));
            document.add(GachNgang(n));
            document.add(TieuDeTrai("Th??ng tin nh??n vi??n giao d???ch:",font15));
            document.add(TaoGiua2Str("M?? nh??n vi??n",nv.getMaNV(),font12));
            document.add(TaoGiua2Str("T??n nh??n vi??n",nv.getTenNV(),font12));
            document.add(TieuDeTrai("Th??ng tin kh??ch h??ng giao d???ch:",font15));
            document.add(TaoGiua2Str("M?? kh??ch h??ng",kh.getCMND(),font12));
            document.add(TaoGiua2Str("T??n kh??ch h??ng",kh.getTenKH(),font12));
            document.add(TaoGiua2Str("S??? ??T kh??ch h??ng",kh.getSDT(),font12));
            document.add(TaoGiua2Str("?????a ch??? kh??ch h??ng",kh.getDiaChi(),font12));
            document.add(GachNgang(n));
            document.add(TieuDeTrai("Chi ti???t h??a ????n:",font15));
            document.add(TaoGiua2Str("M?? s???n ph???m","T??n s???n ph???m",font15));
            document.add(TaoGiua3Str("M?? khuy???n m??i","S??? l?????ng","T???ng ti???n",font15));
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
            document.add(TaoGiua2Str("T???ng ti???n c???a h??a ????n:",""+hd.getTTien(),font12));
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
            document.add(TieuDeGiua("C??ng Ty B??n M??y T??nh Nh??m 6",font15));
            document.add(TieuDeGiua("Nh???p H??ng",font15));
            document.add(TieuDeGiua("Ng??y: "+pn.getNgay(),font15));
            document.add(GachNgang(n));
            document.add(TieuDeTrai("Th??ng tin nh??n vi??n giao d???ch:",font15));
            document.add(TaoGiua2Str("M?? nh??n vi??n",nv.getMaNV(),font12));
            document.add(TaoGiua2Str("T??n nh??n vi??n",nv.getTenNV(),font12));
            document.add(TieuDeTrai("Th??ng tin nh?? cung c???p giao d???ch:",font15));
            document.add(TaoGiua2Str("M?? nh?? cung c???p",cc.getMaCC(),font12));
            document.add(TaoGiua2Str("T??n nh?? cung c???p",cc.getMaCC(),font12));
            document.add(TaoGiua2Str("S??? ??T nh?? cung c???p",cc.getSDT(),font12));
            document.add(TaoGiua2Str("?????a ch??? nh?? cung c???p",cc.getDiaChi(),font12));
            document.add(GachNgang(n));
            document.add(TieuDeTrai("Chi ti???t phi???u nh???p:",font15));
            document.add(TaoGiua2Str("M?? s???n ph???m","T??n s???n ph???m",font15));
            document.add(TaoGiua2Str("S??? l?????ng","T???ng ti???n",font15));
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
            document.add(TaoGiua2Str("T???ng ti???n c???a h??a ????n:",""+pn.getTTien(),font12));
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
