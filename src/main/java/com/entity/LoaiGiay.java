/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author Thai
 */
public class LoaiGiay extends ThuocTinh{

    private String MaLoai;
    private String Ten;

    public LoaiGiay() {
    }

    @Override
    public String getMa() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    @Override
    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

}
