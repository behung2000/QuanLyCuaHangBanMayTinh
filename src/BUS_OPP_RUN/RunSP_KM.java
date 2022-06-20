/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

import BUS_OPP_Class.SP_KM;
import BUS_OPP_Class.TTKhuyenMai;
import BUS_OPP_Class.TTSanPham;
import DAO.QueryDB_SP_KM;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class RunSP_KM extends ArrayListALL
{
    QueryDB_SP_KM Q = new QueryDB_SP_KM();
    
    public RunSP_KM()
    {
        ReadLKM();
    }
    
    //Tìm kiếm mã khuyến mãi
    public ArrayList<String> TTMaKM(String ma)
    {
        ReadLKM();
        ArrayList<String> ListStr= new ArrayList<String>();
        for(SP_KM spkm : ListLKM)
        {
            if(ma.equals(spkm.getMaSP())) ListStr.add(spkm.getMaKM());
        }
        return ListStr;
    }
    
    // Kiểm tra
    public boolean CheckMaSP(String masp)
    {
        for(TTSanPham sp : ListSP) if(masp.equals(sp.getMaSP())) return false;
        return true;
    }
    
    public boolean CheckMaKM(String makm)
    {
        for(TTKhuyenMai km : ListKM) if(makm.equals(km.getMaKM())) return false;
        return true;
    }
    
    public boolean CheckLKM(String masp, String makm)
    {
        boolean i=CheckMaSP(masp),j=CheckMaKM(makm);
        if(i==true || j==true) return false;
        return true;
    }
    
    //Đọc Thêm sửa xóa liên kết San Pham - Khuyen Mai
    public void ReadLKM()
    {
        if(ListLKM==null)
        {
            ListLKM = new ArrayList<SP_KM>();
            ListLKM = Q.ReadLKM();
        }
    }
    
    public void AddLKM(String Masp, String Makm)
    {
        if(CheckLKM(Masp, Makm))
        {
            SP_KM lspkm = new SP_KM();
            lspkm.setMaSP(Masp);
            lspkm.setMaKM(Makm);
            Q.AddLKM(lspkm);
            ListLKM=null;
            ReadLKM();
        }
        else JOptionPane.showInternalMessageDialog(null,"không thấy đối tượng sản phẩm or khuyến mãi !");
    }
    
    public void DelLKM(String MaSP)
    {
        if(CheckMaSP(MaSP))
        {
            Q.DelLKMTheoMaSP(MaSP);
            ListLKM=null;
            ReadLKM();
        }
        else JOptionPane.showInternalMessageDialog(null,"không thấy đối tượng sản phẩm !");
    }
    
    public void DelALLLKM()
    {
        Q.DelALLLKM();
        ListLKM=null;
        ReadLKM();
    }
    
    // Tìm khuyến mãi thảo điều kiện
    public String TruycapKM(String masp, int sl)
    {
        Date today = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(today);
        for(SP_KM lkm : ListLKM)
        {
            if(masp.equals(lkm.getMaSP()))
            {
                for(TTKhuyenMai km: ListKM)
                {
                    if(lkm.getMaKM().equals(km.getMaKM()) && km.getSL()<=sl && date.compareTo(km.getNgayBD())>=0 && date.compareTo(km.getNgayKT())<=0) return km.getMaKM();
                }
            }
        }
        return "false sai";
    }
}
