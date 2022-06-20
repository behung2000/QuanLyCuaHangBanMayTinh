/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_Class;

import java.util.Date;

/**
 *
 * @author thaiv
 */
public class TTSanPham 
{
    public String MaSP;
    public String MaNSX;
    public String MaCC;
    public String MaLoai;
    public String MaBH;
    public String TenSP;
    public String ThongTin;
    public int SoLuong;
    public int GiaNhap;
    public int DonGia;
    
    public TTSanPham(){}
    
    public TTSanPham(String MaSP, String MaNSX, String MaCC, String MaLoai, String MaBH, String TenSP, String ThongTin, int SoLuong, int GiaNhap, int DonGia)
    {
        this.MaSP=MaSP;
        this.MaNSX=MaNSX;
        this.MaCC=MaCC;
        this.MaLoai=MaLoai;
        this.MaBH=MaBH;
        this.TenSP=TenSP;
        this.ThongTin=ThongTin;
        this.SoLuong=SoLuong;
        this.GiaNhap=GiaNhap;
        this.DonGia=DonGia;
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
    
    //MaNSX
    public void setMaNSX(String MaNSX)
    {
        this.MaNSX=MaNSX;
    }
    
    public String getMaNSX()
    {
        return MaNSX;
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
    
    //MaLoai
    public void setMaLoai(String MaLoai)
    {
        this.MaLoai=MaLoai;
    }
    
    public String getMaLoai()
    {
        return MaLoai;
    }
    
    //MaBH
    public void setMaBH(String MaBH)
    {
        this.MaBH=MaBH;
    }
    
    public String getMaBH()
    {
        return MaBH;
    }
    
    //TenSP
    public void setTenSP(String TenSP)
    {
        this.TenSP=TenSP;
    }
    
    public String getTenSP()
    {
        return TenSP;
    }
    
    //ThongTin
    public void setTT(String ThongTin)
    {
        this.ThongTin=ThongTin;
    }
    
    public String getTT()
    {
        return ThongTin;
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
    
    //GiaNhap
    public void setGN(int GiaNhap)
    {
        this.GiaNhap=GiaNhap;
    }
    
    public int getGN()
    {
        return GiaNhap;
    }
    
    //DonGia
    public void setDG(int DonGia)
    {
        this.DonGia=DonGia;
    }
    
    public int getDG()
    {
        return DonGia;
    }
}
