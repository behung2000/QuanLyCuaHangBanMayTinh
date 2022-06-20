/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

import BUS_OPP_Class.PhieuNhap;
import DAO.QueryDB_PhieuNhap;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaiv
 */
public class RunPhieuNhap extends ArrayListALL
{
    QueryDB_PhieuNhap Q = new QueryDB_PhieuNhap();
    
    public RunPhieuNhap()
    {
        ReadPN();
    }
    
    // Kiểm tra ma hoa don
    public boolean KTMaPN(String MaPN)
    {
        for(PhieuNhap pn : ListPN) if(MaPN.equals(pn.getMaP())) return false;
        return true;
    }
    
    // Create tao PhieuNhap
    public String CreatePhieuNhap()
    {
        int dem=0;
        String Ma="PN";
        String MaPN="";
        while(KTMaPN(MaPN)==false || MaPN.length()<10)
        {
            MaPN=Ma;
            String so=""+dem;
            int n=10-2-so.length();
            for(int i=0; i<n; i++)
            {
                MaPN=MaPN+"0";
            }
            MaPN=MaPN+so;
            dem++;
        }
        return MaPN;
    }
    
    // Phiếu Nhập
    public DefaultTableModel ReadPN()
    {
        if(ListPN==null)
        {
            ListPN = new ArrayList<PhieuNhap>();
            ListPN = Q.ReadPN();
        }
        return FT.khungtablePhieuNhap(ListPN);
    }
    
    public void AddHD(String MaPN, String MaNV, String MaCC, String Ngay, int Tien)
    {
        PhieuNhap pn = new PhieuNhap();
        pn.setMaP(MaPN);
        pn.setMaNV(MaNV);
        pn.setMaCC(MaCC);
        pn.setNgay(Ngay);
        pn.setTTien(Tien);
        Q.AddPN(pn);
        ListPN=null;
        ReadPN();
    }
    
    // Tìm Kiếm
    public PhieuNhap XuatPN(String mapn)
    {
        for(PhieuNhap pn : ListPN)
        {
            if(mapn.equals(pn.getMaP())) return pn;
        }
        return null;
    }
}
