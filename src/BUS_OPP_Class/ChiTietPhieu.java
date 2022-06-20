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
abstract class ChiTietPhieu 
{
    public String MaP;
    public String MaSP;
    public int SoLuong;
    public int ThanhTien;
    
    public ChiTietPhieu(){}
    
    public ChiTietPhieu(String MaP, String MaSP, int SoLuong, int ThanhTien)
    {
        this.MaP=MaP;
        this.MaSP=MaSP;
        this.SoLuong=SoLuong;
        this.ThanhTien=ThanhTien;
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
    
    //MaSP
    public void setMaSP(String MaSP)
    {
        this.MaSP=MaSP;
    }
    
    public String getMaSP()
    {
        return MaSP;
    }
    
    //SoLuong
    public void setSL(int SoLuong)
    {
        this.SoLuong=SoLuong;
    }
    
    public int getSL()
    {
        return SoLuong;
    }
    
    //Thanh Tien
    public void setTTien(int ThanhTien)
    {
        this.ThanhTien=ThanhTien;
    }
    
    public int getTTien()
    {
        return ThanhTien;
    }
}
