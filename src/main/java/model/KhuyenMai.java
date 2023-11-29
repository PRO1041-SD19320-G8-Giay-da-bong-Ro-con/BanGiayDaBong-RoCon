/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
/**
 *
 * @author FPT SHOP
 */
public class KhuyenMai {
    private String maKM;
    private String tenKM;
    private String noiDung;
    private boolean loaiKM;
    private float giamGia;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String tenKM, String noiDung) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.noiDung = noiDung;
    }
    

    public KhuyenMai(String maKM, String tenKM, String noiDung, boolean loaiKM, float giamGia, Date ngayBatDau, Date ngayKetThuc) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.noiDung = noiDung;
        this.loaiKM = loaiKM;
        this.giamGia = giamGia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    
    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public boolean isLoaiKM() {
        return loaiKM;
    }

    public void setLoaiKM(boolean loaiKM) {
        this.loaiKM = loaiKM;
    }

    public float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "maKM=" + maKM + ", tenKM=" + tenKM + ", noiDung=" + noiDung + ", loaiKM=" + loaiKM + ", giamGia=" + giamGia + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + '}';
    }
    
}
