/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS_OPP_RUN;

/**
 *
 * @author thaiv
 */

import BUS_OPP_Class.NhanVien;
import BUS_OPP_Class.KhachHang;
import BUS_OPP_Class.TTSanPham;
import BUS_OPP_Class.LoaiSP;
import BUS_OPP_Class.BaoHanh;
import BUS_OPP_Class.NhaCC;
import BUS_OPP_Class.NhaSX;
import BUS_OPP_Class.TTKhuyenMai;
import BUS_OPP_Class.SP_KM;
import BUS_OPP_Class.HoaDon;
import BUS_OPP_Class.CTHoaDon;
import BUS_OPP_Class.PhieuNhap;
import BUS_OPP_Class.CTPhieuNhap;
import BUS_Run.CheckInput;
import BUS_Run.HandlingString;

import Frame.FramesTable;

import java.util.ArrayList;

        
public class ArrayListALL 
{
    public static ArrayList <NhanVien> ListNV;
    public static ArrayList <KhachHang> ListKH;
    
    public static ArrayList <TTSanPham> ListSP;
    public static ArrayList <LoaiSP> ListLSP;
    public static ArrayList <BaoHanh> ListBH;
    
    public static ArrayList <TTKhuyenMai> ListKM;
    public static ArrayList <SP_KM> ListLKM;
    
    public static ArrayList <NhaCC> ListCC;
    public static ArrayList <NhaSX> ListSX;
    
    public static ArrayList <HoaDon> ListHD;
    public static ArrayList <CTHoaDon> ListCTHD;
    
    public static ArrayList <PhieuNhap> ListPN;
    public static ArrayList <CTPhieuNhap> ListCTPN;
    
    public static int HeThong=-1;
    public static String MaNV="";
    
    public FramesTable FT = new FramesTable();
    public HandlingString str = new HandlingString();
    public CheckInput ci = new CheckInput();
    
    public static void resetdabase()
    {
        ListNV = null;
        ListKH = null;
        
        ListSP = null;
        ListLSP = null;
        ListBH = null;

        ListKM = null;
        ListLKM = null;

        ListCC = null;
        ListSX = null;

        ListHD = null;
        ListCTHD = null;

        ListPN = null;
        ListCTPN = null;
    }
}
