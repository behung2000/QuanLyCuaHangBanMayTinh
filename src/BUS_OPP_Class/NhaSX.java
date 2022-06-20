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
public class NhaSX {
    public String MaNSX;
    public String TenNSX;
    public String DiaChi;
    
    public NhaSX(){}
    
    public NhaSX(String MaNSX, String TenNSX, String DiaChi)
    {
        this.MaNSX=MaNSX;
        this.TenNSX=TenNSX;
        this.DiaChi=DiaChi;
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
    
    //TenNSX
    public void setTenNSX(String TenNSX)
    {
        this.TenNSX=TenNSX;
    }
    
    public String getTenNSX()
    {
        return TenNSX;
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
