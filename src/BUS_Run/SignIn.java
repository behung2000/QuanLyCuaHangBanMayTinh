/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_Run;

import BUS_OPP_Class.NhanVien;
import BUS_OPP_RUN.ArrayListALL;
import BUS_OPP_RUN.RunNhanVien;

/**
 *
 * @author thaiv
 */
public class SignIn
{
    public boolean DangNhap(String user, String password)
    {
        RunNhanVien ra = new RunNhanVien();
        ra.ReadNV();
        if(ArrayListALL.ListNV != null)
        {
            for(NhanVien nv : ArrayListALL.ListNV)
            {
                String us = nv.getMaNV();
                if(us.equals(user))
                {
                    String pw = nv.getPassword();
                    if(pw.equals(password))
                    {
                        ArrayListALL.MaNV=user;
                        ArrayListALL.HeThong=nv.getChucvu();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
