/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.SanPham;
import com.entity.ThuongHieu;
import com.utils.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thai
 */
public class ThuongHieuDAO implements DAOInterface<ThuongHieu, String> {

    String SELECT_NAME_BY_ID_SQL = "Select ten from Thuong_hieu where maThuongHieu = ?";
    String SELECT_ALL_SQL = "select * from Thuong_hieu";
    String SELECT_BY_ID_SQL = "select * from Thuong_hieu where maThuongHieu = ?";

    @Override
    public int insert(ThuongHieu entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(ThuongHieu entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ThuongHieu> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public ThuongHieu selectByID(String key) throws SQLException {
        List<ThuongHieu> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ThuongHieu> selectBySQL(String sql, Object... args) throws SQLException {
        List<ThuongHieu> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            ThuongHieu entity = new ThuongHieu();
            entity.setMaThuongHieu(rs.getString("MaThuongHieu"));
            entity.setTen(rs.getString("Ten"));
            list.add(entity);
        }

        rs.getStatement().getConnection().close();
        return list;

    }

}
