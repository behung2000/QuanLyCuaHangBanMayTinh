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
public class NhaCC 
{
    public String MaCC;
    public String TenNCC;
    public String DiaChi;
    public String SDT;
    
    public NhaCC(){}
    
    public NhaCC(String MaCC, String TenNCC, String DiaChi, String SDT)
    {
        this.MaCC=MaCC;
        this.TenNCC=TenNCC;
        this.DiaChi=DiaChi;
        this.SDT=SDT;
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
    
    //TenNCC
    public void setTenNCC(String TenNCC)
    {
        this.TenNCC=TenNCC;
    }
    
    public String getTenNCC()
    {
        return TenNCC;
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
    
    //SDT
    public void setSDT(String SDT)
    {
        this.SDT=SDT;
    }
    
    public String getSDT()
    {
        return SDT;
    }
}
