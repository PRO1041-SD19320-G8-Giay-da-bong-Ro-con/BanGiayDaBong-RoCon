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

    public LoaiGiay(String MaLoai, String Ten) {
        this.MaLoai = MaLoai;
        this.Ten = Ten;
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
    public Object[] todatarowLoaiGiay(){
        return new Object[]{this.MaLoai,this.Ten};
    }
}
