/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

import BUS_OPP_Class.TTKhuyenMai;
import DAO.QueryDB_TTKhuyenMai;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaiv
 */
public class RunTTKhuyenMai extends ArrayListALL
{
    ArrayList<TTKhuyenMai> ListKM1;
    QueryDB_TTKhuyenMai Q = new QueryDB_TTKhuyenMai();
    
    public RunTTKhuyenMai()
    {
        ReadTTKM();
    }
    
    //Check Mã Khuyến Mãi
    public boolean CheckMaKM(String ma)
    {
        for( TTKhuyenMai km : ListKM)
        {
            if((km.getMaKM()).equals(ma)) return false;
        }
        return true;
    }
    
    //Kiểm tra date bắt đầu và kết thúc
    public boolean CheckDuLieuKM(String SL, String GG, String BD, String KT)
    {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String t=df.format(date);
        if(ci.KT_Date(BD)==true && ci.KT_Date(KT)==true)
        {
            if (BD.compareTo(t) >= 0) 
            {
                if (KT.compareTo(BD) >= 0) 
                {
                    if(ci.KT_so(SL)== false || ci.KT_so(GG) == false) JOptionPane.showInternalMessageDialog(null, "Nhập sai số lượng or giảm giá!");
                    else
                    {
                        return true;
                    }
                } 
                else JOptionPane.showInternalMessageDialog(null, "Ngày kết thúc trước ngày bắt đầu!");
            } 
            else JOptionPane.showInternalMessageDialog(null, "Ngày bắt đầu đã qua so với hiện tại!");
        }
        else JOptionPane.showInternalMessageDialog(null, "Nhập ngày bắt đầu or kết thúc sai định dạng!");
        return false;
    }
    
    //Đọc thêm sửa xóa
    public DefaultTableModel ReadTTKM()
    {
        if(ListKM==null)
        {
            ListKM = new ArrayList<TTKhuyenMai>();
            ListKM = Q.ReadTTKM();
        }
        return FT.khungtableTTKM(ListKM);
    }
    
    public DefaultTableModel AddTTKM(String SL, String GG, String BD, String KT)
    {
        if(CheckDuLieuKM(SL, GG, BD, KT))
        {
            String Ma = "" + ListKM.size();
            TTKhuyenMai km = new TTKhuyenMai();
            km.setMaKM(Ma);
            km.setSL(Integer.parseInt(SL));
            km.setGiamGia(Integer.parseInt(GG));
            km.setNgayBD(BD);
            km.setNgayKT(KT);
            Q.AddTTKM(km);
            ListKM = null;   
        }
        return ReadTTKM();
    }
    
    public DefaultTableModel FixTTKM(String Ma, String SL, String GG, String BD, String KT)
    {
        if(CheckMaKM(Ma))
        {
            JOptionPane.showInternalMessageDialog(null,"không tìm thấy đối tượng cần để sửa!");
        }
        else
        {
            if(CheckDuLieuKM(SL, GG, BD, KT))
            {
                TTKhuyenMai km = new TTKhuyenMai();
                km.setMaKM(Ma);
                km.setSL(Integer.parseInt(SL));
                km.setGiamGia(Integer.parseInt(GG));
                km.setNgayBD(BD);
                km.setNgayKT(KT);
                Q.FixTTKM(Ma, km);
                ListKM = null;
            }
        }
        return ReadTTKM();
    }
    
    public DefaultTableModel DelTTKM(String Ma)
    {
        if(CheckMaKM(Ma))
        {
            JOptionPane.showInternalMessageDialog(null,"không tìm thấy đối tượng cần để sửa!");
        }
        else
        {
            Q.DelTTKM(Ma);
            ListKM = null;
        }
        return ReadTTKM();
    }
    
    public DefaultTableModel DelALLTTKM()
    {
        Q.DelALLTTKM();
        ListKM=null;
        return ReadTTKM();
    }
    
    //Tìm Kiếm
    public DefaultTableModel TimKiemTheoInt(String st, int i)
    {
        ListKM1 = new ArrayList <TTKhuyenMai>();
        for(TTKhuyenMai km : ListKM)
        {
            if(i==0)
            {
                if(st.equals(km.getMaKM())) ListKM1.add(km);
            }
            else
            {
                int stInt = Integer.parseInt(st);
                if(i==1)
                {
                    if(stInt==km.getSL()) ListKM1.add(km);
                }
                else
                {
                    if(i==2)
                    {
                        if(stInt==km.getGiamGia()) ListKM1.add(km);
                    }
                    else
                    {
                        if(i==3)
                        {
                            if(st.equals(km.getNgayBD())) ListKM1.add(km);
                        }
                        else
                        {
                            if(i==4) if(st.equals(km.getNgayKT())) ListKM1.add(km);
                        }
                    }
                }
            }
        }
        return FT.khungtableTTKM(ListKM1);
    }
    
    public DefaultTableModel TimKiemTatCaKMcua1SP(ArrayList<String> ListTKKMcua1SP, boolean dk)
    {
        ListKM1 = new ArrayList <TTKhuyenMai>();
        Date today = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String day = df.format(today);
        for(String t : ListTKKMcua1SP)
        {
            for(TTKhuyenMai km : ListKM)
            {
                if(t.equals(km.getMaKM()))
                {
                    if(dk==false) ListKM1.add(km);
                    else
                    {
                        if((day.compareTo(km.getNgayBD()) >= 0) && day.compareTo(km.getNgayKT())<=0)
                        {
                            ListKM1.add(km);
                        }
                    }
                }
                
                
            }
        }
        return FT.khungtableTTKM(ListKM1);
    }
    
     // Sắp Xếp
    public DefaultTableModel SapXepTTKM(ArrayList<TTKhuyenMai> ListSapXep, int k)
    {
        switch(k)
        {
            case 0:
            {
                Collections.sort(ListSapXep, (TTKhuyenMai km1, TTKhuyenMai km2) -> (km1.getMaKM().compareTo(km2.getMaKM())));
                break;
            }
            case 1:
            {
                Collections.sort(ListSapXep, (TTKhuyenMai km1, TTKhuyenMai km2) -> (km1.getSL()-km2.getSL()));
                break;
            }
            case 2:
            {
                Collections.sort(ListSapXep, (TTKhuyenMai km1, TTKhuyenMai km2) -> (km1.getGiamGia()-km2.getGiamGia()));
                break;
            }
            case 3:
            {
                Collections.sort(ListSapXep, (TTKhuyenMai km1, TTKhuyenMai km2) -> (km1.getNgayBD().compareTo(km2.getNgayBD())));
                break;
            }
            case 4:
            {
                Collections.sort(ListSapXep, (TTKhuyenMai km1, TTKhuyenMai km2) -> (km1.getNgayKT().compareTo(km2.getNgayKT())));
                break;
            }
            default: break;
        }
        return FT.khungtableTTKM(ListSapXep);
    }
}
