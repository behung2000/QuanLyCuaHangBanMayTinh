/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author thaiv
 */
public class TestDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, DocumentException {
        // TODO code application logic here
        String s1 = "Java la ngôn ngữ lập trinh. Java la mot nen tang. Java la mot hon dao.";
        s1 = s1.toLowerCase();
        String s2 = "ngôn";
        s2 = s2.toLowerCase();
        String replaceString = s1.replaceAll(s2, "1");//thay the "Java" to "Ja"
        System.out.println(s1);
        s1 = "java0";
        s2 = "java1";
        System.out.println(replaceString);
        System.out.println(s2.compareTo(s1));
        String databaseName = "csld";
        String hostname = "localhost";
        String user = "root";
        String pass = "";
        String dbURL = "jdbc:mysql://" + hostname + ":3306/" + databaseName;
        Connection conn = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = (Connection) DriverManager.getConnection(dbURL, user, pass);
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "Kết nối Database thất bại !");
        }

        Statement st = null;
        ResultSet rs = null;
        Document document = new Document();
             
                try 
                {
                    PdfWriter.getInstance(document, new FileOutputStream("filename.pdf"));
                    document.open();
                    Phrase p1 = new Phrase("123");
                    Phrase p2 = new Phrase("234");
                    Paragraph p = new Paragraph();
                    document.add(new Paragraph("A Hello World PDF document."));
                    document.add(new Paragraph("A Hello World PDF document."));
                    document.add(new Paragraph("A Hello World PDF document."));
                    document.add(new Paragraph("--"));
                    document.add(new Paragraph("|                                                                                                                                        |"));
                    document.add(p);
                    document.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
                }
          String gg= "----------------------------------------------------------------------------------------------------------------------------------";
          System.out.println("dsadasdasd :-----"+gg.length());
          System.out.println(" |");

        String qry = "SELECT * FROM asus";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(qry);
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "truy cập thất bại ! " + qry);

        }
        while (rs.next())
        {
            String t = rs.getString(4);
            System.out.println(t);
        }
        JFrame.setDefaultLookAndFeelDecorated(true); 
    JFrame frame = new JFrame("JComboBox Test");
    frame.setLayout(new FlowLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    String[] selections = { "green", "red", "orange", "dark blue" };
    JComboBox comboBox = new JComboBox(selections);
    comboBox.setSelectedIndex(1);
    System.out.println(comboBox.getSelectedItem());
    frame.add(comboBox);
    frame.pack();
    frame.setVisible(true);
    
    }

}
