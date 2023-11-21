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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thai
 */
public class SanPhamDAO implements DAOInterface<SanPham, String> {

    String SELECT_ALL_SQL = "select * from San_Pham";
    String SELECT_BY_ID_SQL = "select * from San_Pham where masp = ?";

    @Override
    public int insert(SanPham entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(SanPham entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPham> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public SanPham selectByID(String key) throws SQLException {
        List<SanPham> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPham> selectBySQL(String sql, Object... args) throws SQLException {
        List<SanPham> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            SanPham entity = new SanPham();
            entity.setMaSP(rs.getString("MaSP"));
            entity.setTenSP(rs.getString("TenSP"));
            entity.setHinh(rs.getString("Hinh"));
            entity.setMaThuongHieu(rs.getString("MaThuongHieu"));
            entity.setMaXuatXu(rs.getString("MaXuatXu"));
            entity.setMaChatLieu(rs.getString("MaChatLieu"));
            entity.setMaLoai(rs.getString("MaLoai"));
            entity.setGia(rs.getDouble("Gia"));
            list.add(entity);
        }

        rs.getStatement().getConnection().close();
        return list;

    }
    
    public ThuongHieu getThuongHieu (String id){
        try {
            return new ThuongHieuDAO().selectByID(id);
        } catch (SQLException ex) {
            throw new Error();
        }
    }
}