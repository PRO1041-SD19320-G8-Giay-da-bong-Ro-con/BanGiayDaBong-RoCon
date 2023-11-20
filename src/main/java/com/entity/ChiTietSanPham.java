/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author Thai
 */
public class ChiTietSanPham {

    private String MaCTSP;
    private String MaSP;
    private String MaSize;
    private String MaMau;
    private int SoLuong;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String MaCTSP, String MaSP, String MaSize, String MaMau, int SoLuong) {
        this.MaCTSP = MaCTSP;
        this.MaSP = MaSP;
        this.MaSize = MaSize;
        this.MaMau = MaMau;
        this.SoLuong = SoLuong;
    }

    public String getMaCTSP() {
        return MaCTSP;
    }

    public void setMaCTSP(String MaCTSP) {
        this.MaCTSP = MaCTSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMaSize() {
        return MaSize;
    }

    public void setMaSize(String MaSize) {
        this.MaSize = MaSize;
    }

    public String getMaMau() {
        return MaMau;
    }

    public void setMaMau(String MaMau) {
        this.MaMau = MaMau;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

}
