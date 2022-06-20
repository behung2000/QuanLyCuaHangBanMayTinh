/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_Class;

/**
 *
 * @author thaiv
 */
abstract class Phieu {
    public String MaP=null;
    public String MaNV=null;
    public String Ngay=null;
    public int TongTien=0;
    
    public Phieu(){};
    
    public Phieu(String MaP, String MaNV, String Ngay, int TongTien)
    {
        this.MaP=MaP;
        this.MaNV=MaNV;
        this.Ngay=Ngay;
        this.TongTien=TongTien;
    }
    
    //MaP
    public void setMaP(String MaP)
    {
        this.MaP=MaP;
    }
    
    public String getMaP()
    {
        return MaP;
    }
    
    //MaNV
    public void setMaNV(String MaNV)
    {
        this.MaNV=MaNV;
    }
    
    public String getMaNV()
    {
        return MaNV;
    }
    
    //Ngay
    public void setNgay(String Ngay)
    {
        this.Ngay=Ngay;
    }
    
    public String getNgay()
    {
        return Ngay;
    }
    
    //Tong Tien
    public void setTTien(int TongTien)
    {
        this.TongTien=TongTien;
    }
    
    public int getTTien()
    {
        return TongTien;
    }
}
