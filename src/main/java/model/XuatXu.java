/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.entity.*;

/**
 *
 * @author Thai
 */
public class XuatXu {

    private String MaXuatXu;
    private String Ten;

    public XuatXu() {
    }

    public XuatXu(String MaXuatXu, String Ten) {
        this.MaXuatXu = MaXuatXu;
        this.Ten = Ten;
    }

    public String getMaXuatXu() {
        return MaXuatXu;
    }

    public void setMaXuatXu(String MaXuatXu) {
        this.MaXuatXu = MaXuatXu;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    @Override
    public String toString() {
        return this.getTen();
    }
    
    
    

}
