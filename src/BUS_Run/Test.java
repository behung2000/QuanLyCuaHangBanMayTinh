/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_Run;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thaiv
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CheckInput ci = new CheckInput();
        System.out.println(ci.KTCMND("07885568"));
        System.out.println(ci.KTSDT("01203"));
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String t=df.format(date);
        System.out.println(date);
        System.out.println(t);
        String s="2020-06-21";
        System.out.println(t.compareTo(s));
        System.out.println(s.length());
        String e=" 2020 - 1000000000-10000000000000000000000";
        HandlingString str = new HandlingString();
        System.out.println(e);
        e=str.DelAllmyTrim(e);
        System.out.println(e);
        try {
            date = df.parse(e);
            System.out.println(date);
            
        } catch (ParseException ex) {
            System.out.println("Errro");
        }
        System.out.println(date);
        String so=" 1";
        try
        {
            int g= Integer.parseInt(so);
            System.out.println(g);
        }
        catch(NumberFormatException exception)
        {
            System.out.println("erro");
        }
        
        try 
        {
            String ten="adsad";
            ten=ten+".txt";
            FileWriter myWriter = new FileWriter(ten);
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } 
        catch (IOException exception) 
        {
            System.out.println("An error occurred.");
        }
        
    }
    //Truy Vấn CT sản phẩm :
            //SELECT thongtinsanpham.MaSP,
            //TenSP, ThongTin, SoLuong, GiaNhap,
            //DonGia, TenLoai, TenNSX, TenNCC,
            //ViTriBH, ThoiGianBH, SoLuongCanMua,
            //`GiamGia(phantram)`, NgayBD, NgayKT
            //FROM thongtinsanpham, loaisp, nhacungcap, baohanh, nsx,
            //thongtinkhuyenmai, spkhuyenmai WHERE thongtinsanpham.MaLoai=loaisp.MaLoai AND thongtinsanpham.MaNSX=nsx.MaNSX
            //AND thongtinsanpham.MaCC=nhacungcap.MaCC AND thongtinsanpham.MaBH=baohanh.MaBH AND thongtinsanpham.MaSP=spkhuyenmai.MaSP AND spkhuyenmai.MaKM=thongtinkhuyenmai.MaKM
    
// SELECT thongtinsanpham.MaSP,TenSP, ThongTin, SoLuong, GiaNhap, DonGia, TenLoai, TenNSX, TenNCC, ViTriBH, ThoiGianBH FROM thongtinsanpham, loaisp, nhacungcap, baohanh, nsx WHERE thongtinsanpham.MaLoai=loaisp.MaLoai AND thongtinsanpham.MaNSX=nsx.MaNSX AND thongtinsanpham.MaCC=nhacungcap.MaCC AND thongtinsanpham.MaBH=baohanh.MaBH
//SELECT thongtinsanpham.MaSP,TenSP, TenLoai, ThongTin, SoLuong, DonGia, TenNSX, ViTriBH, ThoiGianBH FROM thongtinsanpham, loaisp, baohanh, nsx WHERE thongtinsanpham.MaLoai=loaisp.MaLoai AND thongtinsanpham.MaNSX=nsx.MaNSX AND thongtinsanpham.MaBH=baohanh.MaBH
//UPDATE `thongtinsanpham` SET `SoLuong`="32" WHERE `MaSP`="PKK003"
}
