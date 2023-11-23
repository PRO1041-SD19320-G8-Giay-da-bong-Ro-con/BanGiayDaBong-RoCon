/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.TaiKhoan;
import com.utils.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thai
 */
public class TaiKhoanDAO implements DAOInterface<TaiKhoan, String> {

    String UPDATE_ThongTin_SQL = "UPDATE Tai_khoan SET ten = ? , ngaysinh = ?, sdt = ?, email = ? WHERE TaiKhoan = ?";
    String UPDATE_TaiKhoan_SQL = "UPDATE Tai_khoan SET matKhau = ? WHERE TaiKhoan = ?";
    String SELECT_ALL_SQL = "select * from Tai_khoan";
    String SELECT_BY_ID_SQL = "select * from Tai_khoan where taiKhoan = ?";

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
