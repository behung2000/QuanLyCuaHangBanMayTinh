/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

import BUS_OPP_Class.KhachHang;
import BUS_Run.CheckInput;
import BUS_Run.HandlingString;
import DAO.QueryDB_KhachHang;
import Frame.FramesTable;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaiv
 */
public class RunKhachHang extends ArrayListALL
{
    public ArrayList <KhachHang> ListKH1;
    QueryDB_KhachHang Q = new QueryDB_KhachHang();
    
    public RunKhachHang()
    {
        ReadKH();
    }
    
    // Kiểm Tra
    public boolean KTcmnd(String cmnd, int d)
    {
        int dem = 0;
        for(KhachHang kh : ListKH)
        {
            if(cmnd.equals(kh.getCMND())) dem++;
            if(dem>d) return false;
        }
        return true;
    }
    
    public boolean KTKH(String cm, String SDT, int d)
    {
        boolean a1 = ci.KTCMND(cm);
        boolean b1 = KTcmnd(cm,d);
        boolean a2 = ci.KTSDT(SDT);
        if(a1 == false || b1 == false || a2 == false)
        {
            if(a1==false) JOptionPane.showInternalMessageDialog(null,"Nhập sai CMND !");
            if(a2==false) JOptionPane.showInternalMessageDialog(null,"Nhập sai SDT !");
            if(b1==false) JOptionPane.showInternalMessageDialog(null,"Trùng CMND !");
            return false;
        }
        return true;
    }
    
    // Đọc Thêm Sửa Xóa
    public DefaultTableModel ReadKH()
    {
        if(ListKH==null) 
        {
            ListKH = new ArrayList <KhachHang>();
            ListKH = Q.ReadKhachHang();
        }
        return FT.khungtableKH(ListKH);
    }
    
     
    
    public DefaultTableModel AddKH(String cm, String Ten, String SDT, String DiaChi)
    {
        
        boolean a1 = KTKH(cm,SDT,0);
        if(a1 == true)
        {
            KhachHang kh = new KhachHang();
            kh.setCMND(cm);
            kh.setTenKH(Ten);
            kh.setSDT(SDT);
            kh.setDiaChi(DiaChi);
            Q.AddKhachHang(kh);
            ListKH=null;
        }
        return ReadKH();
    }
    
    public DefaultTableModel FixKH(String cm, String Ten, String SDT, String DiaChi, String cm1)
    {
        if(KTcmnd(cm1,0)==false)
        {
            boolean a1;
            if(cm.equals(cm1)) a1 = KTKH(cm,SDT,1);
            else a1 = KTKH(cm,SDT,0);
            if(a1 == true)
            {
                KhachHang kh = new KhachHang();
                kh.setCMND(cm);
                kh.setTenKH(Ten);
                kh.setSDT(SDT);
                kh.setDiaChi(DiaChi);
                Q.FixKhachHang(cm1, kh);
                ListKH=null;
            }
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null,"không tìm thấy đối tượng cần để sửa!");
        }
        return ReadKH();
    }
    
    public DefaultTableModel DelKH(String cm)
    {
        if(KTcmnd(cm,0)==false)
        {
            Q.DelKhachHang(cm);
            ListKH=null;
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null,"không tồn tại Khách Hàng này !");
        }
        return ReadKH();
    }
    
    
    // Tìm Kiếm
    public KhachHang timkhachhang(String makh)
    {
        for(KhachHang kh : ListKH)
        {
            if(makh.equals(kh.getCMND())) return kh;
        }
        return null;
    }
    
    public DefaultTableModel TimKiemKHTheoInt(String st, int i)
    {
        ListKH1 = new ArrayList <KhachHang>();
        for(KhachHang kh : ListKH)
        {
            if(i==0)
            {
                if(st.equals(kh.getCMND())) ListKH1.add(kh);
            }
            else
            {
                if(i==1)
                {
                    if(str.KT_Ten(kh.getTenKH(),st)) ListKH1.add(kh);
                } 
                else
                {
                    if(i==2) 
                    {
                        if(st.equals(kh.getSDT())) ListKH1.add(kh);
                    }
                }
            }
        }
        return FT.khungtableKH(ListKH1);
    }
    
    public DefaultTableModel TK_And(String cmnd, String Ten, String SDT)
    {
        cmnd = str.myTrim(cmnd);
        Ten = str.myTrim(Ten);
        SDT = str.myTrim(SDT);
        ListKH1 = new ArrayList <KhachHang>();
        for(KhachHang kh : ListKH)
        {
            int d=0;
            
            boolean a1=false; // d1=1
            if(cmnd.equals("")==true || cmnd.equals(" ")==true) d=d+1;
            else a1 = (kh.getCMND()).equals(cmnd);
            
            boolean a2=false; // d2=3
            if(Ten.equals("")==true || Ten.equals(" ")==true) d=d+3;
            else a2 = str.KT_Ten(kh.getTenKH(),Ten);
            
            boolean a3=false; // d3=5
            if(SDT.equals("")==true || SDT.equals(" ")==true) d=d+5;
            else a3 = (kh.getSDT()).equals(SDT);
            if(d==0 && a1 == true && a2 == true && a3 == true) ListKH1.add(kh);
            else
            {
                if(d==1 && a2 == true && a3 == true) ListKH1.add(kh);
                else
                {
                    if(d==3 && a2 == true && a3 == true) ListKH1.add(kh);
                    else
                    {
                        if(d==4 && a3 == true) ListKH1.add(kh);
                        else
                        {
                            if(d==5 && a1 == true && a2 == true) ListKH1.add(kh);
                            else
                            {
                                if(d==6 && a2 == true) ListKH1.add(kh);
                                else
                                {
                                    if(d==8 && a1 == true) ListKH1.add(kh);
                                }
                            }
                        }
                    }
                }
            }
        }
        return FT.khungtableKH(ListKH1);
    }
    
    public DefaultTableModel TK_Or(String cmnd, String Ten, String SDT)
    {
        cmnd = str.myTrim(cmnd);
        Ten = str.myTrim(Ten);
        SDT = str.myTrim(SDT);
        ListKH1 = new ArrayList <KhachHang>();
        for(KhachHang kh : ListKH)
        {
            boolean a1 = (kh.getCMND()).equals(cmnd);
            boolean a2 = str.KT_Ten(kh.getTenKH(),Ten);
            boolean a3 = (kh.getSDT()).equals(SDT);
            if(a1 == true || a2 == true || a3 == true)
            {
                ListKH1.add(kh);
            }
        }
        return FT.khungtableKH(ListKH1);
    }
    
    // Sắp Xếp
    public DefaultTableModel SapXepKH(ArrayList<KhachHang> ListSapXep,int k)
    {
        switch(k)
        {
            case 0:
            {
                Collections.sort(ListSapXep, (KhachHang kh1, KhachHang kh2) -> (kh1.getCMND().compareTo(kh2.getCMND())));
                break;
            }
            case 1:
            {
                Collections.sort(ListSapXep, (KhachHang kh1, KhachHang kh2) -> (kh1.getTenKH().compareTo(kh2.getTenKH())));
                break;
            }
            case 2:
            {
                Collections.sort(ListSapXep, (KhachHang kh1, KhachHang kh2) -> (kh1.getDiaChi().compareTo(kh2.getDiaChi())));
                break;
            }
            default: break;
        }
        return FT.khungtableKH(ListSapXep);
    }
}
