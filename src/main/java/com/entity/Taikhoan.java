/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entity;

import model.*;
import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Taikhoan {
    private String taikhoan;
    private String matkhau;
    private String ten;
    private Date ngaysinh;
    private String sdt;
    private String email;
    private String CCCD;
    private boolean chucvu;

    public Taikhoan() {
    }

    public Taikhoan(String taikhoan, String matkhau, String ten, Date ngaysinh, String sdt, String email, String CCCD, boolean chucvu) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.email = email;
        this.CCCD = CCCD;
        this.chucvu = chucvu;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public boolean isChucvu() {
        return chucvu;
    }

    public void setChucvu(boolean chucvu) {
        this.chucvu = chucvu;
    }
    

    
}
