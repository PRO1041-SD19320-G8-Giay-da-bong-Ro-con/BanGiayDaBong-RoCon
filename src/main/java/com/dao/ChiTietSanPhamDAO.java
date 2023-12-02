/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.entity.ChiTietSanPham;
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

    String INSERT_SQL = "INSERT INTO Chi_Tiet_San_Pham (MaCTSP,MaSP,MaSize,MaMau,SoLuong) VALUES(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE Chi_Tiet_San_Pham SET MaSize = ?, MaMau = ?, SoLuong = ? WHERE MaCTSP = ?";
    String SELECT_ALL_SQL = "select * from Chi_Tiet_San_Pham";
    String SELECT_BY_ID_SQL = "select * from Chi_Tiet_San_Pham where MaCTSP = ?";
    String SELECT_BY_SP_SQL = "select * from Chi_Tiet_San_Pham where MaSP = ?";
    String SELECT_So_Luong = "select * from Chi_Tiet_San_Pham where MaSP = ? and maMau = ? and maSize = ?";
    String SELECT_BY_SP_Mau_SQL = "select * from Chi_Tiet_San_Pham where MaSP = ? and maMau = ?";

    @Override
    public int insert(ChiTietSanPham entity) throws SQLException {
        return JDBCHelper.update(INSERT_SQL, entity.getMaCTSP(), entity.getMaSP(), entity.getMaSize(), entity.getMaMau(), entity.getSoLuong());
    }

    @Override
    public int update(ChiTietSanPham entity) throws SQLException {
        return JDBCHelper.update(UPDATE_SQL, entity.getMaSize(), entity.getMaMau(), entity.getSoLuong(), entity.getMaCTSP());
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
        return selectBySQL(SELECT_BY_SP_Mau_SQL, maSP, mau);
    }

    public int getSoLuong(String maSP, String mau, String size) {
        try {
            List<ChiTietSanPham> list = selectBySQL(SELECT_So_Luong, maSP, mau, size);
            if (list.isEmpty()) {
                return 0;
            }
            return list.get(0).getSoLuong();
        } catch (SQLException ex) {
            throw new Error("\n getSoLuong() ChiTietSanPhamDAO\n" + ex);
        }
    }

    public int luu(ChiTietSanPham entity) throws SQLException {
        for (ChiTietSanPham ctsp : selectAll()) {
            if (ctsp.getMaCTSP().equalsIgnoreCase(entity.getMaCTSP())) {
                return update(entity);
            }
        }
        return insert(entity);
    }

    public List<Object[]> getAllSanPhamChiTiet(String[] cols) throws SQLException {
        String sql = "Select * from vThongTinSanPham where soLuong > 0";
        return getListObject(sql,cols);
    }
    
        public Object[] getSanPhamChiTiet(String id , String[] cols) throws SQLException {
        String sql = "Select * from vThongTinSanPham where mactsp = '"+id+"'";
        return getListObject(sql,cols).get(0);
    }

    public List<Object[]> getListObject(String sql, String[] cols, String... args) throws SQLException {
        List<Object[]> list = new ArrayList<>();
        ResultSet rs = JDBCHelper.query(sql, args);
        while (rs.next()) {
            Object[] vals = new Object[cols.length];
            for (int i = 0; i < cols.length; i++) {
                vals[i] = rs.getObject(cols[i]);
            }
            list.add(vals);
        }
        rs.getStatement().getConnection().close();
        return list;
    }
}
