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
public class KhachHang 
{
    public String CMND;
    public String TenKH;
    public String SDT;
    public String DiaChi;
    
    public KhachHang(){}
    
    public KhachHang(String CMND, String TenKH, String SDT, String DiaChi)
    {
        this.CMND=CMND;
        this.TenKH=TenKH;
        this.SDT=SDT;
        this.DiaChi=DiaChi;
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
    
    //TenKH
    public void setTenKH(String TenKH)
    {
        this.TenKH=TenKH;
    }
    
    public String getTenKH()
    {
        return TenKH;
    }
    
    //SDT
    public void setSDT(String SDT)
    {
        this.SDT=SDT;
    }
    
    public String getSDT()
    {
        return SDT;
    }
    
    //Dia Chi
    public void setDiaChi(String DiaChi)
    {
        this.DiaChi=DiaChi;
    }
    
    public String getDiaChi()
    {
        return DiaChi;
    }
    
}
