/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author Thai
 */
public class MauSac extends ThuocTinh{

    private String MaMauSac;
    private String Ten;

    public MauSac() {
    }

    public MauSac(String MaMauSac, String Ten) {
        this.MaMauSac = MaMauSac;
        this.Ten = Ten;
    }

    @Override
    public String getMa() {
        return MaMauSac;
    }

    public void setMaMauSac(String MaMauSac) {
        this.MaMauSac = MaMauSac;
    }

    @Override
    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    public Object[] todatarowMauSac(){
        return new Object[]{this.MaMauSac,this.Ten};
    }


}
