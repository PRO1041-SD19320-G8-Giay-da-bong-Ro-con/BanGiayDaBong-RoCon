/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private String maHD;
    
    private String taiKhoan;
    
    private String maKH;
    
    private Double tongTienGoc;
    
    private String maKM;
    
    private Double tongTienCuoi;
    
    private Date thoiGianBan;
    
    private String hinhThucThanhToan;
    
    private boolean trangThai;

    public HoaDon() {
    }

    public HoaDon(String maHD, String taiKhoan, String maKH, Double tongTienGoc, String maKM, Double tongTienCuoi, Date thoiGianBan, String hinhThucThanhToan, boolean trangThai) {
        this.maHD = maHD;
        this.taiKhoan = taiKhoan;
        this.maKH = maKH;
        this.tongTienGoc = tongTienGoc;
        this.maKM = maKM;
        this.tongTienCuoi = tongTienCuoi;
        this.thoiGianBan = thoiGianBan;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.trangThai = trangThai;
    }

    public HoaDon(String maHD, Date thoiGianBan, String taiKhoan, String maKH) {
        this.maHD = maHD;
        this.taiKhoan = taiKhoan;
        this.maKH = maKH;
        this.thoiGianBan = thoiGianBan;
    }
    
    

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Double getTongTienGoc() {
        return tongTienGoc;
    }

    public void setTongTienGoc(Double tongTienGoc) {
        this.tongTienGoc = tongTienGoc;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public Double getTongTienCuoi() {
        return tongTienCuoi;
    }

    public void setTongTienCuoi(Double tongTienCuoi) {
        this.tongTienCuoi = tongTienCuoi;
    }

    public Date getThoiGianBan() {
        return thoiGianBan;
    }

    public void setThoiGianBan(Date thoiGianBan) {
        this.thoiGianBan = thoiGianBan;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
    
}
