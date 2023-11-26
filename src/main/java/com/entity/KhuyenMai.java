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
public class KhuyenMai {

    private String MaKM;
    private String Ten;
    private String NoiDung;
    private boolean LoaiKM;
    private double GiamGia;
    private Date ThoiGianBatDau;
    private Date ThoiGianKetThuc;

    public KhuyenMai() {
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public boolean isLoaiKM() {
        return LoaiKM;
    }

    public void setLoaiKM(boolean LoaiKM) {
        this.LoaiKM = LoaiKM;
    }

    public double getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(double GiamGia) {
        this.GiamGia = GiamGia;
    }

    public Date getThoiGianBatDau() {
        return ThoiGianBatDau;
    }

    public void setThoiGianBatDau(Date ThoiGianBatDau) {
        this.ThoiGianBatDau = ThoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return ThoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date ThoiGianKetThuc) {
        this.ThoiGianKetThuc = ThoiGianKetThuc;
    }

}
