/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

import BUS_OPP_Class.NhanVien;
import DAO.QueryDB_NhanVien;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaiv
 */
public class RunNhanVien  extends ArrayListALL
{
    ArrayList<NhanVien> ListNV1;
    QueryDB_NhanVien Q = new QueryDB_NhanVien();
    
    public RunNhanVien()
    {
        ReadNV();
    }
    
    // Kiểm tra mã nhân viên
    public boolean CheckMaNV(String Ma , int i)
    {
        int dem=0;
        for(NhanVien nv: ListNV)
        {
            if(nv.getMaNV().equals(Ma)) dem++;
            if(dem==i) return false;
        }
        return true;
    }
    
    //Tạo Lương cơ bản cho nhân viên:
    public int CreateLuong(int cv)
    {
        int luong=0;
        if(cv==1) luong=10000000;
        else
        {
            if(cv==2) luong=2000000;
        }
        return luong;
    }
    
    //Kiểm tra cmnd của nhân viên
    public boolean KTCMNVcuaNV(String cm , int d)
    {
        int j=0;
        for(NhanVien nv : ListNV)
        {
            if(nv.getCMND().equals(cm)) j++;
            if(j==d) return false;
        }
        return true;
    }
    
    //Kiem tra dữ liệu vào
    public boolean KTThongTinNV(String CMND, String Pass, int d)
    {
        if(ci.KTCMND(CMND)==false) JOptionPane.showInternalMessageDialog(null,"CMND Không hợp lệ !");
        else
        {
            if(KTCMNVcuaNV(CMND,d)==false) JOptionPane.showInternalMessageDialog(null,"CMND tồn tại trong nhân viên !");
            else
            {
                String KTPass = str.DelAllmyTrim(Pass);
                if (KTPass.equals(Pass) == false) JOptionPane.showInternalMessageDialog(null, "Pass Không hợp lệ !");
                else 
                {
                    if (Pass.length() <= 0 || Pass.length() >= 100)  JOptionPane.showInternalMessageDialog(null, "Độ dài Pass Không hợp lệ !"); 
                    else 
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    // Đọc thêm sửa xóa
    public DefaultTableModel ReadNV()
    {
        if(ListNV == null)
        {
            ListNV = new ArrayList<NhanVien>();
            ListNV = Q.ReadNhanVien();
        }
        return FT.khungtableNV(ListNV);
    }
    
    public DefaultTableModel AddNV(String Ten, String CMND, int ChucVu , String Pass)
    {
        if(KTThongTinNV(CMND,Pass,1) && CheckMaNV(CMND.substring(0,11),0))
        {
            NhanVien nv = new NhanVien();
            nv.setMaNV(CMND.substring(0,11));
            nv.setTenNV(Ten);
            nv.setCMND(CMND);
            nv.setPassword(Pass);
            nv.setChucvu(ChucVu);
            nv.setPassword(Pass);
            nv.setluong(CreateLuong(ChucVu));
            Q.AddNhanVien(nv);
            ListNV=null;
        }
        return ReadNV();
    }
    
    public DefaultTableModel FixNV(String Ma,String Ten, String CMND, int ChucVu , String Pass)
    {
        if(KTThongTinNV(CMND,Pass,2))
        {
            int dem=0;
            if(Ma.equals(CMND.substring(0,11)) && CheckMaNV(CMND.substring(0,11),2)) dem=1;
            if(Ma.equals(CMND.substring(0,11))== false && CheckMaNV(CMND.substring(0,11),1)) dem=1;
            if(dem==1)
            {
                NhanVien nv = new NhanVien();
                nv.setMaNV(CMND.substring(0, 11));
                nv.setTenNV(Ten);
                nv.setCMND(CMND);
                nv.setPassword(Pass);
                nv.setChucvu(ChucVu);
                nv.setPassword(Pass);
                nv.setluong(CreateLuong(ChucVu));
                Q.FixNhanVien(Ma, nv);
                ListNV = null;
            }
        }
        return ReadNV();
    }
    
    public DefaultTableModel DelNV(String Ma)
    {
        if(CheckMaNV(Ma,0)==false)
        {
            Q.DelNhanVien(Ma);
            ListNV=null;
        }
        else
        {
            JOptionPane.showInternalMessageDialog(null, "Không có nhân viên này !"); 
        }
        return ReadNV();
    }
    
    
    // tim kiếm
    public NhanVien timkiem1NV(String MaNV) {
        for (NhanVien nv : ArrayListALL.ListNV) {
            if (MaNV.equals(nv.getMaNV())) {
                return nv;
            }
        }
        return null;
    }
    
     public DefaultTableModel TimKiemTheoInt(String st, int i)
    {
        ListNV1 = new ArrayList <NhanVien>();
        for(NhanVien nv : ListNV)
        {
            switch(i)
            {
                case 0:
                {
                    //ma
                    if(st.equals(nv.getMaNV())) ListNV1.add(nv);
                    break;
                }
                case 1:
                {
                    //ten
                    if(str.KT_Ten(nv.getTenNV(),st)) ListNV1.add(nv);
                    break;
                }
                case 2:
                {
                    //cm
                    if(st.equals(nv.getCMND())) ListNV1.add(nv);
                    break;
                }
                case 3:
                {
                    //chucvu
                    if(str.KT_Ten(nv.getChucvuTT(), st)) ListNV1.add(nv);
                    break;
                }
                default: break;
            }
        }
        return FT.khungtableNV(ListNV1);
    }
    
    // Sắp xếp
    public DefaultTableModel SapXep(ArrayList<NhanVien> ListSapXep,int k)
    {
        switch(k)
        {
            case 1:
            {
                Collections.sort(ListSapXep, (NhanVien nv1, NhanVien nv2) -> (nv1.getMaNV().compareTo(nv2.getMaNV())));
                break;
            }
            case 2:
            {
                Collections.sort(ListSapXep, (NhanVien nv1, NhanVien nv2) -> (nv1.getTenNV().compareTo(nv2.getTenNV())));
                break;
            }
            case 3:
            {
                Collections.sort(ListSapXep, (NhanVien nv1, NhanVien nv2) -> (nv1.getCMND().compareTo(nv2.getCMND())));
                break;
            }
            case 4:
            {
                Collections.sort(ListSapXep, (NhanVien nv1, NhanVien nv2) -> (nv1.getChucvuTT().compareTo(nv2.getChucvuTT())));
                break;
            }
            case 5:
            {
                Collections.sort(ListSapXep, (NhanVien nv1, NhanVien nv2) -> (nv1.getluong()-nv2.getluong()));
                break;
            }
            default: break;
        }
        return FT.khungtableNV(ListSapXep);
    }
    
    
}
