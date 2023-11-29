/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author Thai
 */
public class Size extends ThuocTinh{

    private String MaSize;
    private String Ten;

    public Size() {
    }

    public Size(String MaSize, String Ten) {
        this.MaSize = MaSize;
        this.Ten = Ten;
    }

    @Override
    public String getMa() {
        return MaSize;
    }

    public void setMaSize(String MaSize) {
        this.MaSize = MaSize;
    }

    @Override
    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    public Object[] todatarowSiZe(){
        return  new Object[]{this.MaSize,this.Ten};
    }


}
