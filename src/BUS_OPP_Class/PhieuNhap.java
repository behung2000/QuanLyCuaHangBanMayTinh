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
public class PhieuNhap extends Phieu
{
    public String MaCC;
    
    public PhieuNhap(){}
    
    public PhieuNhap(String MaP, String MaNV, String Ngay, int TongTien, String MaCC)
    {
        this.MaP=MaP;
        this.MaNV=MaNV;
        this.Ngay=Ngay;
        this.TongTien=TongTien;
        this.MaCC=MaCC;
    }
    
    //MaP
    @Override
    public void setMaP(String MaP)
    {
        this.MaP=MaP;
    }
    
    @Override
    public String getMaP()
    {
        return MaP;
    }
    
    //MaNV
    @Override
    public void setMaNV(String MaNV)
    {
        this.MaNV=MaNV;
    }
    
    @Override
    public String getMaNV()
    {
        return MaNV;
    }
    
    //Ngay
    @Override
    public void setNgay(String Ngay)
    {
        this.Ngay=Ngay;
    }
    
    @Override
    public String getNgay()
    {
        return Ngay;
    }
    
    //Tong Tien
    @Override
    public void setTTien(int TongTien)
    {
        this.TongTien=TongTien;
    }
    
    @Override
    public int getTTien()
    {
        return TongTien;
    }
    
    //MaCC
    public void setMaCC(String MaCC)
    {
        this.MaCC=MaCC;
    }
    
    public String getMaCC()
    {
        return MaCC;
    }
}
