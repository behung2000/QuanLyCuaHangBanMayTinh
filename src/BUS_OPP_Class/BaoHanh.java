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
public class BaoHanh {
    // combox 0 -> tại chỗ -> true = 1
    
    public String MaBH;
    public boolean Vitri;
    public int ThoiGian;
    
    public BaoHanh(){}
    
    public BaoHanh(String MaBH, boolean Vitri, int ThoiGian)
    {
        this.MaBH=MaBH;
        this.Vitri=Vitri;
        this.ThoiGian=ThoiGian;
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
    
    //ViTri
    public void setVitri(boolean Vitri)
    {
        this.Vitri=Vitri;
    }
    
    public boolean getVitri()
    {
        return Vitri;
    }
    
    public String getVitriTT()
    {
        if(Vitri==true) return "Tại Chỗ";
        else return "Gửi về nhà cung cấp";
    }
    
    //ThoiGian
    public void setTG(int ThoiGian)
    {
        this.ThoiGian=ThoiGian;
    }
    
    public int getTG()
    {
        return ThoiGian;
    }
}
