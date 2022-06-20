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
public class SP_KM 
{
    public String MaSP;
    public String MaKM;
    
    public SP_KM(){}
    
    public SP_KM(String MaSP, String MaKM)
    {
        this.MaSP=MaSP;
        this.MaKM=MaKM;
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
    
    //MaKM
    public void setMaKM(String MaKM)
    {
        this.MaKM=MaKM;
    }
    
    public String getMaKM()
    {
        return MaKM;
    }
}
