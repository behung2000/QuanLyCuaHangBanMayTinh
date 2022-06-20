/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BUS_OPP_Class.SP_KM;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class QueryDB_SP_KM 
{
    QueryDB Q = new QueryDB();
    //San Pham - Khuyen Mai
    public ArrayList ReadLKM()
    {
        ArrayList <SP_KM> ListLKM = new ArrayList<SP_KM>();
        try 
        {
            ResultSet rs = Q.SelectFormDB("spkhuyenmai");
            while (rs.next()) 
            {
                SP_KM lkm = new SP_KM();
                lkm.setMaSP(rs.getString(1));
                lkm.setMaKM(rs.getString(2));
                ListLKM.add(lkm);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null, "ERROR Read csdl liên kết Sản Phẩm - Khuyến Mãi !");
        }
        return ListLKM;
    }
    
    public void AddLKM(SP_KM lkm)
    {
        String q = "spkhuyenmai`(`MaSP`, `MaKM`) VALUES ('";
        q = q + lkm.getMaSP()+ "','";
        q = q + lkm.getMaKM() + "')";
        Q.InsertDB(q);
    }
    
    public void DelLKMTheoMaSP(String MaSP)
    {
        String q = "spkhuyenmai` WHERE MaSP='";
        q = q + MaSP + "'";
        Q.DeleteDB(q);
    }
    
    public void DelALLLKM()
    {
        String q = "spkhuyenmai`";
        Q.DeleteDB(q);
    }
}
