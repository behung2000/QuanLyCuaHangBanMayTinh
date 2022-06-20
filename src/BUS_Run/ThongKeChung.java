/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_Run;

import DAO.QueryDB_ThongKe;
import Frame.FramesTable;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WIN7
 */
public class ThongKeChung 
{
    QueryDB_ThongKe TK = new QueryDB_ThongKe();
    public FramesTable FT = new FramesTable();
    
    public DefaultTableModel thongKe()
    {
        Vector row = new Vector();
        try 
        {
            row.add(TK.thongKeNhanVien());
            row.add(TK.thongKeKhachHang());
            row.add(TK.thongKeSanPham());
            row.add(TK.thongKeNhaSanXuat());
            row.add(TK.thongKeNhaCungCap());
            
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showInternalMessageDialog(null,"Thông kê thất bại !");
        }
        return FT.khungThongKeTongQuat(row);
    }
    
    
}
