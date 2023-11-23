/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.entity.*;

/**
 *
 * @author Thai
 */
public class ChiTietSanPham extends SanPham{

    private String MaCTSP;
    private String MaSp;
    private String MaSize;
    private String MaMau;
    private int SoLuong;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String MaCTSP, String MaSp, String MaSize, String MaMau, int SoLuong) {
        this.MaCTSP = MaCTSP;
        this.MaSp = MaSp;
        this.MaSize = MaSize;
        this.MaMau = MaMau;
        this.SoLuong = SoLuong;
    }

    public ChiTietSanPham(String MaCTSP, String MaSp, String MaSize, String MaMau, int SoLuong, String maThuongHieu, String maLoai, String maXuatXu, String maChatLieu, Double gia) {
        super(maThuongHieu, maLoai, maXuatXu, maChatLieu, gia);
        this.MaCTSP = MaCTSP;
        this.MaSp = MaSp;
        this.MaSize = MaSize;
        this.MaMau = MaMau;
        this.SoLuong = SoLuong;
    }

    public ChiTietSanPham(String MaSize, String MaMau, int SoLuong, String maSP, String tenSP, String maThuongHieu, String maLoai, String maXuatXu, String maChatLieu, Double gia) {
        super(maSP, tenSP, maThuongHieu, maLoai, maXuatXu, maChatLieu, gia);
        this.MaSize = MaSize;
        this.MaMau = MaMau;
        this.SoLuong = SoLuong;
    }

    public ChiTietSanPham(String MaCTSP, String MaSize, String MaMau, int SoLuong, String maSP, String tenSP, String maThuongHieu, String maLoai, String maXuatXu, String maChatLieu, Double gia) {
        super(maSP, tenSP, maThuongHieu, maLoai, maXuatXu, maChatLieu, gia);
        this.MaCTSP = MaCTSP;
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

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String MaSP) {
        this.MaSp = MaSP;
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
