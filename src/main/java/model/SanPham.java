/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class SanPham {
    
    private String maSP;
    
    private String tenSP;
    
    private String hinh;
    
    private String maThuongHieu;
    
    private String maLoai;
    
    private String maXuatXu;
    
    private String maChatLieu;
    
    private Double gia;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String hinh, String maThuongHieu, String maLoai, String maXuatXu, String maChatLieu, Double gia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.hinh = hinh;
        this.maThuongHieu = maThuongHieu;
        this.maLoai = maLoai;
        this.maXuatXu = maXuatXu;
        this.maChatLieu = maChatLieu;
        this.gia = gia;
    }
   
    public SanPham(String maSP, String tenSP, String maThuongHieu, String maLoai, String maXuatXu, String maChatLieu, Double gia) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maThuongHieu = maThuongHieu;
        this.maLoai = maLoai;
        this.maXuatXu = maXuatXu;
        this.maChatLieu = maChatLieu;
        this.gia = gia;
    }

    public SanPham(String maThuongHieu, String maLoai, String maXuatXu, String maChatLieu, Double gia) {
        this.maThuongHieu = maThuongHieu;
        this.maLoai = maLoai;
        this.maXuatXu = maXuatXu;
        this.maChatLieu = maChatLieu;
        this.gia = gia;
    }
    

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(String maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getMaXuatXu() {
        return maXuatXu;
    }

    public void setMaXuatXu(String maXuatXu) {
        this.maXuatXu = maXuatXu;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(String maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    @Override
    public String toString() {
        return String.valueOf(this.gia);
    }
    
    public boolean equals(Object obj){
        SanPham sp = (SanPham) obj;
        return sp.getMaSP().equals(this.getMaSP());
    }
    
    
}
