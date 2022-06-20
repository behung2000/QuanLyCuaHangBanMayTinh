/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

import BUS_OPP_Class.LoaiSP;
import DAO.QueryDB_LoaiSP;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaiv
 */
public class RunLoaiSP extends ArrayListALL
{
    public ArrayList<LoaiSP> ListLSP1;
    QueryDB_LoaiSP Q = new QueryDB_LoaiSP();
    
    public RunLoaiSP()
    {
        ReadLSP();
    }
    
    // Kiểm Tra
    
    public boolean KTMaLoaiSP(String MaLSP)
    {
        for(LoaiSP lsp : ListLSP)
        {
            if(MaLSP.equals(lsp.getMaLoai())) return false;
        }
        return true;
    }
    
    //Tạo Mã Loại
    public String createMaLoai(String Ten)
    {
        String t = Ten.trim();
        if(Ten.equals(t)==false) JOptionPane.showInternalMessageDialog(null,"Có khoảng trắng dư thừa ở đầu or cuối tên");
        t= str.myTrim(t);
        String ma="false sai";
        if(Ten.equals(t)==false) JOptionPane.showInternalMessageDialog(null,"Có khoảng trắng dư thừa ở trong tên");
        else
        {
            String kt = str.DelAllmyTrim(t);
            ma="";
            if(Ten.equals(kt))
            {
                for(int i=0;i<Ten.length();)
                {
                    ma=ma+Ten.charAt(i);
                    if(KTMaLoaiSP(ma)) i=Ten.length();
                    else i++;
                }
            }
            else
            {
                int dem=0;
                for(int i=0;i<Ten.length();i++)
                {
                    if(dem==0)
                    {
                        ma=ma+Ten.charAt(i);
                        dem++;
                    }
                    if(Ten.charAt(i)==' ') dem=0;
                }
            }
        }
        int dem=0;
        while(KTMaLoaiSP(ma)==false)
        {
            ma=ma+dem;
            dem++;
        }
        return ma;
    }
    
    // Đọc Thêm Sửa Xóa
    public DefaultTableModel ReadLSP()
    {
        if(ListLSP==null) 
        {
            ListLSP = new ArrayList<LoaiSP>();
            ListLSP = Q.ReadLSP();
        }
        return FT.khungtableLSP(ListLSP);

    }
    
    public DefaultTableModel AddLoaiSP(String Ten)
    {
        String Ma=createMaLoai(Ten);
        if(Ma.equals("false sai")==false)
        {
            LoaiSP lsp = new LoaiSP();
            lsp.setMaLoai(Ma);
            lsp.setTenLoai(Ten);
            Q.AddLSP(lsp);
            ListLSP=null;
        }
        return ReadLSP();
    }
    
    public DefaultTableModel FixLoaiSP(String Ten, String MaLSP)
    {
        if(KTMaLoaiSP(MaLSP)==false)
        {
            LoaiSP lsp = new LoaiSP();
            lsp.setMaLoai(MaLSP);
            lsp.setTenLoai(Ten);
            Q.FixLSP(MaLSP, lsp);
            ListLSP = null;
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null,"không tìm thấy đối tượng cần để sửa!");
        }
        return ReadLSP();
    }
    
    public DefaultTableModel DelLoaiSP(String MaLSP)
    {
        if(KTMaLoaiSP(MaLSP)==false)
        {
            Q.DelLSP(MaLSP);
            ListLSP=null;
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null,"không tồn tại đối tượng này !");
        }
        return ReadLSP();
    }
    
    //Tìm Kiếm
    public String TenLoaiSP(String ma)
    {
        for(LoaiSP lsp : ListLSP)
        {
            if(ma.equals(lsp.getMaLoai())) return lsp.getTenLoai();
        }
        return null;
    }
    
    public String MaLoaiSP(String ten)
    {
        for(LoaiSP lsp : ListLSP)
        {
            if(ten.equals(lsp.getTenLoai())) return lsp.getMaLoai();
        }
        return null;
    }
    
    public DefaultTableModel TimKiemLoaiSPTheoInt(String st, int i)
    {
        ListLSP1 = new ArrayList <LoaiSP>();
        for(LoaiSP lsp : ListLSP)
        {
            if(i==0)
            {
                if(st.equals(lsp.getMaLoai())) ListLSP1.add(lsp);
            }
            else
            {
                if(i==1)
                {
                    if(str.KT_Ten(lsp.getTenLoai(),st)) ListLSP1.add(lsp);
                }
            }
        }
        return FT.khungtableLSP(ListLSP1);
    }
    
     // Sắp Xếp
    public DefaultTableModel SapXepLoaiSP(ArrayList<LoaiSP> ListSapXep,int k)
    {
        switch(k)
        {
            case 0:
            {
                Collections.sort(ListSapXep, (LoaiSP lsp1, LoaiSP lsp2) -> (lsp1.getMaLoai().compareTo(lsp2.getMaLoai())));
                break;
            }
            case 1:
            {
                Collections.sort(ListSapXep, (LoaiSP lsp1, LoaiSP lsp2) -> (lsp1.getTenLoai().compareTo(lsp2.getTenLoai())));
                break;
            }
            default: break;
        }
        return FT.khungtableLSP(ListSapXep);
    }
    
    // ComboBox cho sản phẩm
    public DefaultComboBoxModel xuatTenLoaiSanPham()
    {
        ReadLSP();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (LoaiSP sp : ListLSP) 
        {
            model.addElement(sp.getTenLoai());
        }
        return model;
    }

}
