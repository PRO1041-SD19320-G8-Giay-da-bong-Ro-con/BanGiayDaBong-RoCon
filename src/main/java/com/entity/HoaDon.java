/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

import java.util.Date;

/**
 *
 * @author Thai
 */
public class HoaDon {

    private String MaHD;
    private String TaiKhoan;
    private String MaKH;
    private double TongTienGoc;
    private String MaKM;
    private double TongTienCuoi;
    private Date ThoiGianBan;
    private boolean TrangThai;

    public HoaDon() {
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public double getTongTienGoc() {
        return TongTienGoc;
    }

    public void setTongTienGoc(double TongTienGoc) {
        this.TongTienGoc = TongTienGoc;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public double getTongTienCuoi() {
        return TongTienCuoi;
    }

    public void setTongTienCuoi(double TongTienCuoi) {
        this.TongTienCuoi = TongTienCuoi;
    }

    public Date getThoiGianBan() {
        return ThoiGianBan;
    }

    public void setThoiGianBan(Date ThoiGianBan) {
        this.ThoiGianBan = ThoiGianBan;
    }



    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    public String getTrangThai(){
        return this.TrangThai?"Đã thanh toán":"Chưa thanh toán";
    }

}
