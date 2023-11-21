/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.ui.dangnhapJDialog;
import java.sql.Connection;
import java.sql.*;
import model.taikhoan;

/**
 *
 * @author DELL
 */
public class taikhoanDAO {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    String sql = null;

    public static boolean checkLogin(String taikhoan, String matkhau) {
        int row = 0;
      String  sql = "select TaiKhoan,MatKhau,Ten,NgaySinh,SDT,Email,CCCD,ChucVu from TAI_KHOAN where TaiKhoan = '" + taikhoan + "' and MatKhau='" + matkhau + "'";
        try {
           Connection con = com.utils.DBConnect.getConnection();
          PreparedStatement  ps = con.prepareStatement(sql);
          ResultSet  rs = ps.executeQuery();
            while (rs.next()) {
                row = 1;
                String tk = rs.getString(1);
                String mk = rs.getString(2);
                String ten = rs.getString(3);
                String ngaysinh = rs.getString(4);
                String sdt = rs.getString(5);
                String email = rs.getString(6);
                String cccd = rs.getString(7);
                boolean chucvu = rs.getBoolean(8);
                dangnhapJDialog.TaiKhoan = new taikhoan(tk, mk, ten, ngaysinh, sdt, email, cccd, true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (row > 0);
    }
}
