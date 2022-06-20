/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

import BUS_OPP_Class.HoaDon;
import DAO.QueryDB_HoaDon;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thaiv
 */
public class RunHoaDon extends ArrayListALL
{
    QueryDB_HoaDon Q = new QueryDB_HoaDon();
    
    public RunHoaDon()
    {
        ReadHD();
    }
    
    // Kiểm tra ma hoa don
    public boolean KTMaHD(String MaHD)
    {
        for(HoaDon hd : ListHD)
        {
            if(MaHD.equals(hd.getMaP())) return false;
        }
        return true;
    }
    
    // Create tao hoa don
    public String CreateHoaDon()
    {
        int dem=0;
        String Ma="HD";
        String MaHD="";
        while(KTMaHD(MaHD)==false || MaHD.length()<10)
        {
            MaHD=Ma;
            String so=""+dem;
            int n=10-2-so.length();
            for(int i=0; i<n; i++)
            {
                MaHD=MaHD+"0";
            }
            MaHD=MaHD+so;
            dem++;
        }
        return MaHD;
    }
    
    // Hoa Don
    public DefaultTableModel ReadHD()
    {
        if(ListHD==null)
        {
            ListHD = new ArrayList<HoaDon>();
            ListHD = Q.ReadHD();
        }
        return FT.khungtableHoaDon(ListHD);
    }
    
    public void AddHD(String MaHD, String MaNV, String MaKH, String Ngay, int Tien)
    {
        HoaDon hd = new HoaDon();
        hd.setMaP(MaHD);
        hd.setMaNV(MaNV);
        hd.setMaKH(MaKH);
        hd.setNgay(Ngay);
        hd.setTTien(Tien);
        Q.AddHD(hd);
        ListHD=null;
        ReadHD();
    }
    
    //Tim kiem
    public HoaDon XuatHD(String mahd)
    {
        for(HoaDon hd : ListHD)
        {
            if(mahd.equals(hd.getMaP())) return hd;
        }
        return null;
    }
}
