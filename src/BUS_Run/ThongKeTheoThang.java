/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_Run;

import DAO.QueryDB_ThongKe;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WIN7
 */
public class ThongKeTheoThang {
    QueryDB_ThongKe TK = new QueryDB_ThongKe();
    DefaultTableModel model = new DefaultTableModel(0,2);
    public DefaultTableModel buildTableModel(int month)
        throws SQLException {
        ResultSet rs = TK.thongKeTheoThang(month);
        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        Vector tieude = new Vector();
        tieude.add("Mã hóa đơn");
        tieude.add("Mã nhân viên");
        tieude.add("Mã khách hàng");
        tieude.add("Ngày bán");
        tieude.add("Tổng tiền");
        for (int column = 1; column <= columnCount; column++) 
        {
            if(column==1) columnNames.add("Mã hóa đơn");
            if(column==2) columnNames.add("Mã nhân viên");
            if(column==3) columnNames.add("Mã khách hàng");
            if(column==4) columnNames.add("Ngày bán");
            if(column==5) columnNames.add("Tổng tiền");
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
}

