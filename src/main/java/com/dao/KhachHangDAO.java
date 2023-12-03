/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.KhachHang;
import com.utils.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thai
 */
public class KhachHangDAO implements  DAOInterface<KhachHang, String>{
    
    String SELECT_ALL_SQL = "select * from Khach_Hang";
    String SELECT_BY_ID_SQL = "select * from Khach_Hang where MAKH = ?";

    @Override
    public int insert(KhachHang entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(KhachHang entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhachHang> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public KhachHang selectByID(String key) throws SQLException {
        List<KhachHang> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang> selectBySQL(String sql, Object... args) throws SQLException {
        List<KhachHang> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            KhachHang entity = new KhachHang();
            entity.setMaKH(rs.getString("maKH"));
            entity.setTenKH(rs.getString("tenKH"));
            entity.setSdt(rs.getString("sdt"));
            entity.setDiaChi(rs.getString("diaChi"));
            entity.setNgaySinh(rs.getDate("ngaySinh"));
            list.add(entity);
        }

        rs.getStatement().getConnection().close();
        return list;
    }
}
