/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

<<<<<<< HEAD
import com.entity.TaiKhoan;
import com.utils.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
=======
import com.ui.dangnhapJDialog;
import com.utils.Auth;
import com.utils.DBConnect;
import java.sql.Connection;
import java.sql.*;
>>>>>>> 27f1cc0a23977e2b318ae099e1333849fa1464bd
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thai
 */
public class TaiKhoanDAO implements DAOInterface<TaiKhoan, String> {

<<<<<<< HEAD
    String UPDATE_ThongTin_SQL = "UPDATE Tai_khoan SET ten = ? , ngaysinh = ?, sdt = ?, email = ? WHERE TaiKhoan = ?";
    String UPDATE_TaiKhoan_SQL = "UPDATE Tai_khoan SET matKhau = ? WHERE TaiKhoan = ?";
    String SELECT_ALL_SQL = "select * from Tai_khoan";
    String SELECT_BY_ID_SQL = "select * from Tai_khoan where taiKhoan = ?";
=======
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
        sql="update TAI_KHOAN set ten =?,NgaySinh =?,SDT=?,Email=? where taiKhoan =?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tk.getTen());
            ps.setObject(2, tk.getNgaysinh());
            ps.setObject(3, tk.getSdt());
            ps.setObject(4, tk.getEmail());
            ps.setObject(5, taikhoan);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
>>>>>>> 27f1cc0a23977e2b318ae099e1333849fa1464bd

    @Override
    public int insert(TaiKhoan entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(TaiKhoan entity) throws SQLException {
        return JDBCHelper.update(UPDATE_ThongTin_SQL, entity.getTen(), entity.getNgaysinh(), entity.getSdt(), entity.getEmail(), entity.getTaikhoan());
    }
    public int update(String key, String taiKhoan) throws SQLException {
        return JDBCHelper.update(UPDATE_TaiKhoan_SQL, key, taiKhoan);
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TaiKhoan> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public TaiKhoan selectByID(String key) throws SQLException {
        List<TaiKhoan> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TaiKhoan> selectBySQL(String sql, Object... args) throws SQLException {
        List<TaiKhoan> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            TaiKhoan entity = new TaiKhoan();
            entity.setTaikhoan(rs.getString("taiKhoan"));
            entity.setMatkhau(rs.getString("matkhau"));
            entity.setTen(rs.getString("ten"));
            entity.setNgaysinh(rs.getDate("ngaysinh"));
            entity.setSdt(rs.getString("sdt"));
            entity.setEmail(rs.getString("email"));
            entity.setCCCD(rs.getString("CCCD"));
            entity.setChucvu(rs.getBoolean("chucVu"));

            list.add(entity);
        }
        rs.getStatement().getConnection().close();
        return list;
    }

}
