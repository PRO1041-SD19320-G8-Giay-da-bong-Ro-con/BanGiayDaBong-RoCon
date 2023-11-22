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
public class Size {

    private String MaSize;
    private String Ten;

    public Size() {
    }

    public Size(String MaSize, String Ten) {
        this.MaSize = MaSize;
        this.Ten = Ten;
    }

    public String getMaSize() {
        return MaSize;
    }

    public void setMaSize(String MaSize) {
        this.MaSize = MaSize;
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
