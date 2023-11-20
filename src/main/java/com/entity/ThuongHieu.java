/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author Thai
 */
public class ThuongHieu {

    private String MaThuongHieu;
    private String Ten;

    public ThuongHieu() {
    }
    
    public ThuongHieu(String MaThuongHieu, String Ten) {
        this.MaThuongHieu = MaThuongHieu;
        this.Ten = Ten;
    }

    public String getMaThuongHieu() {
        return MaThuongHieu;
    }

    public void setMaThuongHieu(String MaThuongHieu) {
        this.MaThuongHieu = MaThuongHieu;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

}
