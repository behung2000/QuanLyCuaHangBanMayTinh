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
public class LoaiSP {
    public String MaLoai;
    public String TenLoai;
    
    public LoaiSP(){}
    
    public LoaiSP(String MaLoai, String TenLoai)
    {
        this.MaLoai=MaLoai;
        this.TenLoai=TenLoai;
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
    
    //TenLoai
    public void setTenLoai(String TenLoai)
    {
        this.TenLoai=TenLoai;
    }
    
    public String getTenLoai()
    {
        return TenLoai;
    }
}
