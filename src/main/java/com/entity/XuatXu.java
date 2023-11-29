/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

/**
 *
 * @author Thai
 */
public class XuatXu extends ThuocTinh{

    private String MaXuatXu;
    private String Ten;

    public XuatXu() {
    }

    public XuatXu(String MaXuatXu, String Ten) {
        this.MaXuatXu = MaXuatXu;
        this.Ten = Ten;
    }

    @Override
    public String getMa() {
        return MaXuatXu;
    }

    public void setMaXuatXu(String MaXuatXu) {
        this.MaXuatXu = MaXuatXu;
    }

    @Override
    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    public Object[] todatarowXuatXu(){
        return new Object[]{this.MaXuatXu,this.Ten};
    }
}
