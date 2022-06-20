/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

import BUS_OPP_Class.BaoHanh;
import DAO.QueryDB_BaoHanh;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaiv
 */
public class RunBaoHanh extends ArrayListALL
{
    ArrayList<BaoHanh> ListBH1;
    QueryDB_BaoHanh Q = new QueryDB_BaoHanh();
    
    public RunBaoHanh()
    {
        ReadBH();
    }
    
    // Kiểm tra mã
    public boolean CheckMaBH(String Ma)
    {
        for(BaoHanh bh : ListBH)
        {
            if(Ma.equals(bh.getMaBH())) return false;
        }
        return true;
    }
    
    // Create mã bảo hành
    public String CreateMaBH(int a, int b)
    {
        String Ma=""+a+b;
        if(CheckMaBH(Ma)) return Ma;
        return "false";
    }
    
    // Đọc thêm sửa xóa
    public DefaultTableModel ReadBH()
    {
        if(ListBH==null)
        {
            System.out.println("1");
            ListBH = new ArrayList<BaoHanh>();
            ListBH = Q.ReadBH();
        }
        return FT.khungtableBH(ListBH);
    }
    
    public DefaultTableModel AddBH(int Vitri, int ThoiGian)
    {
        String Ma=CreateMaBH(Vitri,ThoiGian);
        if(Ma.equals("false")==false)
        {
            BaoHanh bh = new BaoHanh();
            bh.setMaBH(Ma);
            bh.setTG(ThoiGian);
            if(Vitri==0) bh.setVitri(true);
            else bh.setVitri(false);
            Q.AddBH(bh);
            ListBH=null;
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null,"Bảo Hành này đã có!");
        }
        return ReadBH();
    }
    
    public DefaultTableModel FixBH(String MaBH, int Vitri, int ThoiGian)
    {
        if(CheckMaBH(MaBH)==false)
        {
            String ma=CreateMaBH(Vitri, ThoiGian);
            if(ma.equals("false")==false)
            {
                BaoHanh bh = new BaoHanh();
                bh.setMaBH(ma);
                bh.setTG(ThoiGian);
                if (Vitri == 0) bh.setVitri(true);
                else bh.setVitri(false);
                Q.FixBH(MaBH, bh);
                ListBH = null;
            }
            else JOptionPane.showInternalMessageDialog(null,"Loại bảo hành này đã có !");
            
        }
        else JOptionPane.showInternalMessageDialog(null,"không tìm thấy đối tượng cần để sửa!");
        return ReadBH();
    }
    
    public DefaultTableModel DelBH(String MaBH)
    {
        if(CheckMaBH(MaBH)==false)
        {
            Q.DelBH(MaBH);
            ListBH=null;
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null,"không tồn tại đối tượng này !");
        }
        return ReadBH();
    }
    
    // Sắp xếp
    public DefaultTableModel SapXepBaoHanh(ArrayList<BaoHanh> ListSapXep,int k)
    {
        switch(k)
        {
            case 0:
            {
                Collections.sort(ListSapXep, (BaoHanh bh1, BaoHanh bh2) -> (bh1.getMaBH().compareTo(bh2.getMaBH())));
                break;
            }
            case 1:
            {
                Collections.sort(ListSapXep, (BaoHanh bh1, BaoHanh bh2) -> (bh1.getVitriTT().compareTo(bh2.getVitriTT())));
                break;
            }
            case 2:
            {
                Collections.sort(ListSapXep, (BaoHanh bh1, BaoHanh bh2) -> (bh1.getTG()-bh2.getTG()));
                break;
            }
            default: break;
        }
        return FT.khungtableBH(ListSapXep);
    }
    
    // ComboBox cho sản phẩm
    public DefaultComboBoxModel xuatThoiGianBHSanPham()
    {
        ReadBH();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(6);
        model.addElement(12);
        model.addElement(18);
        model.addElement(24);
        model.addElement(30);
        model.addElement(36);
        model.addElement(42);
        model.addElement(48);
        return model;
    }
    
    public DefaultComboBoxModel xuatVitriBHSanPham()
    {
        ReadBH();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Tại Chỗ");
        model.addElement("Gửi về nhà cung cấp");
        return model;
    }
    
    // Tìm kiếm
    public String NoiBH(String ma)
    {
        for(BaoHanh bh : ListBH)
        {
            if(ma.equals(bh.getMaBH())) return bh.getVitriTT();
        }
        return null;
    }
    
    public int ThoiGianBH(String ma)
    {
        for(BaoHanh bh : ListBH)
        {
            if(ma.equals(bh.getMaBH())) return bh.getTG();
        }
        return 0;
    }
}
