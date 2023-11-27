/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.ChiTietSanPham;
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
public class ChiTietSanPhamDAO implements DAOInterface<ChiTietSanPham, String> {

    String SELECT_ALL_SQL = "select * from Chi_Tiet_San_Pham";
    String SELECT_BY_ID_SQL = "select * from Chi_Tiet_San_Pham where MaCTSP = ?";
    String SELECT_BY_SP_SQL = "select * from Chi_Tiet_San_Pham where MaSP = ?";
    String SELECT_So_Luong = "select * from Chi_Tiet_San_Pham where MaSP = ? and maMau = ? and maSize = ?";
    String SELECT_BY_SP_Mau_SQL = "select * from Chi_Tiet_San_Pham where MaSP = ? and maMau = ?";

    @Override
    public int insert(ChiTietSanPham entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(ChiTietSanPham entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(String key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietSanPham> selectAll() throws SQLException {
        return selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public ChiTietSanPham selectByID(String key) throws SQLException {
        List<ChiTietSanPham> list = selectBySQL(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChiTietSanPham> selectBySQL(String sql, Object... args) throws SQLException {
        List<ChiTietSanPham> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            ChiTietSanPham entity = new ChiTietSanPham();
            entity.setMaCTSP(rs.getString("maCTSP"));
            entity.setMaMau(rs.getString("MaMau"));
            entity.setMaSP(rs.getString("MaSP"));
            entity.setMaSize(rs.getString("MaSize"));
            entity.setSoLuong(rs.getInt("soLuong"));
            list.add(entity);
        }

        rs.getStatement().getConnection().close();
        return list;
    }

    public List<ChiTietSanPham> selectBySP(String key) throws SQLException {
        return selectBySQL(SELECT_BY_SP_SQL, key);
    }
    public List<ChiTietSanPham> selectBySPMau(String maSP, String mau) throws SQLException {
        return selectBySQL(SELECT_BY_SP_Mau_SQL, maSP,mau);
    }

    public int getSoLuong(String maSP, String mau, String size) {
        try {
            List<ChiTietSanPham> list = selectBySQL(SELECT_So_Luong, maSP, mau, size);
            if (list.isEmpty()) {
                return 0;
            }
            return list.get(0).getSoLuong();
        } catch (SQLException ex) {
            throw new Error("\n getSoLuong() ChiTietSanPhamDAO\n"+ex);
        }
    }
}
