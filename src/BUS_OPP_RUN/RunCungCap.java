/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

import BUS_OPP_Class.NhaCC;
import DAO.QueryDB_CungCap;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaiv
 */
public class RunCungCap extends ArrayListALL
{
    public ArrayList <NhaCC> ListCC1;
    QueryDB_CungCap Q = new QueryDB_CungCap();
    
    public RunCungCap()
    {
        ReadCC();
    }
    
    // Kiểm Tra
    
    public boolean KTMaCC(String MaCC, int d)
    {
        int dem = 0;
        for(NhaCC cc : ListCC)
        {
            if(MaCC.equals(cc.getMaCC())) dem++;
            if(dem>d) return false;
        }
        return true;
    }
    
    public boolean KTNhaCC(String MaCC, String SDT, int d)
    {
        boolean a1 = ci.KTMa(MaCC);
        boolean b1 = KTMaCC(MaCC,d);
        boolean a2 = ci.KTSDT(SDT);
        if(a1 == false || b1 == false || a2 == false)
        {
            if(a1==false) JOptionPane.showInternalMessageDialog(null,"Nhập sai MaCC !");
            if(a2==false) JOptionPane.showInternalMessageDialog(null,"Nhập sai SDT !");
            if(b1==false) JOptionPane.showInternalMessageDialog(null,"Trùng MaCC !");
            return false;
        }
        return true;
    }
    
    // Đọc Thêm Sửa Xóa
    public DefaultTableModel ReadCC()
    {
        if(ListCC==null)
        {
            ListCC = new ArrayList<NhaCC>();
            ListCC = Q.ReadCC();
        }
        return FT.khungtableNhaCC(ListCC);
    }
    
    
    public DefaultTableModel AddNhaCC(String MaCC, String Ten, String DiaChi, String SDT)
    {
        
        boolean a1 = KTNhaCC(MaCC,SDT,0);
        if(a1 == true)
        {
            NhaCC cc = new NhaCC();
            cc.setMaCC(MaCC);
            cc.setTenNCC(Ten);
            cc.setDiaChi(DiaChi);
            cc.setSDT(SDT);
            Q.AddCC(cc);
            ListCC=null;
        }
        return ReadCC();
    }
    
    public DefaultTableModel FixNhaCC(String MaCC, String Ten, String DiaChi, String SDT, String MaCC1)
    {
        if(KTMaCC(MaCC1,0)==false)
        {
            boolean a1;
            if(MaCC.equals(MaCC1)) a1 = KTNhaCC(MaCC,SDT,1);
            else a1 = KTNhaCC(MaCC,SDT,0);
            if(a1 == true)
            {
                NhaCC cc = new NhaCC();
                cc.setMaCC(MaCC);
                cc.setTenNCC(Ten);
                cc.setDiaChi(DiaChi);
                cc.setSDT(SDT);
                Q.FixCC(MaCC1, cc);
                ListCC=null;
            }
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null,"không tìm thấy đối tượng cần để sửa!");
        }
        return ReadCC();
    }
    
    public DefaultTableModel DelNhaCC(String MaCC)
    {
        if(KTMaCC(MaCC,0)==false)
        {
            Q.DelCC(MaCC);
            ListCC=null;
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null,"không tồn tại đối tượng này !");
        }
        return ReadCC();
    }
    
    //Tìm Kiếm
    public NhaCC XuatNhaCC(String ma)
    {
        for(NhaCC cc : ListCC)
        {
            if(ma.equals(cc.getMaCC())) return cc;
        }
        return null;
    }
    
    public String TenNcc(String ma)
    {
        for(NhaCC cc : ListCC)
        {
            if(ma.equals(cc.getMaCC())) return cc.getTenNCC();
        }
        return null;
    }
    
    public String MaNcc(String ten)
    {
        for(NhaCC cc : ListCC)
        {
            if(ten.equals(cc.getTenNCC())) return cc.getMaCC();
        }
        return null;
    }
    
    public DefaultTableModel TimKiemNhaCCTheoInt(String st, int i)
    {
        ListCC1 = new ArrayList <NhaCC>();
        for(NhaCC cc : ListCC)
        {
            if(i==0)
            {
                if(st.equals(cc.getMaCC())) ListCC1.add(cc);
            }
            else
            {
                if(i==1)
                {
                    if(str.KT_Ten(cc.getTenNCC(),st)) ListCC1.add(cc);
                }
            }
        }
        return FT.khungtableNhaCC(ListCC1);
    }
    
     // Sắp Xếp
    public DefaultTableModel SapXepNhaCC(ArrayList<NhaCC> ListSapXep,int k)
    {
        switch(k)
        {
            case 0:
            {
                Collections.sort(ListSapXep, (NhaCC cc1, NhaCC cc2) -> (cc1.getMaCC().compareTo(cc2.getMaCC())));
                break;
            }
            case 1:
            {
                Collections.sort(ListSapXep, (NhaCC cc1, NhaCC cc2) -> (cc1.getTenNCC().compareTo(cc2.getTenNCC())));
                break;
            }
            default: break;
        }
        return FT.khungtableNhaCC(ListSapXep);
    }
    
     // ComboBox cho sản phẩm
    public DefaultComboBoxModel xuatTenNccSanPham()
    {
        ReadCC();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (NhaCC sp : ListCC) 
        {
            model.addElement(sp.getTenNCC());
        }
        return model;
    }
    
    public DefaultComboBoxModel xuatMaNccNhapHang()
    {
        ReadCC();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (NhaCC sp : ListCC) 
        {
            model.addElement(sp.getMaCC());
        }
        return model;
    } 
}
