/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

import BUS_OPP_Class.NhaSX;
import DAO.QueryDB_SanXuat;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaiv
 */
public class RunSanXuat extends ArrayListALL
{
    public ArrayList <NhaSX> ListSX1;
    QueryDB_SanXuat Q = new QueryDB_SanXuat();
    
    public RunSanXuat()
    {
        ReadSX();
    }
    
    // Kiểm Tra
    
    public boolean KTMaSX(String MaSX, int d)
    {
        int dem = 0;
        for(NhaSX sx : ListSX)
        {
            if(MaSX.equals(sx.getMaNSX())) dem++;
            if(dem>d) return false;
        }
        return true;
    }
    
    public boolean KTNhaSX(String MaSX, int d)
    {
        boolean a1 = ci.KTMa(MaSX);
        boolean b1 = KTMaSX(MaSX,d);
        if(a1 == false || b1 == false)
        {
            if(a1==false) JOptionPane.showInternalMessageDialog(null,"Nhập sai MaSX !");
            if(b1==false) JOptionPane.showInternalMessageDialog(null,"Trùng MaSX !");
            return false;
        }
        return true;
    }
    
    // Đọc Thêm Sửa Xóa
    public DefaultTableModel ReadSX()
    {
        if(ListSX==null)
        {
            ListSX = new ArrayList<NhaSX>();
            ListSX = Q.ReadSX();
        }
        return FT.khungtableNhaSX(ListSX);
    }
    
    public DefaultTableModel AddNhaSX(String MaSX, String Ten, String DiaChi)
    {
        
        boolean a1 = KTNhaSX(MaSX,0);
        if(a1 == true)
        {
            NhaSX sx = new NhaSX();
            sx.setMaNSX(MaSX);
            sx.setTenNSX(Ten);
            sx.setDiaChi(DiaChi);
            Q.AddSX(sx);
            ListSX=null;
        }
        return ReadSX();
    }
    
    public DefaultTableModel FixNhaSX(String MaSX, String Ten, String DiaChi, String MaSX1)
    {
        if(KTMaSX(MaSX1,0)==false)
        {
            boolean a1;
            if(MaSX.equals(MaSX1)) a1 = KTNhaSX(MaSX,1);
            else a1 = KTNhaSX(MaSX,0);
            if(a1 == true)
            {
                NhaSX sx = new NhaSX();
                sx.setMaNSX(MaSX);
                sx.setTenNSX(Ten);
                sx.setDiaChi(DiaChi);
                Q.FixSX(MaSX1, sx);
                ListSX=null;
            }
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null,"không tìm thấy đối tượng cần để sửa!");
        }
        return ReadSX();
    }
    
    public DefaultTableModel DelNhaSX(String MaSX)
    {
        if(KTMaSX(MaSX,0)==false)
        {
            Q.DelSX(MaSX);
            ListSX=null;
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null,"không tồn tại đối tượng này !");
        }
        return ReadSX();
    }
    
    
    //Tìm Kiếm
    public DefaultTableModel TimKiemNhaSXTheoInt(String st, int i)
    {
        ListSX1 = new ArrayList <NhaSX>();
        for(NhaSX sx : ListSX)
        {
            if(i==0)
            {
                if(st.equals(sx.getMaNSX())) ListSX1.add(sx);
            }
            else
            {
                if(i==1)
                {
                    if(str.KT_Ten(sx.getTenNSX(),st)) ListSX1.add(sx);
                }
            }
        }
        return FT.khungtableNhaSX(ListSX1);
    }
    
     // Sắp Xếp
    public DefaultTableModel SapXepNhaCC(ArrayList<NhaSX> ListSapXep,int k)
    {
        switch(k)
        {
            case 0:
            {
                Collections.sort(ListSapXep, (NhaSX sx1, NhaSX sx2) -> (sx1.getMaNSX().compareTo(sx2.getMaNSX())));
                break;
            }
            case 1:
            {
                Collections.sort(ListSapXep, (NhaSX sx1, NhaSX sx2) -> (sx1.getTenNSX().compareTo(sx2.getTenNSX())));
                break;
            }
            default: break;
        }
        return FT.khungtableNhaSX(ListSapXep);
    }
    
     // ComboBox cho sản phẩm
    public DefaultComboBoxModel xuatMaNsxSanPham()
    {
        ReadSX();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (NhaSX sp : ListSX) 
        {
            model.addElement(sp.getMaNSX());
        }
        return model;
    }
}
