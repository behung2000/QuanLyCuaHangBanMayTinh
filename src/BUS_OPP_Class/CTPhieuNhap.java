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
public class CTPhieuNhap extends ChiTietPhieu 
{
    public CTPhieuNhap(){}
    
    public CTPhieuNhap(String MaP, String MaSP, int SoLuong, int ThanhTien)
    {
        this.MaP=MaP;
        this.MaSP=MaSP;
        this.SoLuong=SoLuong;
        this.ThanhTien=ThanhTien;
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
    
    //MaSP
    @Override
    public void setMaSP(String MaSP)
    {
        this.MaSP=MaSP;
    }
    
    @Override
    public String getMaSP()
    {
        return MaSP;
    }
    
    //SoLuong
    @Override
    public void setSL(int SoLuong)
    {
        this.SoLuong=SoLuong;
    }
    
    @Override
    public int getSL()
    {
        return SoLuong;
    }
    
    //Thanh Tien
    @Override
    public void setTTien(int ThanhTien)
    {
        this.ThanhTien=ThanhTien;
    }
    
    @Override
    public int getTTien()
    {
        return ThanhTien;
    }
}
