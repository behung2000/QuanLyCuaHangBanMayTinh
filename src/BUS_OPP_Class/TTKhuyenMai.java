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
public class TTKhuyenMai 
{
    public String MaKM;
    public int SoLuong;
    public int GiamGia;
    public String NgayBD;
    public String NgayKT;
    
    public TTKhuyenMai(){}
    
    public TTKhuyenMai(String MaKM, int SoLuong, int GiamGia, String NgayBD, String NgayKT)
    {
        this.MaKM=MaKM;
        this.SoLuong=SoLuong;
        this.GiamGia=GiamGia;
        this.NgayBD=NgayBD;
        this.NgayKT=NgayKT;
    }
    
    //MaKM
    public void setMaKM(String MaKM)
    {
        this.MaKM=MaKM;
    }
    
    public String getMaKM()
    {
        return MaKM;
    }
    
    //Số Lượng cần mua để khuyến mãi
    public void setSL(int SoLuong)
    {
        this.SoLuong=SoLuong;
    }
    
    public int getSL()
    {
        return SoLuong;
    }
    
    //GiamGia
    public void setGiamGia(int GiamGia)
    {
        this.GiamGia=GiamGia;
    }
    
    public int getGiamGia()
    {
        return GiamGia;
    }
    
    //NgayBD
    public void setNgayBD(String NgayBD)
    {
        this.NgayBD=NgayBD;
    }
    
    public String getNgayBD()
    {
        return NgayBD;
    }
    
    //NgayKT
    public void setNgayKT(String NgayKT)
    {
        this.NgayKT=NgayKT;
    }
    
    public String getNgayKT()
    {
        return NgayKT;
    }
}
