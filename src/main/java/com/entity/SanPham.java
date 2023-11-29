/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author Thai
 */
public class SanPham {

    private String MaSP;
    private String TenSP;
    private String Hinh;
    private String MaThuongHieu;
    private String MaLoai;
    private String MaChatLieu;
    private String MaXuatXu;
    private double Gia;
    private boolean TrangThai;

    public SanPham() {
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getMaThuongHieu() {
        return MaThuongHieu;
    }

    public void setMaThuongHieu(String MaThuongHieu) {
        this.MaThuongHieu = MaThuongHieu;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getMaChatLieu() {
        return MaChatLieu;
    }

    public void setMaChatLieu(String MaChatLieu) {
        this.MaChatLieu = MaChatLieu;
    }

    public String getMaXuatXu() {
        return MaXuatXu;
    }

    public void setMaXuatXu(String MaXuatXu) {
        this.MaXuatXu = MaXuatXu;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getTrangThai() {
        return TrangThai?"Đang bán":"Ngừng bán";
    }

}
