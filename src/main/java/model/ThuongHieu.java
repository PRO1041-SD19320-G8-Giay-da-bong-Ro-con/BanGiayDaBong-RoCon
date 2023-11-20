/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class ThuongHieu {
    private String maThuongHieu;
    private String ten;

    public ThuongHieu() {
    }

    public ThuongHieu(String maThuongHieu, String ten) {
        this.maThuongHieu = maThuongHieu;
        this.ten = ten;
    }

    public String getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(String maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return this.getTen();
    }
    
    
    
}
