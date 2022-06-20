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
public class NhanVien 
{
    public String MaNV;
    public String TenNV;
    public String CMND;
    public String Password;
    public int chucvu;
    public int luong;
    
    public NhanVien(){}
    
    public NhanVien(String MaNV, String TenNV, String CMND, String Password, int chucvu, int luong)
    {
        this.MaNV=MaNV;
        this.TenNV=TenNV;
        this.CMND=CMND;
        this.Password=Password;
        this.chucvu=chucvu;
        this.luong=luong;
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
    
    //TenNV
    public void setTenNV(String TenNV)
    {
        this.TenNV=TenNV;
    }
    
    public String getTenNV()
    {
        return TenNV;
    }
    
    //CMND
    public void setCMND(String CMND)
    {
        this.CMND=CMND;
    }
    
    public String getCMND()
    {
        return CMND;
    }
    
    //Password
    public void setPassword(String Password)
    {
        this.Password=Password;
    }
    
    public String getPassword()
    {
        return Password;
    }
    
    //Chuc Vu
    public void setChucvu(int chucvu)
    {
        this.chucvu=chucvu;
    }
    
    public int getChucvu()
    {
        return chucvu;
    }
    
    public String getChucvuTT()
    {
        switch(chucvu)
        {
            case 0: return "Chủ cửa hàng";
            case 1: return "Quản lý cửa hàng";
            case 2: return "Nhân Viên bình thường";
            default: return "Không có Nhân Viên này";
        }
    }
    
    //Luong
    public void setluong(int luong)
    {
        this.luong=luong;
    }
    
    public int getluong()
    {
        return luong;
    }
    
}
