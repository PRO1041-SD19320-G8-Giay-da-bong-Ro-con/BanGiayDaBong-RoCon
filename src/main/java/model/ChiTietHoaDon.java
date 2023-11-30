/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.entity.*;
import java.util.Date;

/**
 *
 * @author Thai
 */
public class ChiTietHoaDon extends HoaDon{

    private String MaHD;
    private String MaCTSP;
    private int SoLuong;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String MaHD, String MaCTSP, int SoLuong) {
        this.MaHD = MaHD;
        this.MaCTSP = MaCTSP;
        this.SoLuong = SoLuong;
    }

    public ChiTietHoaDon(String MaCTSP, int SoLuong, String maHD, String taiKhoan, String maKH, Double tongTienGoc, String maKM, Double tongTienCuoi, Date thoiGianBan, String hinhThucThanhToan, boolean trangThai) {
        super(maHD, taiKhoan, maKH, tongTienGoc, maKM, tongTienCuoi, thoiGianBan, hinhThucThanhToan, trangThai);
        this.MaCTSP = MaCTSP;
        this.SoLuong = SoLuong;
    }

    
    
    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaCTSP() {
        return MaCTSP;
    }

    public void setMaCTSP(String MaCTSP) {
        this.MaCTSP = MaCTSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    

}
