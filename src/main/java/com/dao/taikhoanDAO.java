/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.ui.dangnhapJDialog;
import com.utils.Auth;
import com.utils.DBConnect;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.taikhoan;

/**
 *
 * @author DELL
 */
public class taikhoanDAO implements DAOInterface<taikhoan, String>{

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
                Date ngaysinh = rs.getDate(4);
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
    public List<taikhoan> getall(){
        sql="select TaiKhoan,MatKhau,Ten,NgaySinh,SDT,Email,CCCD,ChucVu from TAI_KHOAN";
        List<taikhoan> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                taikhoan tk = new taikhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
                list.add(tk);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int update(taikhoan tk , String taikhoan){
        sql="update TAI_KHOAN set ten =?,NgaySinh =?,SDT=? where TAI_KHOAN =?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tk.getTen());
            ps.setObject(2, tk.getNgaysinh());
            ps.setObject(3, tk.getSdt());
            ps.setObject(4, taikhoan);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int insert(taikhoan entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(taikhoan entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<taikhoan> selectAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public taikhoan selectByID(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<taikhoan> selectBySQL(String sql, Object... args) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
