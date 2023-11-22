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
    
    private ChiTietSanPham ctsp;
    
    private String maSize;
    
    private String maMau;
    
    private int soLuong;

    public SanPham(String maSP, String tenSP, String maThuongHieu, String maLoai, String maXuatXu, String maChatLieu, Double gia, String maSize, String maMau, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maThuongHieu = maThuongHieu;
        this.maLoai = maLoai;
        this.maXuatXu = maXuatXu;
        this.maChatLieu = maChatLieu;
        this.gia = gia;
        this.maSize = maSize;
        this.maMau = maMau;
        this.soLuong = soLuong;
    }

    
    
    
    
    
   

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

    public ChiTietSanPham getCtsp() {
        return ctsp;
    }

    public void setCtsp(ChiTietSanPham ctsp) {
        this.ctsp = ctsp;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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
